package com.prz.Dto;

import com.prz.HaszManager;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class UserDto extends HaszManager {


    private Long _id;

    private String login;
    private String password;
    private String name;
    @ElementCollection
    private List<String> addPictures = new ArrayList<String>();
    @ElementCollection
    private List<String> likeHasztags = new ArrayList<String>();

    public List<String> getLikeHasztags() {
        return super.addHasz(this.likeHasztags);
    }


    public List<String> getLikeHasztagsNoHasz() {
        return super.removeHasz(this.likeHasztags);
    }
}
