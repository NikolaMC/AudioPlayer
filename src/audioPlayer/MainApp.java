package audioPlayer;

import javax.swing.SwingUtilities;

public class MainApp {

	public static void main(String[] args) {
		UserInterface UI = new UserInterface();
		
		SwingUtilities.invokeLater(UI);
	}

}
