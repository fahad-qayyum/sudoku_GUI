import java.awt.*;
import java.net.URL;
import java.util.Random;
import javax.swing.*;


public class game_page {
	static textField cell[][] = new textField[4][4];
	int row_array[]= new int[16];
	int column_array[]= new int[16];
	static int[][] values = new int[4][4];
	Font font = new Font("Microsoft Sans Serif",Font.ROMAN_BASELINE,18);
	Font errFont = new Font("Microsoft Sans Serif",Font.ROMAN_BASELINE,18);
	static JLabel err = new JLabel();
	static JPanel panel = new JPanel(null);
	JFrame frame = new JFrame("Sudoku");

public game_page()
{
	
}
	
public game_page(String text)
	{
	err.setText(text);
	err.setBounds(100, 275, 300, 50);
	panel.add(err);
	err.setFont(errFont);
	err.setForeground(Color.red);
	}

public game_page(int width, int height )
{
	panel.removeAll();
	int dimention=50;
	Color color = Color.decode("#34495e");
	for (int i= 0; i< 4;i++)
	{
		for (int j= 0; j< 4;j++)
		{
			values[i][j] = 0;
		}
	}
	frame.add(panel);
	panel.setBackground(color);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(width, height);
	frame.setLocationRelativeTo(null);
	int x=100,y=50; 
	int j=0;
	int value ;
	
	//printing the cells on panel
	for(int i= 0; i < 4; i ++)
	{
		for ( j=0; j < cell[i].length; j++)
		{
			cell[i][j] = new textField();
			
			panel.add(cell[i][j].get_tf());
			cell[i][j].get_tf().setBounds(x, y, dimention, dimention);
			x=x+50;

		}
		y = y +50;
		x= 100;
	}
	int count = 0 ;
	Random rn = new Random();
	
	// printing the random numbers 
	while(count < 4)
	{	
		x = rn.nextInt(4);
		y = rn.nextInt(4);
		value = rn.nextInt(4)+1;
		if (checkSubGrid(value,x,y) && check_column(value,y)== 0 && check_row(value,x)== 0 )
		{
			cell[x][y].get_tf().setText(Integer.toString(value));
			cell[x][y].get_tf().setEditable(false);
			values[x][y] = value;	
			count++;
		}
	
	}
	
		// adding the unused element indexes to the row and column array
	
		int counter = 0; // it would give the number of editable cells
		for(int row=0; row<4;row++)
		{
			for(int column=0; column<4;column++)
			{
				
				if(cell[row][column].get_tf().isEditable())
				{
					//System.out.println("["+row+"]"+"["+column+"] is Editable");
					row_array[counter]= row;
					column_array[counter]=column;
					counter ++;
				}
			}
		}
		/*System.out.println(counter);

		for(int k=0;k<row_array.length;k++)
		{
			System.out.print(row_array[k]+" ");
			System.out.println(column_array[k]+" ");
		}
		System.out.println(row_array.length);
		System.out.println(column_array.length);*/

		for(int i=0;i<counter;i++)
		{
			textField tf= new textField(i);
			cell[row_array[i]][column_array[i]].checkRow(cell[row_array[i]][column_array[i]].get_tf(), row_array[i], column_array[i]);
			if (tf.flag == (false))
					{
						cell[row_array[i]][column_array[i]].setEditable(false);
						tf.set_flag(false);
					}
		}	
		//cell[0][0].checkRow(cell[0][0].get_tf(), 0);
		textListener listen = new textListener(cell[0][0]);
		cell[0][0].get_tf().addActionListener(listen);
		
		add_buttons();
		

		
}

public int check_column(int n, int c)
{	
	int nu= 0;
	for(int i=0; i< 4; i++)
	{
		if(values[i][c] == n)
		{
			nu ++;
		}
	}
	return nu;

}
public int check_row(int n, int r) // returns 0 if there is no duplicates
{	
	int nu= 0;
	for(int i=0; i< 4; i++)
	{
		// if there is a duplicate then count is increased
		if(values[r][i] == n)
		{
			nu ++;
		}
	}
	return nu;
}
 // returns true if no duplicates
public boolean checkSubGrid(int n, int r,int c)
{
	boolean flag= false;
	if (r < 2 && c < 2) 
		{
			if ((n ==values[0][0]) || (n ==values[0][1]) || (n ==values[1][0]) || (n == values[1][1] ) )
			{
				flag= false;
			}
			else
			{
				flag = true;
			}
			
		}
	else if (r < 2 && c >= 2)
	{
		if ((n ==values[0][2]) || (n ==values[0][3]) || (n ==values[1][2]) || (n == values[1][3] ) )
		{
			flag= false;
		}
		else
		{
			flag = true;
		}
	}	
	else if (r >= 2 && c < 2)
	{
		if ((n ==values[2][0]) || (n ==values[2][1]) || (n ==values[3][0]) || (n == values[3][1] ) )
		{
			flag= false;
		}
		else
		{
			flag = true;
		}
	}	
	else if (r >= 2 && c >= 2)
	{
		if ((n ==values[2][2]) || (n ==values[2][3]) || (n ==values[3][2]) || (n == values[3][3] ) )
		{
			flag= false;
		}
		else
		{
			flag = true;
		}
	}	
		return flag;
	
}

public void add_buttons()
{
	JLabel time = new JLabel();
	timer timer = new timer(cell , time);
	
	panel.add(time);
	time.setBounds(10, 0, 120, 50);
	time.setFont(font);

	JButton restart = new JButton("Restart");
	panel.add(restart);
	restart.setBounds(25, 380, 100, 50);
	click click = new click(frame);
	//click c = new click(values);
	restart.addActionListener(click);
	
	
	
	JButton undo = new JButton("Undo");
	panel.add(undo);
	undo.setBounds(145, 380, 100, 50);
	JButton redo = new JButton("Redo");
	panel.add(redo);
	redo.setBounds(265, 380, 100, 50);
	
}
public void set_error(String error)
{
	game_page gp= new game_page(error);
}
}
