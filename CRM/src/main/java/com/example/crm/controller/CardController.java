package com.example.crm.controller;

import com.example.crm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;
    @PostMapping("/card")
    public String createCard(@RequestParam Integer id, @RequestParam String image,
                             @RequestParam Integer account, @RequestParam String studentId){
        cardService.createCard(id, image, account, studentId);
        return "success";
    }

    @PutMapping("/card")
    public String updateCard(@RequestParam Integer id, @RequestParam Integer account){
        cardService.updateCard(id, account);
        return "success";
    }
}
