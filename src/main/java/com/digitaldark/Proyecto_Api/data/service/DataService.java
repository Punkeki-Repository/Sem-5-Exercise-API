package com.digitaldark.Proyecto_Api.data.service;

import com.digitaldark.Proyecto_Api.data.dto.request.DataRequestDTO;
import com.digitaldark.Proyecto_Api.data.dto.response.DataResponseDTO;

import java.util.List;

public interface DataService {

    public abstract DataResponseDTO createData(DataRequestDTO data);
    public abstract List<DataResponseDTO> getAllData();

    public abstract List<DataResponseDTO> getDataByDescription(String word);
}
