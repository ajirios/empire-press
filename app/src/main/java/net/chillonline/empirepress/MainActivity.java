package net.chillonline.empirepress;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends YouTubeBaseActivity

{
    private static final String TAG = "MainActivity";

    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");
        btnPlay = (Button) findViewById(R.id.btnPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener()

        {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)

            {
                Log.d(TAG, "onClick: Done initializing.");
                List<String> videoList = new ArrayList<>();
                videoList.add("JMn9inxWLgc");
                videoList.add("URJWcceup8A");
                videoList.add("A9JEHWHx0WU");
                videoList.add("2FqFNckpDi4");
                videoList.add("YyeX6ArxCYI");
                youTubePlayer.loadVideos(videoList);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)

            {
                Log.d(TAG, "onClick: Failed to initialize.");
            }

        };

        btnPlay.setOnClickListener(new View.OnClickListener()
                                   {

                                       @Override
                                       public void onClick(View view)

                                       {
                                           Log.d(TAG, "onClick: Initializing YouTube Player.");
                                           mYouTubePlayerView.initialize(YouTubeApiIsland.getApiKey(), mOnInitializedListener);
                                       }

                                   }
        );

    }

}


