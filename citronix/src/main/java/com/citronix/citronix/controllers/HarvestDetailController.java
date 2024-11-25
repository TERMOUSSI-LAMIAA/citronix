package com.citronix.citronix.controllers;

import com.citronix.citronix.dto.HarvestDetailDTO;
import com.citronix.citronix.services.impl.HarvestDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/harvestDetails")
@Validated
public class HarvestDetailController {
    private final HarvestDetailServiceImpl harvestDetailServiceImpl;

    @Autowired
    public HarvestDetailController( HarvestDetailServiceImpl harvestDetailServiceImpl){
        this.harvestDetailServiceImpl=harvestDetailServiceImpl;
    }
    @PostMapping
    public ResponseEntity<HarvestDetailDTO> saveHarvestDetail(@RequestBody @Valid HarvestDetailDTO harvestDetailDTO){
        HarvestDetailDTO savedHarvestDetailDTO=harvestDetailServiceImpl.saveHarvestDetail(harvestDetailDTO);
        return ResponseEntity.ok(savedHarvestDetailDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HarvestDetailDTO> updateHarvestDetail(
            @PathVariable Long id,
            @RequestBody @Valid HarvestDetailDTO harvestDetailDTO) {
        HarvestDetailDTO updatedHarvestDetail = harvestDetailServiceImpl.updateHarvestDetail(harvestDetailDTO,id);
        return ResponseEntity.ok(updatedHarvestDetail);
    }
    @GetMapping
    public ResponseEntity<Page<HarvestDetailDTO>> getAllHarvestDetails(Pageable pageable) {
        Page<HarvestDetailDTO> harvestDetails = harvestDetailServiceImpl.getAllHarvestDetails(pageable);
        return ResponseEntity.ok(harvestDetails);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHarvestDetail(@PathVariable Long id) {
        harvestDetailServiceImpl.deleteHarvestDetail(id);
        return ResponseEntity.noContent().build();
    }
}
