package com.borombo.life.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.borombo.life.R;
import com.borombo.life.data.LifeContainer;
import com.borombo.life.model.Post;
import com.borombo.life.service.LifeService;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    AVLoadingIndicatorView loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader = (AVLoadingIndicatorView) findViewById(R.id.loader);
        new getData().execute();
    }

    public class getData extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loader.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Call<List<Post>> operationsService = LifeService.service.listPosts();
            try {
                List<Post> list = operationsService.execute().body();
                for (Post post : list) {
                    post.initRessources();
                    LifeContainer.getInstance().addPost(post);
                }
            } catch (IOException e) {e.printStackTrace();}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            loader.hide();
        }
    }

}
