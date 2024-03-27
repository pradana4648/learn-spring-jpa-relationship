package id.pradana.ems.converter;

import id.pradana.ems.model.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

/**
 * This is class is used to convert Gender enumeration from table definition
 * based on column
 */
@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Character> {

  @Override
  public Character convertToDatabaseColumn(Gender gender) {
    if (gender == null)
      return null;

    return gender.getCode();
  }

  @Override
  public Gender convertToEntityAttribute(Character code) {
    if (code == null)
      return null;

    return Stream.of(Gender.values())
        .filter(c -> c.getCode() == code)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
