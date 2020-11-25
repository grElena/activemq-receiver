package com.example.activemqreceiver.service.jpa;

import com.example.activemqreceiver.domain.Message;
import com.example.activemqreceiver.repository.MessageRepository;
import com.example.activemqreceiver.service.MessageService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("messageService")
@Repository
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Transactional(readOnly=true)
    public List<Message> findAll() {
        return  Lists.newArrayList(messageRepository.findAll());
    }

    @Transactional(readOnly=true)
    public Message findById(Long id) {
        return messageRepository.findById(id).get();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
