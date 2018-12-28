import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


	public class click implements ActionListener
	{
		private JFrame frame;
		//static boolean flag = false;
		//private int[][] arr;
		
		public click(JFrame rulesframe)//, int[][] arr)
		{
			this.frame = rulesframe;
		//	this.arr = arr;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			game_page gp = new game_page(400,500);
			/*gp.add_buttons();
			if (flag == true)
			{			
				for (int i= 0; i< 4;i++)
				{
					for (int j= 0; j< 4;j++)
					{
						arr[i][j] = 0;
					}
				}
			}
			flag = true;*/
			
			
		}
		

}
