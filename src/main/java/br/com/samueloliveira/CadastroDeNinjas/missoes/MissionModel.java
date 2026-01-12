package br.com.samueloliveira.CadastroDeNinjas.missoes;

import br.com.samueloliveira.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Dificuldade rank;
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

}
