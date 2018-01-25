package com.prz.Dto;

import com.prz.HaszManager;
import lombok.*;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PictureDto extends HaszManager {


    private Long id;

    private String name;
    private String url;
    @ElementCollection
    private List<String> categorys = new ArrayList<String>();
    @ElementCollection
    private List<String> hasztags = new ArrayList<String>();

    public int getHasztagsSize() {
        return this.hasztags.size();
    }

    public List<String> getHasztags() {
        return super.addHasz(this.hasztags);
    }

    public void setHasztags(List<String> hasztags) {
        this.hasztags = super.removeHasz(hasztags);
    }

    public List<String> getHasztagsNoHasz() {
        return super.removeHasz(this.hasztags);
    }
}
