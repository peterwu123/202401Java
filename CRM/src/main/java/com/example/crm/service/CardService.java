package com.example.crm.service;

import com.example.crm.model.Card;

public interface CardService {

    void createCard(Integer id, String image, Integer account, String studentId);
    void updateCard(Integer id, Integer account);
}
