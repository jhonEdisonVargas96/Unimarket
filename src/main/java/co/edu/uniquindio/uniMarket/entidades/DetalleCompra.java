package co.edu.uniquindio.uniMarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class DetalleCompra implements Serializable {
    @Id
    //autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    //para dejar el atributo no null
    @Column(nullable = false)
    private float precioProducto;

    @Positive
    //para dejar el atributo not null
    @Column(nullable = false)
    private Integer unidades;

    @ManyToOne
    private Producto productoDT;
    @ManyToOne
    private Compra compraDT;



}
