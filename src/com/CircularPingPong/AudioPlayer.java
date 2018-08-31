package com.CircularPingPong;
import java.util.Map;
import java.util.HashMap;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Music;
public class AudioPlayer
{
    public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    public static Map<String ,Music> musicMap = new HashMap<String, Music>();
    
    public static void load()
    {

        try
        {
            musicMap.put("music", new Music("res/output.ogg"));
            soundMap.put("Player_Hit", new Sound("res/PlayerHit.wav"));
            soundMap.put("Opponent_Hit", new Sound("res/PlayerHit.wav"));
            soundMap.put("Table_Hit", new Sound("res/TableHit.wav"));
            soundMap.put("Score", new Sound("res/Score.wav"));
            soundMap.put("No_Score", new Sound("res/No_Score.wav"));
            soundMap.put("Won_Game", new Sound("res/WonGame.wav"));
        }
        catch(SlickException e)
        {
            e.printStackTrace();
        }
    }
    public static Music getMusic(String key)
    {
        return musicMap.get(key);
    }
    public static Sound getSound(String key)
    {
        return soundMap.get(key);
    }
}
    
