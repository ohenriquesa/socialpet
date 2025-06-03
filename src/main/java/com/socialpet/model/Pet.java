package com.socialpet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private String restricaoAlimentar;

    @ManyToOne
    @JoinColumn(name = "dono_id")
    @JsonBackReference
    private Dono dono;

    @ManyToMany
    @JoinTable(name = "pet_vacina", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "vacina_id"))
    private List<Vacina> vacinas;

}
