package com.example.activemqreceiver.service;

import com.example.activemqreceiver.domain.Message;

import java.util.List;

public interface MessageService {
    public List<Message> findAll();
    public Message findById(Long id);
    public Message save(Message message);
    public void delete(Long id);
}
