import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Mustafa
 *
 */
public class cellsListener implements ActionListener{
	public JTextField textbox;
	public cellsListener(JTextField textbox)
	{
		this.textbox = textbox;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		textbox.setBackground(Color.green);
		textbox.setText("FQ");
	}

}
