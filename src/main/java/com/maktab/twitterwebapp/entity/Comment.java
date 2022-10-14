package com.maktab.twitterwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Timestamp createdDate;
    @ManyToOne
    private Tweet tweet;
    @ManyToOne
    private Account account;
}
