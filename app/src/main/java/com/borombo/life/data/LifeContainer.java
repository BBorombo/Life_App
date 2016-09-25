package com.borombo.life.data;

import com.borombo.life.model.Categorie;
import com.borombo.life.model.Media;
import com.borombo.life.model.Post;
import com.borombo.life.model.Tag;
import com.borombo.life.model.User;

import java.util.ArrayList;

/**
 * Created by Erwan on 25/09/2016.
 */

public class LifeContainer {

    private static LifeContainer instance = null;

    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Categorie> categories = new ArrayList<>();
    private ArrayList<Tag> tags = new ArrayList<>();
    private ArrayList<Media> medias = new ArrayList<>();

    private LifeContainer(){}

    public static LifeContainer getInstance(){
        if (instance == null){
            instance = new LifeContainer();
        }
        return instance;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addCategorie(Categorie categorie){
        this.categories.add(categorie);
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    public void addMedia(Media media){
        this.medias.add(media);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Categorie> getCategories() {
        return categories;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public ArrayList<Media> getMedias() {
        return medias;
    }
}
