package com.bikeMallProject.mall.springboot.web;

import com.bikeMallProject.mall.springboot.service.posts.PostsService;
import com.bikeMallProject.mall.springboot.web.dto.PostResponseDto;
import com.bikeMallProject.mall.springboot.web.dto.PostsSaveRequestDto;
import com.bikeMallProject.mall.springboot.web.dto.PostsUpdateRequstDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequstDto requstDto){
        return postsService.update(id, requstDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long Delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
