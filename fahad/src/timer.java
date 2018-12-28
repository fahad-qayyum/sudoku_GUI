import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

public class timer extends Component{

  //  JLabel the_time = time1;
public timer(textField[][] grid, JLabel countdownLabel) {
	//textField abort = new textField(); 
 //   final JLabel countdownLabel = new JLabel("05:00");
  //  timer time1 = new timer();
	
	final Timer t = new Timer(1000, new ActionListener() {
        int time = 301;
        @Override
        public void actionPerformed(ActionEvent e) {
            time--;
            countdownLabel.setText("Timer: "+format(time / 60) + ":" + format(time % 60));
            if (time == 0) {
                final Timer timer = (Timer) e.getSource();
                timer.stop();
                for (int i=0;i<4;i++)
                {
                	for (int j=0;j<4;j++)
                	{
                		grid[i][j].get_tf().setEditable(false);
                		game_page gp = new game_page("Game is over!");
                		

                    }
                }
            }
            else if (time <= 60)
            {
            	countdownLabel.setForeground(Color.red);
            }
            else if(time > 60)
            {
            	countdownLabel.setForeground(Color.green);
            }
        }
        
    });
      t.start();
   }

  private static String format(int i) {
      String result = String.valueOf(i);
      if (result.length() == 1) {
          result = "0" + result;
      }
      return result;
  }

 
}


