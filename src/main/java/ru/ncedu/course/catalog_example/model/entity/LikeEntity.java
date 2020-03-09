package ru.ncedu.course.catalog_example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "likes")
public class LikeEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "author_user_id", nullable = false)
    private UserEntity author;

    @Id
    @ManyToOne
    @JoinColumn(name = "offering_id", nullable = false)
    private OfferingEntity offering;



    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public OfferingEntity getOffering() {
        return offering;
    }

    public void setOffering(OfferingEntity offering) {
        this.offering = offering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeEntity that = (LikeEntity) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(offering, that.offering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, offering);
    }
}
