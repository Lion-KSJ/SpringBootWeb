package com.unipoint.webapp.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest
{
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup()
    {
        postsRepository.deleteAll();
    }

    @Test
    public void Post_getPost()
    {
        String title = "게시글 제목";
        String content = "게시글 내용";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("sjkim@unipoint.co.kr")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_enroll()
    {
        LocalDateTime now = LocalDateTime.of(2021,1,26,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("sjkim@unipoint.co.kr")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
