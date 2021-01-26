package com.unipoint.webapp.springboot.web;

import com.unipoint.webapp.springboot.service.PostsService;
import com.unipoint.webapp.springboot.web.dto.PostsResponseDto;
import com.unipoint.webapp.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController
{
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }

    //    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto)
    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.update(id, requestDto);
    }

    @PostMapping("/api/vi/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }

}
