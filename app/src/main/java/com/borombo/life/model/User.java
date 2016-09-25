package com.borombo.life.model;

import java.util.ArrayList;

/**
 * Created by Erwan on 25/09/2016.
 */

public class User {

    private int id;
    private String name;
    private String url;
    private String description;
    private AvatarUrl avatar_urls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
