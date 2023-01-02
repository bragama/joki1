package com.project.projectakhir.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "transactions")
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id",name = "id_user", nullable = false)
    private User user;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "transactions_to_item_categories",
            joinColumns = @JoinColumn(name = "item_category", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id")
    )
    private List<ItemCategory> itemCategories;

    @JoinColumn(name = "price")
    private int price;

    @JoinColumn(name = "total")
    private int total;


    @JsonFormat(pattern = "dd-MM-yyyy hh:MM:ss")
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
}
