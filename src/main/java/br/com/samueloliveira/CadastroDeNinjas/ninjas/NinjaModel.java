package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro_ninjas")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private int idade;
    private String email;

    public NinjaModel(){
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "NinjaEntity [nome=" + nome + ", idade=" + idade + ", email=" + email + "]";
    }
}
