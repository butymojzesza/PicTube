package com.prz.DataBase;

import com.prz.Converter.CommentConverter;
import com.prz.Converter.PictureConverter;
import com.prz.Converter.UserConverter;
import com.prz.Dto.PictureDto;
import com.prz.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public void insertUser (UserDto userDto) {
        this.userRepository.save(this.userConverter.convertToEntity(userDto));
    }

    public void insertPicture ( PictureDto pictureDto){
        this.pictureRepository.save(this.pictureConverter.convertToEntity(pictureDto));
    }

    public List<PictureDto> getListOfPictures(){
        List<PictureDto> listOfPicturesDto = new ArrayList<>();
        List<Picture> listOfPictures = (List<Picture>) this.pictureRepository.findAll();
        for (Picture pic : listOfPictures) {
            listOfPicturesDto.add(this.pictureConverter.convertToDto(pic));
        }
        return listOfPicturesDto;
    }

    public List<String> getListOfPicturesUrl(List<PictureDto> pictureDtos){
        List<String> listOfPicturesUrl = new ArrayList<>();
        for (PictureDto pictureUrl : pictureDtos){
            listOfPicturesUrl.add(pictureUrl.getUrl());
        }
        return listOfPicturesUrl;
    }

    public String getUserName (String login){
        String userName = userRepository.findUserByLogin(login).getName();
        return userName;
    }

}
