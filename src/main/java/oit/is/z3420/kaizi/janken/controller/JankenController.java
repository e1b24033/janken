package oit.is.z3420.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.ui.ModelMap;

import oit.is.z3420.kaizi.janken.model.Entry;
import oit.is.z3420.kaizi.janken.model.Janken;
import oit.is.z3420.kaizi.janken.model.Match;
import oit.is.z3420.kaizi.janken.model.MatchMapper;
import oit.is.z3420.kaizi.janken.model.User;
import oit.is.z3420.kaizi.janken.model.UserMapper;

@Controller
public class JankenController {
  @Autowired
  private Entry entry;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private MatchMapper matchMapper;

  @GetMapping("/janken")
  public String jankenGet(Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    entry.addUser(loginUser);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("room", entry);
    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users", users);
    ArrayList<Match> matches = matchMapper.selectAllMatches();
    model.addAttribute("matches", matches);
    return "janken";
  }

  @PostMapping("/janken")
  public String janken(@RequestParam String name, Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    entry.addUser(loginUser);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("room", entry);
    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users", users);
    return "janken";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam("hand") String hand, Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    entry.addUser(loginUser);

    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users", users);

    ArrayList<Match> matches = matchMapper.selectAllMatches();
    model.addAttribute("matches", matches);

    Janken janken = new Janken(hand);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("room", entry);
    model.addAttribute("playerHand", janken.getPlayerHand());
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("result", janken.getResult());
    return "janken";
  }
}
