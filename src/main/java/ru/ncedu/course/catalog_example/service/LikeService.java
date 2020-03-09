package ru.ncedu.course.catalog_example.service;

import ru.ncedu.course.catalog_example.exception.OfferingNotFoundException;
import ru.ncedu.course.catalog_example.exception.UnauthorizedException;
import ru.ncedu.course.catalog_example.model.dao.CommentDAO;
import ru.ncedu.course.catalog_example.model.dao.LikeDAO;
import ru.ncedu.course.catalog_example.model.dao.OfferingDAO;
import ru.ncedu.course.catalog_example.model.dto.CommentDTO;
import ru.ncedu.course.catalog_example.model.dto.LikeDTO;
import ru.ncedu.course.catalog_example.model.entity.CommentEntity;
import ru.ncedu.course.catalog_example.model.entity.LikeEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class LikeService {

    @Inject
    private AuthorizationBean authorizationBean;

    @Inject
    private LikeDAO likeDAO;

    @Inject
    private OfferingDAO offeringDAO;

    public LikeDTO create(long offering) throws UnauthorizedException, OfferingNotFoundException {
        LikeEntity entity = new LikeEntity();
        entity.setOffering(offeringDAO.findById(offering).orElseThrow(OfferingNotFoundException::new));
        entity.setAuthor(authorizationBean.getUser().orElseThrow(UnauthorizedException::new));
        likeDAO.create(entity);
        return new LikeDTO(entity);
    }

    public List<LikeDTO> findAllByOffering(long offering) {
        return likeDAO.findByOfferingId(offering).stream().map(LikeDTO::new).collect(Collectors.toList());
    }

    public List<LikeDTO> findAll() {
        return likeDAO.findAll().stream().map(LikeDTO::new).collect(Collectors.toList());
    }

    public long countByOffering(long offering) {
        return likeDAO.findByOfferingId(offering).stream().map(LikeDTO::new).count();
    }

    public LikeService getThis() {
        return this;
    }

}
