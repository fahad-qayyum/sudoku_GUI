import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;

public class mouse implements MouseMotionListener{
	private JButton start;
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		 start.setFocusPainted(true);
    	 start.setBorderPainted(true);
    	 start.setContentAreaFilled(false);
    	 start.setForeground(Color.white);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		 start.setFocusPainted(true);
    	 start.setBorderPainted(true);
    	 start.setContentAreaFilled(true);
    	 start.setForeground(Color.black);
	}

public JButton get_b()
{
	return start;
}

}
