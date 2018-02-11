package com.prz.DataBase;

import com.prz.HaszManager;
import lombok.*;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends HaszManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;

    private String login;
    private String password;
    private String name;
    private boolean ifAdmin;
    @ElementCollection
    private List<String> likeHasztags = new ArrayList<String>();

}
