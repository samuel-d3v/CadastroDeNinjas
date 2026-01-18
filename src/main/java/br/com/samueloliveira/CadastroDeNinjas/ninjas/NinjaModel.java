package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import br.com.samueloliveira.CadastroDeNinjas.missoes.MissionModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "tb_cadastro_ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O nome é obrigatório.")
    private String nome;
    private int idade;

    @Column(unique = true)
    @NotBlank (message = "O e-mail é obrigatório.")
    @Email (message = "O formato do email é inválido.")
    private String email;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissionModel missao;

    @Column (name = "level")
    private String level;
}
