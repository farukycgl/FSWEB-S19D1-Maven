package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.services.VegetableServiceImpl;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> get(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public VegetableResponse getById(@Positive(message = "id sıfırdan küçük olamaz!") @PathVariable("id") Long id){
        return new VegetableResponse("id bulundu.", vegetableService.getBYId(id));
    }

    @GetMapping("/desc")
    public List<Vegetable> getDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/vegetable/{name}")
    public List<Vegetable> getByName(@Size(min=2, max=45, message = "isim 2 ile 45 karakter aralığında olmalıdır.") @PathVariable("name") String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@NotNull @Positive @PathVariable Long id){
        return vegetableService.delete(id);
    }
}
