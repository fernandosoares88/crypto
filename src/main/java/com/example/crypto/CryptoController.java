package com.example.crypto;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CryptoController {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    @PreAuthorize("!isAuthenticated()")
    public String crypto(String texto, RedirectAttributes attributes){
        attributes.addFlashAttribute("crypto", encoder.encode(texto));
        return "redirect:/";
    }

}
