package com.sidenis.timemaster.rest.vo;

import java.util.Objects;

public class Message {
    private String text;
    private String message_type;

    @Override
    public String toString() {
        return "{" + "\n" +
                "   text='" + text + '\'' + "\n" +
                "   , message_type='" + message_type + '\'' + "\n" +
                '}';
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getMessage_type() { return message_type; }

    public void setMessage_type(String message_type) { this.message_type = message_type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(text, message.text) &&
                Objects.equals(message_type, message.message_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, message_type);
    }
}
