package com.nyomorultak.spring.api;

import com.nyomorultak.spring.web.*;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Wrapper {
    private static final String apiBase = "https://photorder-api.exmodify.com/";

    public static User registerUser(User user) {
        return requestUserEndpoint("/api/user/register", user).getData();
    }
    public static User loginUser(User user) {
        return requestUserEndpoint("/api/user/login", user).getData();
    }

    public static List<Image> getImages() {
        return requestImageEndpoint("/api/image/").data;
    }
    public static List<Image> getImages(int userId) {
        return requestImageEndpoint("/api/image/" + userId).data;
    }

    public static void updateImage(int id, int status) {
        requestPutImageEndpoint("/api/image/" + id + "/" + status);
    }
    public static void uploadImage(ImageUploadRequest image) {
        String url = apiBase + "/api/image/";
        RestTemplate template = new RestTemplate();
        template.postForObject(url, image, ImageApiResponse.class);
    }

    private static UserApiResponse requestUserEndpoint(String endpoint, User pushData) {
        String url = apiBase + endpoint;
        RestTemplate template = new RestTemplate();

        if (pushData == null) {
            return template.getForObject(url, UserApiResponse.class);
        } else {
            return template.postForObject(url, pushData, UserApiResponse.class);
        }
    }
    private static ImageApiResponse requestImageEndpoint(String endpoint) {
        String url = apiBase + endpoint;
        RestTemplate template = new RestTemplate();

        return template.getForObject(url, ImageApiResponse.class);
    }
    private static void requestPutImageEndpoint(String endpoint) {
        String url = apiBase + endpoint;
        RestTemplate template = new RestTemplate();

        RequestCallback requestCallback = template.acceptHeaderRequestCallback(ImageApiResponse.class);
        HttpMessageConverterExtractor<ImageApiResponse> responseExtractor =
                new HttpMessageConverterExtractor<>(ImageApiResponse.class, template.getMessageConverters());
        template.execute(url, HttpMethod.PUT, requestCallback, responseExtractor);
    }
}
