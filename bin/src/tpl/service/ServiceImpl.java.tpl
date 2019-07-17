package {{ group }}.{{ module }}.service;

import {{ group }}.{{ module }}.api.{{ Umodule }}Service;
import {{ group }}.{{ module }}.dao.entity.{{ Umodule }}Entity;
import {{ group }}.{{ module }}.dao.repository.{{ Umodule }}Repository;
import {{ group }}.{{ module }}.dto.{{ Umodule }}Dto;
import {{ group }}.{{ module }}.mapper.{{ Umodule }}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class {{ Umodule }}ServiceImpl implements {{ Umodule }}Service {
    @Autowired
    protected {{ Umodule }}Repository {{ module }}Repository;

    @Autowired
    protected {{ Umodule }}Mapper {{ module }}Mapper;

    public {{ Umodule }}Dto get{{ Umodule }}(int id) {
        {{ Umodule }}Entity {{ module }}Entity = {{ module }}Repository.findById(id).get();

        return  {{ module }}Mapper.{{ module }}To{{ Umodule }}Dto({{ module }}Entity);
    }
}
