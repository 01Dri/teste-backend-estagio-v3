package me.dri.aiko.services;

import me.dri.aiko.entities.dto.EquipmentResponseDTO;
import me.dri.aiko.entities.dto.EquipmentStateHistoryDTO;
import me.dri.aiko.repositories.EquipmentStateHistoryRepository;
import me.dri.aiko.services.interfaces.EquipmentStateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentStateHistoryImpl implements EquipmentStateHistoryService {

    private final EquipmentStateHistoryRepository repository;
    @Autowired
    public EquipmentStateHistoryImpl(EquipmentStateHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EquipmentStateHistoryDTO> findAll() {
        return null;
    }
}
