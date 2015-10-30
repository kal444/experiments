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
@Table(name = "LEVEL2")
public class Level2 {

    @Id
    @Column(name = "L2KEY", length = 9)
    private String key;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "L2KEY", nullable = false)
    private Set<Level3> level3s;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Set<Level3> getLevel3s() {
        return level3s;
    }

    public void setLevel3s(Set<Level3> level3s) {
        this.level3s = level3s;
    }
}
