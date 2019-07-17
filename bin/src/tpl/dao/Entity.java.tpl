package {{ group }}.{{ module }}.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="{{ module }}")
public class {{ Umodule }}Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * id
     */
    private Integer id;

    public {{ Umodule }}Entity() {
    }

}