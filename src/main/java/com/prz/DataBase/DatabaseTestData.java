package com.prz.DataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTestData {

    private CommentRepository commentTable;
    private PictureRepository pictureTable;
    private UserRepository userTable;
@Autowired
    public DatabaseTestData(CommentRepository commentTable, PictureRepository pictureTable, UserRepository userTable) {
        this.commentTable = commentTable;
        this.pictureTable = pictureTable;
        this.userTable = userTable;
    }

    public void loadInitialData() {

        this.userTable.deleteAll();
        this.pictureTable.deleteAll();
        this.commentTable.deleteAll();

        this.userTable.save(User.builder().login("JanKowalski").password("12345").build());
        this.userTable.save(User.builder().login("AdamMichnik").password("54321").build());

        this.pictureTable.save(Picture.builder().name("test_picture_1").url("https://www.wykop.pl/cdn/c3201142/comment_uOtVeTtARj3kk5AS5x6wRryjjvLEuyxk.jpg").build());
        this.pictureTable.save(Picture.builder().name("test_picture_2").url("https://www.wykop.pl/cdn/c3201142/comment_e5IdIMpr6GkABZ3iOW3rLRxDGz8scG74.jpg").build());
        this.pictureTable.save(Picture.builder().name("test_picture_3").url("https://www.wykop.pl/cdn/c3201142/comment_mrbBFyqzZE6XHrhSLJ4oXgXCnyo2GPoF.jpg").build());
        this.pictureTable.save(Picture.builder().name("test_picture_4").url("https://www.wykop.pl/cdn/c3201142/comment_OjWHfcHZisATkUqJ8TVlEbGgjLqudX20.jpg").build());
        this.pictureTable.save(Picture.builder().name("test_picture_5").url("https://www.wykop.pl/cdn/c3201142/comment_EPcYXaNXFrmGt9cEX2gzITrhtEmVwzhp.jpg").build());
        this.pictureTable.save(Picture.builder().name("test_picture_6").url("https://www.wykop.pl/cdn/c3201142/comment_ZX0Jzp0NWXDBO6TGr5SeQJG3SrTJKMws.jpg").build());
        this.pictureTable.save(Picture.builder().name("test_picture_7").url("https://www.wykop.pl/cdn/c3201142/comment_csq3X0DAPR628xvox3wLBNCWlaJQFPHO.jpg").build());





        Picture p = this.pictureTable.findPictureByName("test_picture_1");

//        p.getCategorys().add("Kategoria1");
//        p.getCategorys().add("Kategoria2");
//        p.getCategorys().add("Kategoria3");
//        this.pictureTable.save(p);

//        String pictureId = pictureTable.findPictureByName("test_picture_1").get_id();
//        String userId = userTable.findUserByLogin("JanKowalski").get_id();
//        commentTable.save(Comment.builder()._idPicture(pictureId).text("Ale małpa")._idUser(userId).build());
//        commentTable.save(Comment.builder()._idPicture(pictureId).text("Ale małpa2")._idUser(userId).build());
//        commentTable.save(Comment.builder()._idPicture(pictureId).text("Ale małpa3")._idUser(userId).build());
//
//        pictureId = this.pictureTable.findPictureByName("test_picture_2").get_id();
//        userId = this.userTable.findUserByLogin("AdamMichnik").get_id();
//        this.commentTable.save(Comment.builder()._idPicture(pictureId).text("Głupota!!!!")._idUser(userId).build());

    }

    public void printTestData() {
        System.out.println("Users");
        System.out.println("---------------------------------------");
        for (User user : this.userTable.findAll()) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println("Pictures");
        System.out.println("---------------------------------------");
        for (Picture picture : this.pictureTable.findAll()) {
            System.out.println(picture);
        }

        System.out.println();
        System.out.println("Users");
        System.out.println("---------------------------------------");
        for (Comment comment : this.commentTable.findAll()) {
            System.out.println(comment);
        }
    }
}