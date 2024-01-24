package com.library.management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length=100,nullable=false)
	@NotBlank(message="Title of book name cannot be null")
    private String title;
	@Column(length=100,nullable=false)
	@NotBlank(message="Author of book name cannot be null")
    private String author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;
}
