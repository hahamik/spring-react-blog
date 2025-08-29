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

    @Data
    public static class DetailDTO {
        private Integer id;
        private String comment;
        private Integer userId;
        private String username;
        private Boolean owner;

        public DetailDTO(Reply reply, int sessionUserId) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.userId = reply.getUser().getId();// lazy loading 안됨
            this.username = reply.getUser().getUsername(); // lazy loading 안됨 유저가 영속화 되어 있음
            this.owner = reply.getUser().getId() == sessionUserId;
        }
    }
}
