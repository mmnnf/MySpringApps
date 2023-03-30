package com.example.ders1_2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer year;
    @JsonIgnore
    @ManyToOne (cascade = CascadeType.PERSIST)/// cox kitab 1 tene type qarsiliq gelir
   // @ToString.Exclude
    private book_type type;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    //@ToString.Exclude
    private author author;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
//    @ManyToOne
   // @ToString.Exclude
    private publisher publisher;


}
