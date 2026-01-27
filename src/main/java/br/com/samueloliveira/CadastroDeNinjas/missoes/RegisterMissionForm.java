package br.com.samueloliveira.CadastroDeNinjas.missoes;

public class RegisterMissionForm {
    private Long id;
    private String nome;
    private Dificuldade rank;

    public RegisterMissionForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dificuldade getDificuldade(){return rank;}

    public void setDificuldade(Dificuldade rank) {
        this.rank = rank;
    }
}
