package com.prz.Converter;

import com.prz.DataBase.Picture;
import com.prz.Dto.PictureDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PictureConverterImpl implements PictureConverter {

    @Override
    public Picture convertToEntity(PictureDto pictureDto) {
        return Picture.builder()
                ._id(pictureDto.getId())
                .categorys(Arrays.asList(StringToList.convertToArray(pictureDto.getCategorys().get(0))))
                .hasztags(Arrays.asList(StringToList.convertToArray(pictureDto.getHasztagsNoHasz().get(0))))
                .name(pictureDto.getName())
                .url(pictureDto.getUrl())
                .build();
    }

    @Override
    public PictureDto convertToDto(Picture picture) {
        return PictureDto.builder()
                .id(picture.get_id())
                .categorys(picture.getCategorys())
                .hasztags(picture.getHasztags())
                .name(picture.getName())
                .url(picture.getUrl())
                .build();
    }
}
