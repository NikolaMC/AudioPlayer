package audioPlayer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {
	private JFrame frame;

	File fireplace = new File("sounds\\fireplace.wav");
	File bell = new File("sounds\\bell.wav");
	File dog = new File("sounds\\dog.wav");
	File seagulls = new File("sounds\\seagulls.wav");
	
	public UserInterface() { }
	
	@Override
	public void run() { // Create frame
		frame = new JFrame("Audio Player");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 80));
		
		createComponents(frame.getContentPane());
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
	private void createComponents(Container container) { // Create and organize buttons
		container.setLayout(new GridLayout(0, 4, 3, 0));
		
		JButton button1 = new JButton("Fireplace");
		JButton button2 = new JButton("Bell");
		JButton button3 = new JButton("Dog");
		JButton button4 = new JButton("Seagulls");
		
		container.add(button1);
		container.add(button2);
		container.add(button3);
		container.add(button4);
		
		// Add action listeners to the buttons with the path to the files
		button1.addActionListener(new InputListener(fireplace));
		button2.addActionListener(new InputListener(bell));
		button3.addActionListener(new InputListener(dog));
		button4.addActionListener(new InputListener(seagulls));
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
