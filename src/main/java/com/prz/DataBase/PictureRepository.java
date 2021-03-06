package com.prz.DataBase;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

    Picture findPictureByName(String name);

    List<Picture> findAllByHasztagsContains(String hasztag);

    Picture save(Picture picture);
}
