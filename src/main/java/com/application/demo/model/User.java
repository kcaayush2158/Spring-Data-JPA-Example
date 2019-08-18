package com.application.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    public int id;
    public String name;
    public String profession;
    public int age;


}
