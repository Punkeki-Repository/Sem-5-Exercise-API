package com.digitaldark.Proyecto_Api.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataResponseDTO {
    private String company;

    private String companyUrl;

    private String description;

    private String title;
}
