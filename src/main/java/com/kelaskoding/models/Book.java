package com.kelaskoding.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tbl_books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @ElementCollection
    @CollectionTable(name = "tbl_tags", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "tags")
    private List<String> tags;
}
