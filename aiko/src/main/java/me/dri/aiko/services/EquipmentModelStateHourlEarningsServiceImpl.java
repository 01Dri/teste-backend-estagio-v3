package me.dri.aiko.services;

import jakarta.transaction.Transactional;
import me.dri.aiko.entities.EquipmentModel;
import me.dri.aiko.entities.EquipmentModelStateHourlyEarnings;
import me.dri.aiko.entities.EquipmentModelStateHourlyEarningsId;
import me.dri.aiko.entities.EquipmentState;
import me.dri.aiko.entities.dto.EquipmentModelResponseDTO;
import me.dri.aiko.entities.dto.EquipmentModelStateHourlyEarningsDTO;
import me.dri.aiko.entities.dto.EquipmentModelStateHourlyEarningsInputDTO;
import me.dri.aiko.entities.dto.EquipmentStateResponseDTO;
import me.dri.aiko.repositories.EquipmentMOdelStateHourlyRepository;
import me.dri.aiko.repositories.EquipmentModelsRepository;
import me.dri.aiko.repositories.EquipmentStateRepository;
import me.dri.aiko.services.interfaces.EquipmentModelStateHourlyEarningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentModelStateHourlEarningsServiceImpl implements EquipmentModelStateHourlyEarningsService {

    private final EquipmentMOdelStateHourlyRepository repository;
    private final EquipmentStateRepository equipmentStateRepository;
    private final EquipmentModelsRepository equipmentModelsRepository;

    @Autowired

    public EquipmentModelStateHourlEarningsServiceImpl(EquipmentMOdelStateHourlyRepository repository, EquipmentStateRepository equipmentStateRepository, EquipmentModelsRepository equipmentModelsRepository) {
        this.repository = repository;
        this.equipmentStateRepository = equipmentStateRepository;
        this.equipmentModelsRepository = equipmentModelsRepository;
    }


    @Override
    public List<EquipmentModelStateHourlyEarningsDTO> findAll() {
        List<EquipmentModelStateHourlyEarnings> earningsList = this.repository.findAll();
        return earningsList.stream().map(earnings -> {
            return new EquipmentModelStateHourlyEarningsDTO(MapperEntities.createEquipmentStateDtoResponse(earnings), MapperEntities.createEquipmentModelDtoResponse(earnings), earnings.getValue());
        }).toList();
    }

    @Override
    public EquipmentModelStateHourlyEarningsDTO findEquipmentModelHourlyEarnings(String modelEquipmentID, String stateEquipmentId) {
        EquipmentModelStateHourlyEarnings earnings = this.repository.findEquipmentModelStateHourlyEarningsByEquipmentModelName(UUID.fromString(modelEquipmentID), UUID.fromString(stateEquipmentId)).orElseThrow();
        return new EquipmentModelStateHourlyEarningsDTO(MapperEntities.createEquipmentStateDtoResponse(earnings), MapperEntities.createEquipmentModelDtoResponse(earnings), earnings.getValue());
    }

    @Transactional
    @Override
    public EquipmentModelStateHourlyEarningsDTO createEquipmentModelHourlyEarnings(EquipmentModelStateHourlyEarningsInputDTO earningsInputDTO) {
        EquipmentState equipmentState = this.equipmentStateRepository.findEquipmentStateById(UUID.fromString(earningsInputDTO.stateEquipmentId())).orElseThrow();
        EquipmentModel equipmentModel = this.equipmentModelsRepository.findById(UUID.fromString(earningsInputDTO.modelEquipmentId())).orElseThrow();
        EquipmentModelStateHourlyEarnings earnings = new EquipmentModelStateHourlyEarnings(new EquipmentModelStateHourlyEarningsId(equipmentModel, equipmentState), earningsInputDTO.value());
        this.repository.save(earnings);
        return new EquipmentModelStateHourlyEarningsDTO(MapperEntities.createEquipmentStateDtoResponse(earnings), MapperEntities.createEquipmentModelDtoResponse(earnings), earningsInputDTO.value());
    }

}
