package com.csc340.jpacrudassignment.cat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ro Mei
 */
@Entity
@Table(name = "cat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String breed;
    private double age;

    public Cat(String name, String breed, double age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

}
