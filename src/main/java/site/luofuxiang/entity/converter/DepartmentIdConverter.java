package site.luofuxiang.entity.converter;

import javax.persistence.AttributeConverter;

public class DepartmentIdConverter implements AttributeConverter<Long, String> {

    @Override
    public String convertToDatabaseColumn(Long attribute) {
        return "P" + attribute;
    }

    @Override
    public Long convertToEntityAttribute(String dbData) {
        return Long.valueOf(dbData.substring(1));
    }
}
