package pl.easybud.server.api.rest.mapper.map;

import org.modelmapper.PropertyMap;
import pl.easybud.server.entity.OrderEntity;
import pl.easybud.server.dto.OrderDTO;
import pl.easybud.server.api.rest.mapper.Mapper;

@Mapper
public class OrderEntityMap extends PropertyMap<OrderEntity, OrderDTO> {

  @Override
  protected void configure() {
    map().setId(source.getId());
    map().setLabel(source.getLabel());
    map().setName(source.getName());
  }
}
