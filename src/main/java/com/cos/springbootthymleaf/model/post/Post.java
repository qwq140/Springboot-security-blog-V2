package com.cos.springbootthymleaf.model.post;

import com.cos.springbootthymleaf.model.reply.Reply;
import com.cos.springbootthymleaf.model.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // 양방향 매핑 post를 select 할 때 reply도 가져와야 한다.
    @JsonIgnoreProperties({"post"}) // Reply 안에 있는 post를 getter 때리지마라
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("id desc")
    private List<Reply> replies;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime updated;

}
