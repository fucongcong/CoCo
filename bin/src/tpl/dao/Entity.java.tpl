package {{ group }}.{{ module }}.dao.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name="{{ tableName }}")
public class {{ Uname }}Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public {{ Uname }}Entity() {
    }

}