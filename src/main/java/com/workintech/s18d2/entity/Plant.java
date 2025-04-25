package com.workintech.s18d2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Plant {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull(message = "isim boş bırakılamaz!")
    @Size(min=2, max=45, message = "isim 2 ile 45 karakter aralığında olmalıdır.")
    @Column(name = "name")
    private String name;

    @DecimalMin("10")
    @Column(name = "price")
    private Double price;
}
