package com.efarda.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Entity
@Data
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "insert_date")
    private Timestamp insertDate;

}
