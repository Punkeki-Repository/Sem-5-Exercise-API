package com.digitaldark.Proyecto_Api.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "data")
public class DataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "company", nullable = false, length = 50)
    private String company;

    @Column(name = "company_url", nullable = false, length = 250)
    private String companyUrl;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "title", nullable = false, length = 50)
    private String title;
}
