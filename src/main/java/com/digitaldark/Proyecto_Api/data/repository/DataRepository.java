package com.digitaldark.Proyecto_Api.data.repository;

import com.digitaldark.Proyecto_Api.data.model.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<DataEntity, Integer> {
    List<DataEntity> findAll();

    DataEntity findById(int id);
}
