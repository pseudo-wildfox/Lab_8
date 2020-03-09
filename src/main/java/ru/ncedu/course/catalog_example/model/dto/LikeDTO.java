package ru.ncedu.course.catalog_example.model.dto;

import ru.ncedu.course.catalog_example.model.entity.CommentEntity;
import ru.ncedu.course.catalog_example.model.entity.LikeEntity;

import java.util.Date;

public class LikeDTO {

    private Long id;
    private UserDTO author;

    public LikeDTO(LikeEntity entity) {
        this.id = entity.getId();
        this.author = new UserDTO(entity.getAuthor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

}
