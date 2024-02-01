package com.example.crm.service;

import com.example.crm.dao.CardDao;
import com.example.crm.dao.StudentDao;
import com.example.crm.model.Card;
import com.example.crm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardImplement implements CardService{

    @Autowired // Dependency injection
    private CardDao cardDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public void createCard(Integer id, String image, Integer account, String studentId) {
        Card card = new Card();
        card.setId(id);
        card.setImage(image);
        card.setAccount(account);
        Optional<Student> optionalStudent = studentDao.findById(studentId);
        if(optionalStudent.isPresent()){
            card.setStudent(optionalStudent.get());
        }else throw new RuntimeException(String.format("student %s not found!", studentId));
        cardDao.save(card);
    }

    @Override
    public void updateCard(Integer id, Integer account) {
        Optional<Card> optionalCard = cardDao.findById(id);
        if(optionalCard.isPresent()){
            Card card = optionalCard.get();
            card.setAccount(account);
            cardDao.save(card);
        }
    }
}
