package springdata;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL1")
public class Level1 {

    @Id
    @Column(name = "L1KEY", length = 9)
    private String key;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "L1KEY", nullable = false)
    private Set<Level2> level2s;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Set<Level2> getLevel2s() {
        return level2s;
    }

    public void setLevel2s(Set<Level2> level2s) {
        this.level2s = level2s;
    }
}
