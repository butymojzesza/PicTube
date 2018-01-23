package com.prz.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CommentDto {

    private Long id;

    private String idPicture;
    private String text;
    private String idUser;
    private String date;

}
