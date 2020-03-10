package pl.easybud.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.easybud.server.entity.OrderEntity;
import pl.easybud.server.dto.OrderDTO;
import pl.easybud.server.exception.OrderNotFoundException;
import pl.easybud.server.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final ModelMapper modelMapper;


  public OrderDTO create(OrderDTO dto) {
    log.info("CREATE OrderEntity: " + dto.toString());
    OrderEntity orderEntity = modelMapper.map(dto, OrderEntity.class);
    orderEntity = orderRepository.save(orderEntity);
    return modelMapper.map(orderEntity, OrderDTO.class);
  }

  public OrderDTO read(Long id) {
    log.info("READ");
    OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    return modelMapper.map(orderEntity, OrderDTO.class);
  }

  public List<OrderDTO> findAll() {
    log.info("FIND ALL");
    List<OrderEntity> orderEntities = orderRepository.findAll();
    return orderEntities.stream().map(entity -> modelMapper.map(entity, OrderDTO.class)).collect(Collectors.toList());
  }

}
