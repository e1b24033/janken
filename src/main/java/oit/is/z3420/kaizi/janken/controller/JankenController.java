package oit.is.z3420.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z3420.kaizi.janken.model.Entry;
import oit.is.z3420.kaizi.janken.model.Janken;

@Controller
public class JankenController {
  @Autowired
  private Entry entry;

  @GetMapping("/janken")
  public String jankenGet(Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    entry.addUser(loginUser);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("room", entry);
    return "janken";
  }

  @PostMapping("/janken")
  public String janken(@RequestParam String name, Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    entry.addUser(loginUser);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("room", entry);
    return "janken";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam("hand") String hand, Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    entry.addUser(loginUser);

    Janken janken = new Janken(hand);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("room", entry);
    model.addAttribute("playerHand", janken.getPlayerHand());
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("result", janken.getResult());
    return "janken";
  }
}
