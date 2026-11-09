package oit.is.z3420.kaizi.janken.service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z3420.kaizi.janken.model.Match;
import oit.is.z3420.kaizi.janken.model.MatchMapper;

@Service
public class AsyncKekka {

  private final Logger logger = LoggerFactory.getLogger(AsyncKekka.class);

  @Autowired
  private MatchMapper matchMapper;

  @Async
  public void asyncKekka(SseEmitter emitter) {
    logger.info("AsyncKekka.asyncKekka started");
    try {
      while (true) {

        ArrayList<Match> activeMatches = matchMapper.selectActiveMatches();

        if (activeMatches != null && !activeMatches.isEmpty()) {

          emitter.send(activeMatches);


          for (Match m : activeMatches) {
            matchMapper.updateIsActiveToFalse(m.getId());
          }
        }


        TimeUnit.SECONDS.sleep(1);
      }
    } catch (Exception e) {
      logger.warn("Exception: " + e.getClass().getName() + ":" + e.getMessage());
      emitter.complete();
    }
  }
}
