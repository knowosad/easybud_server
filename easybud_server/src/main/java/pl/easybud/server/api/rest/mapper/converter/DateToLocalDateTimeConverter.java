package pl.easybud.server.api.rest.mapper.converter;

import org.modelmapper.AbstractConverter;
import pl.easybud.server.util.DateUtils;

import java.time.LocalDateTime;
import java.util.Date;

public class DateToLocalDateTimeConverter extends AbstractConverter<Date, LocalDateTime> {

  @Override
  protected LocalDateTime convert(Date source) {
    return source != null ? DateUtils.toLocalDateTime(source) : null;
  }
}
