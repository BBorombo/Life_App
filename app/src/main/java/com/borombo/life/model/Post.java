package com.borombo.life.model;

import com.borombo.life.data.LifeContainer;
import com.borombo.life.service.LifeService;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by Erwan on 25/09/2016.
 */

public class Post {

    private int id;
    private String date;
    private String link;
    private int featured_media;
    private Text title;
    private Text content;
    private int author;
    private ArrayList<Integer> categories;
    private ArrayList<Integer> tags;

    private ArrayList<Categorie> _categories = new ArrayList<>();
    private ArrayList<Tag> _tags = new ArrayList<>();
    private User _author;
    private Media cover;

    /**
     * Fonction qui permllet d'initialiser les objets des ressources du post
     */
    public void initRessources() throws IOException {
        setAuthorRessource();
        setMediaRessource();
        setCategorieRessource();
        setTagRessource();
    }

    /**
     * Récupère l'objet de l'auteur du post
     */
    private void setAuthorRessource() throws IOException {
        Call<User> userCall = LifeService.service.getAuthor(this.author);
        _author = userCall.execute().body();
        LifeContainer.getInstance().addUser(_author);
    }

    /**
     * Récupère l'image du media du poste si elle existe
     */
    private void setMediaRessource() throws IOException {
        Call<Media> mediaCall = LifeService.service.getMedia(this.featured_media);
        cover = mediaCall.execute().body();
        LifeContainer.getInstance().addMedia(cover);
    }

    /**
     * Récupère les catégories du posts
     */
    private void setCategorieRessource() throws IOException {

        for (final int categorie: categories) {
            Call<Categorie> categorieCall = LifeService.service.getCategorie(categorie);
            Categorie c = categorieCall.execute().body();
            _categories.add(c);
            LifeContainer.getInstance().addCategorie(c);
        }
    }

    /**
     * Récupère les tages du post
     */
    private void setTagRessource() throws IOException {

        for (int tag:tags) {
            Call<Tag> tagCall = LifeService.service.getTag(tag);
            Tag t = tagCall.execute().body();
            _tags.add(t);
            LifeContainer.getInstance().addTag(t);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getFeatured_media() {
        return featured_media;
    }

    public void setFeatured_media(int featured_media) {
        this.featured_media = featured_media;
    }

    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public Text getContent() {
        return content;
    }

    public void setContent(Text content) {
        this.content = content;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public ArrayList<Integer> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Integer> categories) {
        this.categories = categories;
    }

    public ArrayList<Integer> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Integer> tags) {
        this.tags = tags;
    }

    public ArrayList<Categorie> get_categories() {
        return _categories;
    }

    public void set_categories(ArrayList<Categorie> _categories) {
        this._categories = _categories;
    }

    public ArrayList<Tag> get_tags() {
        return _tags;
    }

    public void set_tags(ArrayList<Tag> _tags) {
        this._tags = _tags;
    }

    public User get_author() {
        return _author;
    }

    public void set_author(User _author) {
        this._author = _author;
    }

    public Media getCover() {
        return cover;
    }

    public void setCover(Media cover) {
        this.cover = cover;
    }
}
