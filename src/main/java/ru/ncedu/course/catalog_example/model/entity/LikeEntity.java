package ru.ncedu.course.catalog_example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "likes")
public class LikeEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_user_id", nullable = false)
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "offering_id", nullable = false)
    private OfferingEntity offering;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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

}
