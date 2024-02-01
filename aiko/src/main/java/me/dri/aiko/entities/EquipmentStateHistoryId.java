package me.dri.aiko.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
public class EquipmentStateHistoryId  implements Serializable {

    public EquipmentStateHistoryId() {}

    @ManyToOne
    @JoinColumn(name = "equipmentId", referencedColumnName = "id")
    private Equipment equipment;


    @ManyToOne
    @JoinColumn(name = "equipmentStateId", referencedColumnName = "id")
    private EquipmentState equipmentState;
}
