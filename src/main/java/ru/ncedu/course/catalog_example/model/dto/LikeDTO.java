package ru.ncedu.course.catalog_example.model.dto;

import ru.ncedu.course.catalog_example.model.entity.CommentEntity;
import ru.ncedu.course.catalog_example.model.entity.LikeEntity;

import java.util.Date;

public class LikeDTO {

    private UserDTO author;
    private OfferingDTO offering;

    public LikeDTO(LikeEntity entity) {
        this.author = new UserDTO(entity.getAuthor());
        this.offering = new OfferingDTO(entity.getOffering());
    }

    public OfferingDTO getOffering() {
        return offering;
    }

    public void setOffering(OfferingDTO offering) {
        this.offering = offering;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

}
