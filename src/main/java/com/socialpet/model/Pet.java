package com.socialpet.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JoinTable(name = "pet_vacina",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "vacina_id"))
    private List<Vacina> vacinas;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public String getRestricaoAlimentar() { return restricaoAlimentar; }
    public void setRestricaoAlimentar(String restricaoAlimentar) { this.restricaoAlimentar = restricaoAlimentar; }
    public Dono getDono() { return dono; }
    public void setDono(Dono dono) { this.dono = dono; }
    public List<Vacina> getVacinas() { return vacinas; }
    public void setVacinas(List<Vacina> vacinas) { this.vacinas = vacinas; }
}
