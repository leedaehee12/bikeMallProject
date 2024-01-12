package com.bikeMallProject.mall.springboot.service.posts;

import com.bikeMallProject.mall.springboot.domain.posts.Posts;
import com.bikeMallProject.mall.springboot.domain.posts.PostsRepository;
import com.bikeMallProject.mall.springboot.web.dto.PostResponseDto;
import com.bikeMallProject.mall.springboot.web.dto.PostsListResponseDto;
import com.bikeMallProject.mall.springboot.web.dto.PostsSaveRequestDto;
import com.bikeMallProject.mall.springboot.web.dto.PostsUpdateRequstDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequstDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id){
    Posts posts = postsRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("해당게시물이 없습니다"));

        postsRepository.delete(posts);
    }

    public PostResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id = " + id));
        return new PostResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .stream().map(PostsListResponseDto::new)
                .collect(Collectors.toList());

    }
}
