package com.sidenis.timemaster.rest.vo;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Day {
    private int code_id;
    private List<String> assignments;
    private String wdate;
    private int start_time;
    private int stop_time;
    private int break_time;
    private String comment;
    private int month_day;
    private List<Message> messages;

    @Override
    public String toString() {
        return "Day{" + "\n" +
                "code_id=" + code_id + "\n" +
                ", assignments=" + assignments + "\n" +
                ", wdate='" + wdate + '\'' + "\n" +
                ", start_time=" + start_time + "\n" +
                ", stop_time=" + stop_time + "\n" +
                ", break_time=" + break_time + "\n" +
                ", comment='" + comment + '\'' + "\n" +
                ", month_day=" + month_day + "\n" +
                ", messages=" + messages + "\n" +
                '}';
    }

    public int getCode_id() {
        return code_id;
    }

    public void setCode_id(int code_id) {
        this.code_id = code_id;
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<String> assignments) {
        this.assignments = assignments;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getStop_time() {
        return stop_time;
    }

    public void setStop_time(int stop_time) {
        this.stop_time = stop_time;
    }

    public int getBreak_time() {
        return break_time;
    }

    public void setBreak_time(int break_time) {
        this.break_time = break_time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMonth_day() {
        return month_day;
    }

    public void setMonth_day(int month_day) {
        this.month_day = month_day;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return code_id == day.code_id &&
                start_time == day.start_time &&
                stop_time == day.stop_time &&
                break_time == day.break_time &&
                month_day == day.month_day &&
                Objects.equals(assignments, day.assignments) &&
                Objects.equals(wdate, day.wdate) &&
                Objects.equals(comment, day.comment) &&
                Objects.equals(messages, day.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code_id, assignments, wdate, start_time, stop_time, break_time, comment, month_day, messages);
    }
}
