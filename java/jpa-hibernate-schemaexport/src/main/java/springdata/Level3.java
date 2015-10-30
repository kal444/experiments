package springdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL3")
public class Level3 {

    @Id
    @Column(name = "L3ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "L3ID_SEQ")
    @SequenceGenerator(name = "L3ID_SEQ", sequenceName = "SEQ_L3_ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
