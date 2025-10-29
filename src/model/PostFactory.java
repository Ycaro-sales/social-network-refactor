package model;

import java.util.UUID;

public class PostFactory {
    public static Post createPost(String postType, UUID userId, String content, Object... additionalParams) {
        switch (postType.toUpperCase()) {
            case "TEXT":
                return new TextPost(userId, content);
            case "IMAGE":
                String description = (String) additionalParams[0];
                return new ImagePost(userId, content, description);
            case "VIDEO":
                String videoDescription = (String) additionalParams[0];
                int duration = (Integer) additionalParams[1];
                return new VideoPost(userId, content, videoDescription, duration);
            default:
                throw new IllegalArgumentException("Unknown post type: " + postType);
        }
    }
}
