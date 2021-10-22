package com.cos.springbootthymleaf.model.reply;

import com.cos.springbootthymleaf.model.post.Post;
import com.cos.springbootthymleaf.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @JoinColumn(name = "postId")
    @ManyToOne
    private Post post;
}
