package com.prz.Converter;

import com.prz.DataBase.Comment;
import com.prz.Dto.CommentDto;
import org.springframework.stereotype.Component;


@Component
public class CommentConverterImpl implements CommentConverter {

    @Override
    public Comment convertToEntity(CommentDto commentDto) {
        return Comment.builder()
                ._id(commentDto.getId())
                ._idPicture(commentDto.getIdPicture())
                ._idUser(commentDto.getIdUser())
                .date(commentDto.getDate())
                .text(commentDto.getText())
                .build();
    }

    @Override
    public CommentDto convertToDto(Comment comment) {
        return CommentDto.builder()
                .date(comment.getDate())
                .id(comment.get_id())
                .idPicture(comment.get_idPicture())
                .idUser(comment.get_idUser())
                .text(comment.getText())
                .build();
    }
}
