package com.borombo.life.service;

import com.borombo.life.model.Categorie;
import com.borombo.life.model.Media;
import com.borombo.life.model.Post;
import com.borombo.life.model.Tag;
import com.borombo.life.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Erwan on 25/09/2016.
 */

public interface LifeService {

    String URL = "http://www.life.borombo.com/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(LifeService.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    LifeService service = retrofit.create(LifeService.class);

    @GET("/wp-json/wp/v2/posts")
    Call<List<Post>> listPosts();

    @GET("/wp-json/wp/v2/users/{user}")
    Call<User> getAuthor(@Path("user") int user);

    @GET("/wp-json/wp/v2/media/{media}")
    Call<Media> getMedia(@Path("media") int media);

    @GET("/wp-json/wp/v2/categories/{categorie}")
    Call<Categorie> getCategorie(@Path("categorie") int categorie);

    @GET("/wp-json/wp/v2/tags/{tag}")
    Call<Tag> getTag(@Path("tag") int tag);
}
