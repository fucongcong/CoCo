package {{ group }}.{{ module }}.mapper;

import {{ group }}.{{ module }}.dao.entity.{{ Uname }}Entity;
import {{ group }}.{{ module }}.dto.{{ Uname }}Dto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface {{ Uname }}Mapper {

    @InheritConfiguration
    {{ Uname }}Dto {{ name }}To{{ Uname }}Dto({{ Uname }}Entity {{ name }});
}
