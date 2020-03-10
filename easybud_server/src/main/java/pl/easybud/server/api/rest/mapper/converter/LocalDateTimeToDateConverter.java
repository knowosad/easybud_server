package pl.easybud.server.api.rest.mapper.converter;

import org.modelmapper.AbstractConverter;
import pl.easybud.server.util.DateUtils;

import java.time.LocalDateTime;
import java.util.Date;

public class LocalDateTimeToDateConverter extends AbstractConverter<LocalDateTime, Date> {

  @Override
  protected Date convert(LocalDateTime source) {
    return source != null ? DateUtils.toDate(source) : null;
  }
}
