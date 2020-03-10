package pl.easybud.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.easybud.server.dto.ContractorDTO;
import pl.easybud.server.dto.OrderDTO;
import pl.easybud.server.entity.ContractorEntity;
import pl.easybud.server.entity.OrderEntity;
import pl.easybud.server.exception.OrderNotFoundException;
import pl.easybud.server.repository.ContractorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractorService {

  private ContractorRepository contractorRepository;

  private ModelMapper modelMapper;

  public ContractorDTO create(ContractorDTO dto) {
    log.info("CREATE ContractorEntity [dto = ()]", dto.toString());
    ContractorEntity entity = modelMapper.map(dto, ContractorEntity.class);
    entity = contractorRepository.save(entity);
    return modelMapper.map(entity, ContractorDTO.class);
  }

  public ContractorDTO read(Long id) {
    log.info("READ ContractorEntity [id = ()]", id);
    ContractorEntity entity = contractorRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    return modelMapper.map(entity, ContractorDTO.class);
  }

  public List<ContractorDTO> findAll() {
    log.info("FIND ALL ContractorEntity");
    List<ContractorEntity> entities = contractorRepository.findAll();
    return entities.stream().map(entity -> modelMapper.map(entity, ContractorDTO.class)).collect(Collectors.toList());
  }
}
