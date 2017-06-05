package diets.objects;

import java.io.Serializable;
import javax.persistence.*;

/**
 *Класс в котором автоматически присваивается id к создаваемому объекту
 * @author Bat
 */
@MappedSuperclass
public abstract class Identifable implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public Identifable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
