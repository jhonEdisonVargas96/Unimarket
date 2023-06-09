package co.edu.uniquindio.uniMarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Compra implements Serializable {
    @Id
    //autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    //Fecha not null y que se autocrea
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_creacion;

    @Column(nullable = false)
    private float valorTotal;

    //para dejar el atributo no null
    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private MetodoPago medioPago;


    @OneToMany(mappedBy = "compraDT")
    private List<DetalleCompra> detalleCompras;



}
