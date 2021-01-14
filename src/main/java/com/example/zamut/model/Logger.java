package com.example.zamut.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String message;
    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    public Logger() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
