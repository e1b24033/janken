package oit.is.z3420.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z3420.kaizi.janken.model.Janken;

@Controller
public class JankenController {
  @GetMapping("/janken")
  public String jankenGet() {
    return "janken";
  }

  @PostMapping("/janken")
  public String janken(@RequestParam String name, ModelMap model) {
    model.addAttribute("name", name);
    return "janken.html";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam("hand") String hand, ModelMap model) {
    Janken janken = new Janken(hand);
    model.addAttribute("playerHand", janken.getPlayerHand());
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("result", janken.getResult());
    return "janken";
  }
}
