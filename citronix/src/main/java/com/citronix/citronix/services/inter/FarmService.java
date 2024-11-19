package com.citronix.citronix.services.inter;

import com.citronix.citronix.dto.FarmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

public interface FarmService {
    Page<FarmDTO> getAllFarms(Pageable pageable);
    FarmDTO saveFarm(@Valid FarmDTO farmDTO);
    FarmDTO updateFarm(Long id, @Valid FarmDTO updatedFarmDTO);
    FarmDTO getFarmById(Long id);
}
