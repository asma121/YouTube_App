package com.example.youtubeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MainActivity : AppCompatActivity() {
    lateinit var youTubePlayerView:YouTubePlayerView
    lateinit var rv:RecyclerView
    lateinit var player: YouTubePlayer
    lateinit var vedioesList:ArrayList<ArrayList<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        youTubePlayerView=findViewById(R.id.youTubePlayerView)
        rv=findViewById(R.id.rv)

        vedioesList= arrayListOf(arrayListOf("Room | 1. Introduction","SkvNpRKnZNE"),
            arrayListOf("Room | 2. Entity","ACx_1vvWu48"),
            arrayListOf("Room | 3. Dao & Database","y30EfQQiOSM"),
            arrayListOf("Room | 4.1 do it with RXJava- UI","4m2c4CIIxes"),
            arrayListOf("Room | 4.2 do it with RXJava - logic","kS7qX7ND8eA"),
            arrayListOf("Room | 5. Type Converter","RhEb40BEGUk"))

        youTubePlayerView.addYouTubePlayerListener(object:AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                player=youTubePlayer
                player.loadVideo(vedioesList[0][1],0f)

                rv.adapter=myAdapter(vedioesList,player)
                rv.layoutManager=LinearLayoutManager(this@MainActivity)
            }
        })

    }
}