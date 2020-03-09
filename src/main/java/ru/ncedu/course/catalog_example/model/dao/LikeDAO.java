package ru.ncedu.course.catalog_example.model.dao;

import ru.ncedu.course.catalog_example.model.entity.CommentEntity;
import ru.ncedu.course.catalog_example.model.entity.LikeEntity;
import ru.ncedu.course.catalog_example.model.entity.UserEntity;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class LikeDAO extends AbstractDAO<LikeEntity, Long> {

    private static final String FIND_BY_OFFERING_ID = "FROM " + LikeEntity.class.getName() + " like WHERE like.offering.id = :offeringId";
    //private static final String FIND_BY_OFFERING_ID = "SELECT * FROM public.likes WHERE offering.id = :offeringId";


    public LikeDAO() {
        init(LikeEntity.class);
    }

    public List<LikeEntity> findByOfferingId(long offeringId) {  //does not works
        Map<String, Object> params = new HashMap<>();
        params.put("offeringId", offeringId);

        return customFindListQuery(FIND_BY_OFFERING_ID, params);
    }

}
