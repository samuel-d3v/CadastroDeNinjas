package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import br.com.samueloliveira.CadastroDeNinjas.missoes.MissionModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro_ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String nome;
    private int idade;

    @Column(unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissionModel missao;

}
