package com.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class footerController {

  @GetMapping("/fb")
  public String redirectToFacebook() {
    return "redirect:https://www.facebook.com/Ritu1498?mibextid=LQQJ4d";
  }
  @GetMapping("/twitter")
  public String redirectToTwitter() {
    return "redirect:https://twitter.com/RituGos50827782";
  }
  @GetMapping("/discord")
  public String discord() {
    return "redirect:https://discord.com/users/%C5%87M%E4%B9%84%CE%B2%E2%82%AC%C4%85$%C5%A3#1688";
  }
  @GetMapping("/insta")
  public String insta() {
	  return "redirect:https://www.instagram.com/ritu.goswami_";
  }
  @GetMapping("/ln")
  public String ln() {
	  return "redirect:https://www.linkedin.com/in/ritu-ranjan-756571190/";
  }
  
  @GetMapping("/git")
  public String git() {
	  return "redirect:https://github.com/Ritu-ranjan14";
  }
  
  

}

