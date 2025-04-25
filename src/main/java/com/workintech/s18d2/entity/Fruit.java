package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "fruit", schema = "fsweb")
public class Fruit extends Plant {

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "fruit_type")
    private FruitType fruitType;


}
