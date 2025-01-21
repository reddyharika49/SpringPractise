package com.example.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    
    @Id
    @GeneratedValue
    private int id;
    @NotNull()
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters") 
    private String name;
    @NotNull() 
    @Size(min = 1, max = 50, message = "Standard must be between 1 and 50 characters")
    private String standard;
    private String favSport;

    // Getters and Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getStandard() {
//        return standard;
//    }
//
//    public void setStandard(String standard) {
//        this.standard = standard;
//    }
//
//    public String getFavSport() {
//        return favSport;
//    }
//
//    public void setFavSport(String favSport) {
//        this.favSport = favSport;
//    }
}
