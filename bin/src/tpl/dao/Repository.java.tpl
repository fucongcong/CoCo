package {{ group }}.{{ module }}.dao.repository;


import {{ group }}.{{ module }}.dao.entity.{{ Umodule }}Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface {{ Umodule }}Repository extends CrudRepository<{{ Umodule }}Entity, Integer> {
}
