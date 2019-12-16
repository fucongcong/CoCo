package {{ group }}.{{ module }}.dao.repository;


import {{ group }}.{{ module }}.dao.entity.{{ Uname }}Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface {{ Uname }}Repository extends JpaRepository<{{ Uname }}Entity, Integer> {
}
