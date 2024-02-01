package me.dri.aiko.services.interfaces;

import me.dri.aiko.entities.dto.EquipmentModelStateHourlyEarningsDTO;
import me.dri.aiko.entities.dto.EquipmentModelStateHourlyEarningsInputDTO;

import java.util.List;

public interface EquipmentModelStateHourlyEarningsService {

    List<EquipmentModelStateHourlyEarningsDTO> findAll();
    EquipmentModelStateHourlyEarningsDTO findEquipmentModelHourlyEarnings(String modelEquipmentName, String stateEquipment);
    EquipmentModelStateHourlyEarningsDTO createEquipmentModelHourlyEarnings(EquipmentModelStateHourlyEarningsInputDTO inputDTO);



}
