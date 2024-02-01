package me.dri.aiko.controllers;

import me.dri.aiko.entities.dto.EquipmentModelStateHourlyEarningsDTO;
import me.dri.aiko.entities.dto.EquipmentModelStateHourlyEarningsInputDTO;
import me.dri.aiko.services.interfaces.EquipmentModelStateHourlyEarningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments/earnings")
public class EquipmentModelStateHourlyEarningsController {

    private final EquipmentModelStateHourlyEarningsService service;

    @Autowired
    public EquipmentModelStateHourlyEarningsController(EquipmentModelStateHourlyEarningsService service) {
        this.service = service;
    }

    @GetMapping
    public List<EquipmentModelStateHourlyEarningsDTO> findAll() {
        return this.service.findAll();
    }
    @GetMapping(path = "/{modelEquipmentID}/{stateEquipmentId}")
    public ResponseEntity<EquipmentModelStateHourlyEarningsDTO> findEquipmentModelHourlyEarnings(@PathVariable String modelEquipmentID, @PathVariable String stateEquipmentId) {
        return ResponseEntity.ok(this.service.findEquipmentModelHourlyEarnings(modelEquipmentID, stateEquipmentId));
    }
    @PostMapping
    public EquipmentModelStateHourlyEarningsDTO createEarning(@RequestBody EquipmentModelStateHourlyEarningsInputDTO earningsInputDTO) {
        return this.service.createEquipmentModelHourlyEarnings(earningsInputDTO);
    }

}
