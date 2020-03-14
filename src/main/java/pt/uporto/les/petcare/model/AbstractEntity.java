package pt.uporto.les.petcare.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createDateTime;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updateDateTime;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        return Objects.equals(this.id, other.id);
    }

    public Instant getCreateDateTime() {
        return createDateTime;
    }

    public Instant getUpdateDateTime() {
        return updateDateTime;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime
               ;
    }
}

