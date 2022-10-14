package com.maktab.twitterwebapp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "tweet")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tweet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    @Column(name = "content" , length = 280)
    private String content;
    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Timestamp createdDate;
    @ManyToOne
    @Column(name = "account_owner")
    private Account accountOwner;
    @ElementCollection
    @Column(name = "accounts_id")
    private Set<Long> accountsId;
}
