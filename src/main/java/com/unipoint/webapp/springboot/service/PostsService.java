package com.unipoint.webapp.springboot.service;

import com.unipoint.webapp.springboot.domain.posts.Posts;
import com.unipoint.webapp.springboot.domain.posts.PostsRepository;
import com.unipoint.webapp.springboot.web.dto.PostsResponseDto;
import com.unipoint.webapp.springboot.web.dto.PostsSaveRequestDto;
import com.unipoint.webapp.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService
{
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()
                    -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsRepository.findById(id).orElseThrow(()
                    -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}
