package com.aynna.model;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@ManagedBean(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;
}

