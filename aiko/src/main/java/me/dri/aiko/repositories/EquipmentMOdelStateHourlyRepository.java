package me.dri.aiko.repositories;

import me.dri.aiko.entities.EquipmentModelStateHourlyEarnings;
import me.dri.aiko.entities.EquipmentModelStateHourlyEarningsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EquipmentMOdelStateHourlyRepository  extends JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsId> {


    @Query("SELECT e FROM EquipmentModelStateHourlyEarnings e WHERE e.id.equipmentModel.id  = :modelID AND e.id.equipmentState.id = :equipmentStateId")
    Optional<EquipmentModelStateHourlyEarnings> findEquipmentModelStateHourlyEarningsByEquipmentModelName(@Param("modelID") UUID modelID, @Param("equipmentStateId") UUID equipmentStateId);
}
