import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author fqayy
 *
 */
public class redo_listener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game_page gp = new game_page();
		if (gp.cells_with_values() == 16) // meaning all cells are full
		{
			
				gp.set_error("Hurrah! You WON!");
			
		}
		else	
			gp.set_error("Game not Yet finished!");
		
	}

}
