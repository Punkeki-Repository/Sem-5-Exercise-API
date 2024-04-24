package com.digitaldark.Proyecto_Api.data.controller;

import com.digitaldark.Proyecto_Api.data.dto.request.DataRequestDTO;
import com.digitaldark.Proyecto_Api.data.dto.response.DataResponseDTO;
import com.digitaldark.Proyecto_Api.data.repository.DataRepository;
import com.digitaldark.Proyecto_Api.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class DataController {
    @Autowired
    private DataService dataService;

    //Url: http://localhost:8080/api/v1/data
    //Method: GET
    @Transactional
    @GetMapping("/data")
    public ResponseEntity<List<DataResponseDTO>> getData(@RequestParam(required = false) String description) {
        if (description != null) {
            return new ResponseEntity<>(dataService.getDataByDescription(description), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(dataService.getAllData(), HttpStatus.OK);
        }
    }

    //Url: http://localhost:8080/api/v1/data
    //Method: POST
    @Transactional
    @PostMapping("/data")
    public ResponseEntity<DataResponseDTO> createData(@RequestBody DataRequestDTO data) {
        return new ResponseEntity<DataResponseDTO>(dataService.createData(data), HttpStatus.CREATED);
    }
}
