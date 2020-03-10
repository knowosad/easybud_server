package pl.easybud.server.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.easybud.server.api.rest.mapper.map.OrderDtoMap;
import pl.easybud.server.api.rest.mapper.map.OrderEntityMap;

@Configuration
public class BeanConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.addMappings(new OrderDtoMap());
    modelMapper.addMappings(new OrderEntityMap());

    return modelMapper;
  }
}
