package audioPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class InputListener implements ActionListener {
	
	static Clip clip;
	public static AudioInputStream audioInputStream;
	File path;
	
	public InputListener(File file) { // Make it so the correct file is used
		path = file;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			if (clip != null && clip.isActive()) { // If a sound file is playing when user clicks on a button, end it
				clip.stop();
			}
			
			audioInputStream = AudioSystem.getAudioInputStream(path);
			
			try { // Play the sound file
				
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
				
			} catch (LineUnavailableException e2) { }
			
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
