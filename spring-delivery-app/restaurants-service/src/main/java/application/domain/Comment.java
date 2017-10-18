package application.domain;

import lombok.Data;

@Data
public class Comment {

    private Long id;

    private String comment;

    private String userId;
}
