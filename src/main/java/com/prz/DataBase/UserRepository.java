package com.prz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByLogin(String login);

    User findUserByLoginAndPassword(String login, String password);

//    User findUserByLikeHasztagsContains(String hasztag);

}
