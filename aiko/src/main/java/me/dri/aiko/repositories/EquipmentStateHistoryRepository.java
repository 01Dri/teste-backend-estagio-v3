package me.dri.aiko.repositories;

import me.dri.aiko.entities.EquipmentStateHistory;
import me.dri.aiko.entities.EquipmentStateHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, EquipmentStateHistoryId> {
}
