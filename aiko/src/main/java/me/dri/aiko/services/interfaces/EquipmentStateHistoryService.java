package me.dri.aiko.services.interfaces;

import me.dri.aiko.entities.dto.EquipmentStateHistoryDTO;

import java.util.List;

public interface EquipmentStateHistoryService {

    List<EquipmentStateHistoryDTO> findAll();

}
