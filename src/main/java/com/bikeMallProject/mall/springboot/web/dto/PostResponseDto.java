package com.bikeMallProject.mall.springboot.web.dto;

import com.bikeMallProject.mall.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }
}
