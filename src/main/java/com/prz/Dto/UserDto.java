package com.prz.Dto;

import com.prz.HaszManager;
import lombok.*;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends HaszManager {


    private long _id;

    private String login;
    private String password;
    private String name;
    private boolean ifAdmin;
//    @ElementCollection
//    private List<String> addPictures = new ArrayList<String>();
//    @ElementCollection
//    private List<String> likeHasztags = new ArrayList<String>();

//    public List<String> getLikeHasztags() {
//        return super.addHasz(this.likeHasztags);
//    }
//
//
//    public List<String> getLikeHasztagsNoHasz() {
//        return super.removeHasz(this.likeHasztags);
//    }
}
