package application;


import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;

public class Speech {
    private static Media media;
    public static AudioClip player;
    public static boolean isMute = false;


    public static void player (String s){
        if(isMute){

        }else {
            media = new Media(new File(s).toURI().toString());
            player = new AudioClip(media.getSource());
            player.play();
        }
    }

    public static void stop(){
        if(player == null){

        }else{
            player.stop();
        }
    }



}
