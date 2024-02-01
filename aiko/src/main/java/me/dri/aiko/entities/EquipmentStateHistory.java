package me.dri.aiko.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "equipment_state_history")
@Data
@AllArgsConstructor
public class EquipmentStateHistory {

    public EquipmentStateHistory() {
    }

    @EmbeddedId
    private EquipmentModelStateHourlyEarningsId id;

    private Date date;
}
