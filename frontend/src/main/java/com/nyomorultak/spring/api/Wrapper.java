package com.nyomorultak.spring.api;

import com.nyomorultak.spring.web.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

public class Wrapper {
    private static final String apiBase = "https://photorder-api.exmodify.com/";

    public static User registerUser(User user) {
        return requestUser("/api/user/register", user).getData();
    }
    public static User loginUser(User user) {
        return requestUser("/api/user/login", user).getData();
    }

    public static List<Image> getImages() {
        return requestImage("/api/image/", null).data;
    }
    public static List<Image> getImages(int userId) {
        return requestImage("/api/image/" + userId, null).data;
    }

    public static UserApiResponse requestUser(String endpoint, User pushData) {
        String url = apiBase + endpoint;
        RestTemplate template = new RestTemplate();

        if (pushData == null) {
            return template.getForObject(url, UserApiResponse.class);
        } else {
            return template.postForObject(url, pushData, UserApiResponse.class);
        }
    }
    public static ImageApiResponse requestImage(String endpoint, Image pushData) {
        String url = apiBase + endpoint;
        RestTemplate template = new RestTemplate();

        if (pushData == null) {
            return template.getForObject(url, ImageApiResponse.class);
        } else {
            return template.postForObject(url, pushData, ImageApiResponse.class);
        }
    }
}
