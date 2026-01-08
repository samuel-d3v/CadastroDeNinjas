package br.com.samueloliveira.CadastroDeNinjas.missoes;

import br.com.samueloliveira.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Dificuldade rank;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    public MissionModel(){
    }

    public MissionModel(String nome, Dificuldade rank) {
        this.nome = nome;
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Dificuldade getRank() {
        return rank;
    }
}
