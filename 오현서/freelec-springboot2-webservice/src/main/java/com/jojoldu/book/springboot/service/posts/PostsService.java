package com.jojoldu.book.springboot.service.posts;


import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsResponseDto requestDto){
        Posts posts = postsRepository.findBy(id).orElseThrow(()-> new
                IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
}
