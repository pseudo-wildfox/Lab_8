package ru.ncedu.course.catalog_example.service;

import ru.ncedu.course.catalog_example.model.dao.UserDAO;
import ru.ncedu.course.catalog_example.model.entity.UserEntity;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Stateful
@SessionScoped
public class JourneyBean implements Serializable {
    private List<String> visitedPages;

    public void addPage(String page){
        if(visitedPages == null){
            visitedPages = new ArrayList<>();
        }
        visitedPages.add(page);
    }
    public List<String> getPages(){
        return visitedPages;
    }

    public void clearPages(){
        if (visitedPages != null) {
            visitedPages.clear();;
        }
    }

}


