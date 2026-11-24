interface MusicPlayer{
    boolean play(String artist, String title);
}

class LegacyMusicPlayer{
    public int playTrack(String track){
        if(track == null || track.trim().isEmpty()){
            return 0;
        }
        System.out.println("[LEGACY PLAYER] "+track);
        return 1;
    }
}

class LegacyMusicPlayerAdapter implements MusicPlayer{
    private static final int SUCCESS = 1;

    private final LegacyMusicPlayer legacyPlayer;

    public LegacyMusicPlayerAdapter(LegacyMusicPlayer legacyPlayer){
        this.legacyPlayer = legacyPlayer;
    }

    @Override
    public boolean play(String artist, String title){
        int status = legacyPlayer.playTrack(formatTrack(artist,title));
        return status == SUCCESS;
    }

    private String formatTrack(String artist, String title){
        if(artist.isEmpty() || title.isEmpty()){
            return "";
        }
        return artist.trim()+" - "+title.trim();
    }
}

class Track{
    private final String artist;
    private final String title;

    public Track(String artist, String title){
        this.artist = artist;
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }

    public String getTitle(){
        return title;
    }

}

class StreamingPlayer{
    public boolean stream(Track track){
        if(track == null || track.getArtist() == null || track.getTitle() == null){
            return false;
        }

        System.out.println("[Streaming Playe] "+track.getTitle()+" by "+track.getArtist());
        return true;
    }
}

class MusicApp{
    private final MusicPlayer player;

    public MusicApp(MusicPlayer player){
        this.player = player;
    }

    public void playSong(String artist, String title){
        boolean success = player.play(artist,title);
        if(success){
            System.out.println("Now playinh: "+artist+" - "+title);
        } else {
            System.out.println("Playback failed for: "+artist+" - "+title);
        }
    }
}

public class Level1 {
    public static void main(String[] args){
        System.out.println("~~~Legacy Player Through Adapter~~~");

        MusicPlayer legacy = new LegacyMusicPlayerAdapter(new LegacyMusicPlayer());
        MusicApp app = new MusicApp(legacy);

        app.playSong("Yazid","sda3 rrass");
        app.playSong("mute guy","");
        app.playSong("","vooooo");

        System.out.println("~~~Streaming Player Through Adapter ~~~");

        StreamingPlayer app1 = new StreamingPlayer();

        //app1.stream();
    }
}
