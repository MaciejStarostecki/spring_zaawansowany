package pl.strefakursow.spring_zaawansowany.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Data
@Table(name="Item")
@NoArgsConstructor @AllArgsConstructor
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private Integer quantity;

}
