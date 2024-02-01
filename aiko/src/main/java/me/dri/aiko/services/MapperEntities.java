package me.dri.aiko.services;

import me.dri.aiko.entities.EquipmentModelStateHourlyEarnings;
import me.dri.aiko.entities.dto.EquipmentModelResponseDTO;
import me.dri.aiko.entities.dto.EquipmentStateResponseDTO;

public class MapperEntities {

    public static EquipmentStateResponseDTO createEquipmentStateDtoResponse(EquipmentModelStateHourlyEarnings earnings) {
        return new EquipmentStateResponseDTO(
                earnings.getId().getEquipmentState().getId().toString(),
                earnings.getId().getEquipmentState().getName(),
                earnings.getId().getEquipmentState().getColor()
        );
    }
    public static EquipmentModelResponseDTO createEquipmentModelDtoResponse(EquipmentModelStateHourlyEarnings earnings) {
        return new EquipmentModelResponseDTO(
                earnings.getId().getEquipmentModel().getId().toString(),
                earnings.getId().getEquipmentModel().getName()
        );
    }
}
