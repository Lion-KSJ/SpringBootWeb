package com.unipoint.webapp.springboot.web;

import com.unipoint.webapp.springboot.service.PostsService;
import com.unipoint.webapp.springboot.web.dto.PostsResponseDto;
import com.unipoint.webapp.springboot.web.dto.PostsSaveRequestDto;
import com.unipoint.webapp.springboot.web.dto.PostsUpdateRequestDto;
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
        System.out.println("save Title -> " + requestDto.getTitle());
        System.out.println("save Content -> " + requestDto.getContent());
        System.out.println("save Author -> " + requestDto.getAuthor());

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto)
    {
        System.out.println("update ID -> " + id);
        System.out.println("update Title -> " + requestDto.getTitle());
        System.out.println("update Content -> " + requestDto.getContent());

        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id)
    {
        System.out.println("삭제");
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        System.out.println("findById ID ->" + id);
        return postsService.findById(id);
    }

}
