package shop.mtcoding.blog.reply;


import lombok.Data;

import java.sql.Timestamp;

public class ReplyResponse {

    @Data
    public static class DTO {
        private Integer boardId;
        private Integer replyId;
        private Integer userId;
        private Boolean isReplyOwner;
        private String comment;
        private Timestamp createdAt;

        public DTO(Reply reply) {
            this.boardId = reply.getBoard().getId();
            this.replyId = reply.getId();
            this.userId = reply.getUser().getId();
            this.isReplyOwner = reply.isReplyOwner();
            this.comment = reply.getComment();
            this.createdAt = reply.getCreatedAt();
        }
    }
}
