package com.bikeMallProject.mall.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequstDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequstDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
