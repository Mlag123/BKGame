package Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip clip;
    private AudioInputStream sound;

    public void setFile(String fileName) {
        try {
            File file = new File(fileName);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        clip.start();
    }

    public void stop() throws IOException {
        sound.close();
        clip.close();
        ;
        clip.stop();
    }

}
