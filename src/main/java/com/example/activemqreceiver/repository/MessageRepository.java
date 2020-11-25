package com.example.activemqreceiver.repository;

import com.example.activemqreceiver.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Long> {
}
