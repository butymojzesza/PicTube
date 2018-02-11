package com.prz.DataBase;


import lombok.*;
import com.prz.HaszManager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Picture extends HaszManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;

    private String name;
    private String url;
    @ElementCollection
    private List<String> categorys = new ArrayList<>();
    @ElementCollection
    private List<String> hasztags = new ArrayList<>();

}
