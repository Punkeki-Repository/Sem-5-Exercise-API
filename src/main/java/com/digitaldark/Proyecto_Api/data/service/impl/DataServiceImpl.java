package com.digitaldark.Proyecto_Api.data.service.impl;

import com.digitaldark.Proyecto_Api.data.dto.request.DataRequestDTO;
import com.digitaldark.Proyecto_Api.data.dto.response.DataResponseDTO;
import com.digitaldark.Proyecto_Api.data.model.DataEntity;
import com.digitaldark.Proyecto_Api.data.repository.DataRepository;
import com.digitaldark.Proyecto_Api.data.service.DataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DataResponseDTO createData(DataRequestDTO data) {
        DataEntity dataEntity = modelMapper.map(data, DataEntity.class);

        dataRepository.save(dataEntity);

        return modelMapper.map(dataEntity, DataResponseDTO.class);
    }

    @Override
    public List<DataResponseDTO> getAllData() {
        List<DataEntity> dataEntities = dataRepository.findAll();

        return dataEntities.stream()
                .map(dataEntity -> modelMapper.map(dataEntity, DataResponseDTO.class))
                .toList();
    }

    @Override
    public List<DataResponseDTO> getDataByDescription(String word) {
        List<DataEntity> dataEntities = dataRepository.findAll();

        return dataEntities.stream()
                    .filter(dataEntity -> dataEntity.getDescription().toLowerCase().contains(word.toLowerCase()))
                    .map(dataEntity -> modelMapper.map(dataEntity, DataResponseDTO.class))
                    .toList();
    }
}
