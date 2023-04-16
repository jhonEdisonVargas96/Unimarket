package co.edu.uniquindio.uniMarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Usuario  extends Persona implements Serializable {

    //para dejar el atributo not null y con un tamaño de caracteres
    @Column(nullable = false, length = 100)
    private String direccion;

    //para dejar el atributo not null y con un tamaño de caracteres
    @Column(nullable = false, length = 12)
    private String telefono;

    @ManyToMany
    @JoinTable(name = "favorito")
    private List<Producto> favoritos;

    @OneToMany(mappedBy = "vendedor")

    private List<Producto> productos;

    @OneToMany(mappedBy = "usuarioCOM")

    private List<Comentario> usuarioComentario;

    @OneToOne(mappedBy = "usuario")
    private CuentaPremium cuentaPremium;

    @OneToMany(mappedBy = "usuario")

    private List<CentroAyuda> centroAyuda;

    @OneToMany(mappedBy = "usuario")

    private List<Compra> compra;


}
