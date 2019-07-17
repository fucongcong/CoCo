package {{ group }}.{{ module }}.mapper;

import {{ group }}.{{ module }}.dao.entity.UserEntity;
import {{ group }}.{{ module }}.dto.UserDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface {{ Umodule }}Mapper {

    @InheritConfiguration
    {{ Umodule }}Dto {{ module }}To{{ Umodule }}Dto({{ Umodule }}Entity {{ module }});
}
