package com.prz.DataBase;

import com.prz.Converter.CommentConverter;
import com.prz.Converter.PictureConverter;
import com.prz.Converter.UserConverter;
import com.prz.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseManager {

    private static DatabaseManager ourInstance = new DatabaseManager();
    public static DatabaseManager getInstance() {return ourInstance;}

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  PictureRepository pictureRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PictureConverter pictureConverter;

    @Autowired
    private CommentConverter commentConverter;

    @Autowired
    private DatabaseTestData databaseTestData;


    private DatabaseManager(){

    }

    public void loadInitialData() {databaseTestData.loadInitialData();}
    public void printTestData() {databaseTestData.printTestData();}


    public Boolean isAdmin(UserDto userDto) {
        Boolean isAdmin = false;
        Long idUser = this.userRepository.findUserByLoginAndPassword(userDto.getLogin(), userDto.getPassword()).get_id();
        try {
            if (this.userRepository.exists(idUser) && this.userRepository.findOne(idUser).isIfAdmin()) {
                isAdmin = true;
            }
        } catch (Exception ex) {
            isAdmin = false;
        }
        return isAdmin;
    }

}
