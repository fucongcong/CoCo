package {{ group }}.{{ module }}.dao.repository;


import {{ group }}.{{ module }}.dao.entity.{{ Uname }}Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface {{ Uname }}Repository extends CrudRepository<{{ Uname }}Entity, Integer> {
}
