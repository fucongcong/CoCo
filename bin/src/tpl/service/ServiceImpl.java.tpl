package {{ group }}.{{ module }}.service;

import {{ group }}.{{ module }}.api.{{ Uname }}Service;
import {{ group }}.{{ module }}.dao.entity.{{ Uname }}Entity;
import {{ group }}.{{ module }}.dao.repository.{{ Uname }}Repository;
import {{ group }}.{{ module }}.dto.{{ Uname }}Dto;
import {{ group }}.{{ module }}.mapper.{{ Uname }}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class {{ Uname }}ServiceImpl implements {{ Uname }}Service {
    @Autowired
    protected {{ Uname }}Repository {{ name }}Repository;

    @Autowired
    protected {{ Uname }}Mapper {{ name }}Mapper;

    public {{ Uname }}Dto get{{ Uname }}(int id) {
        {{ Uname }}Entity {{ name }}Entity = {{ name }}Repository.findById(id).get();

        return  {{ name }}Mapper.{{ name }}To{{ Uname }}Dto({{ name }}Entity);
    }
}
