package yjh.service;

import org.springframework.stereotype.Service;
import yjh.dao.*;
import yjh.model.Message;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageService {

    @Resource
    private MessageDAO messageDAO;
    @Resource
    private UserDAO userDAO;

    public int addMessage(Message message) {
        return messageDAO.addMessage(message);
    }

    public List<Message> getMine(int userId) {
        List<Message> messages = messageDAO.getMine(userId);
        return messages;
    }

    public int deleteById(int messageId) {
        return messageDAO.deleteById(messageId);
    }


    public Message getById(int messageId) {
        return messageDAO.getById(messageId);
    }


}
