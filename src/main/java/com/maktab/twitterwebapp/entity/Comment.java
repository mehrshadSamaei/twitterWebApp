package com.maktab.twitterwebapp.entity;

import lombok.*;

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
    @GeneratedValue
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
