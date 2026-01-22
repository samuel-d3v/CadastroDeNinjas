package br.com.samueloliveira.CadastroDeNinjas.ninjas;

public class RegisterNinjaForm {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String imagemUrl;
    private String level;
    private Long missionId;

    public RegisterNinjaForm() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getMission() {
        return this.missionId;
    }

    public void setMission(Long missao) {
        this.missionId = missao;
    }
}
