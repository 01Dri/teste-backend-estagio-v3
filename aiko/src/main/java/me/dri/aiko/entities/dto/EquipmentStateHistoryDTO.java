package me.dri.aiko.entities.dto;

import java.util.Date;

public record EquipmentStateHistoryDTO(EquipmentResponseDTO equipmentResponseDTO, Date date, EquipmentStateResponseDTO equipmentStateResponseDTO) {
}
