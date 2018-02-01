package com.prz.DataBase;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;

    private String _idPicture;
    private String text;
    private String _idUser;
    private String date;

    @Override
    public String toString() {
        return String.format("ID: %s, User: %s, Text: %s, Data: %s",
                this._id, this._idUser, this.text, this.date);
    }

    private String getInitDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
