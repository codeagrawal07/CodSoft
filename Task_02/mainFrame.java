package Task_02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class mainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private List<JTextField> marksFields;
	private int num;
	private JLabel l3=new JLabel("Grade");;
	private JLabel l4=new JLabel("Average Percentage");
	
  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {                                       
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainFrame() {                                      //enter your main icon URL
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91766\\eclipse-workspace\\CodeSoft_Intership_Task\\img\\calculator-icon.jpg"));
	
		setBackground(new Color(192, 192, 192));
		setForeground(new Color(255, 0, 0));
		setTitle("STUDENT GRADE CALCULATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(450,500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel L1_main = new JLabel("STUDENT GRADE CALCULATOR");
		L1_main.setFont(new Font("Arial Narrow", Font.BOLD, 19));
		L1_main.setForeground(new Color(255, 0, 0));
		L1_main.setBounds(104, 23, 257, 48);
		contentPane.add(L1_main);

		JLabel l2 = new JLabel("TOTAL SUBJECTS");
		l2.setFont(new Font("Arial Black", Font.BOLD, 11));
		l2.setBounds(10, 91, 133, 41);
		contentPane.add(l2);

		t1 = new JTextField();
		t1.setBounds(153, 103, 96, 19);
		contentPane.add(t1);
		t1.setColumns(10);
		JButton b2 = new JButton("CALCULATE");
		JButton b1 = new JButton("ENTER");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					num = Integer.parseInt(t1.getText());
					marksFields = new ArrayList<>();
					for (int i = 0; i < num; i++) {
						JTextField marksField = new JTextField();
						JLabel l2= new JLabel("Subject "+ (i+1));
						marksField.setBounds(153, 130 + (20 * i), 96, 19);
						l2.setBounds(10,130+(20*i),80,19);
						contentPane.add(marksField);
						marksFields.add(marksField);
						contentPane.add(l2);
					}
					
					contentPane.revalidate();
					contentPane.repaint();
				
					b2.setFont(new Font("Consolas", Font.BOLD, 11));
					b2.setBackground(new Color(255, 255, 0));
					b2.setForeground(new Color(255, 0, 0));
					b2.setBounds(153,133+21*num, 96, 19);
					contentPane.add(b2);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane, "Invalid marks format ","WARNING",JOptionPane.WARNING_MESSAGE);}
					
			}
		});
		b1.setHorizontalAlignment(SwingConstants.LEFT);
		b1.setFont(new Font("Consolas", Font.BOLD, 11));
		b1.setBackground(new Color(255, 255, 0));
		b1.setForeground(new Color(255, 0, 0));
		b1.setBounds(273, 101, 69, 19);
		contentPane.add(b1);
		
		JLabel lblNewLabel = new JLabel("");                  //enter your main icon URL
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91766\\eclipse-workspace\\CodeSoft_Intership_Task\\img\\codsoft_ico (1).png"));
		lblNewLabel.setBounds(4, 10, 90, 90);
		contentPane.add(lblNewLabel);
        
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeCal();             //calling function to Calculate Grade 
				}
		});
	}
	void GradeCal()
	{                                //function Calculate Grade 
	    int sum=0;
	    int avg;
		try {
			for (JTextField marksField : marksFields) {
				int mark = Integer.parseInt(marksField.getText());
				sum+=mark;
			     }  
		    } 
		catch (NumberFormatException ex) {
			//System.out.println("Invalid marks format");
			JOptionPane.showMessageDialog(contentPane, "Invalid marks format ","WARNING",JOptionPane.WARNING_MESSAGE);}
		
      avg=sum/num;
      String str= String.valueOf(avg);
      
      if(avg<=100 && avg >=86)
      {
    	  l3.setText("Grade A+");
    	  l4.setText("Average Percentage "+str);

      }
      else if(avg<=85 && avg >=76)
      {
    	  l3.setText("Grade A-");
    	  l4.setText("Average Percentage "+str);
      }
      else if(avg<=75 && avg >=66)
      {
    	  l3.setText("Grade B+");
    	  l4.setText("Average Percentage "+str);
      }
      else if(avg<=65 && avg >=50)
      {
    	  l3.setText("Grade B-");
    	  l4.setText("Average Percentage "+str);
      }
      else if(avg<=49 && avg >=40)
      {
    	  l3.setText("Grade C+");
    	  l4.setText("Average Percentage "+str);
      }
      else if(avg<=39 && avg >=33)
      {
    	  l3.setText("Grade C-");
    	  l4.setText("Average Percentage "+str);
      }
      else                                                //Below 33 get F Grade
      {
    	  l3.setText("Grade F");
    	  l4.setText("Average Percentage "+str);  
      }
	      l3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		  l3.setForeground(new Color(255, 0, 0));
		  l3.setBounds(10,200+22*num,80,20);
		  l4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		  l4.setForeground(new Color(255, 0, 0));
		  l4.setBounds(120,200+22*num,180,20);
		  contentPane.add(l3);
    	  contentPane.add(l4);
    	  contentPane.revalidate();
		  contentPane.repaint();
	}
}
