package net.eurovision.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "name")
    private String name;
    
}