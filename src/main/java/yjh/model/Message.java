package yjh.model;

import org.springframework.stereotype.Component;

@Component
public class Message {

    private Integer messageId;
    private Integer userId;
    private String message;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                '}';
    }
}
