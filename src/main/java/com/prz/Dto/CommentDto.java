package com.prz.Dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;

    private String idPicture;
    private String text;
    private String idUser;
    private String date;

}
