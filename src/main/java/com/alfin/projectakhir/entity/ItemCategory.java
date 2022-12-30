package com.alfin.projectakhir.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_category")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "img_url")
    private String img;

    @NotBlank
    @Column(name = "name_item")
    private String nameItem;

    @NotBlank
    @Column(name = "prices")
    private int prices;

    @ManyToMany(mappedBy = "itemCategories")
    @JsonIgnore
    private List<Transaction> transactions;
}
