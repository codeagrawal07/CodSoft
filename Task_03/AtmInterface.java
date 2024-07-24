package Task_03;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AtmInterface extends JFrame {

	private static final long serialVersionUID = 2L;
	protected JPanel contentPane;
	private JPanel panel;
	protected JTextField tb_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtmInterface frame = new AtmInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AtmInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BankAccount account = new BankAccount();
		ATM user = new ATM(account);
	
		JLabel L_UK_Bank_atm = new JLabel("UK BANK ATM");
		L_UK_Bank_atm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		L_UK_Bank_atm.setForeground(new Color(255, 255, 255));
		L_UK_Bank_atm.setBounds(180, 23, 169, 32);
		contentPane.add(L_UK_Bank_atm);
		
	    panel = new JPanel();
		panel.setBackground(new Color(0, 0, 166));
		panel.setBounds(45, 67, 420, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel L_main = new JLabel("Select a transaction");
		L_main.setForeground(new Color(255, 255, 0));
		L_main.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		L_main.setBounds(108, 0, 211, 43);
		panel.add(L_main);
		
		JLabel L2_wd = new JLabel("Withdrawal");
		L2_wd.setFont(new Font("Tahoma", Font.BOLD, 18));
		L2_wd.setForeground(new Color(255, 255, 0));
		L2_wd.setBounds(296, 114, 114, 30);
		panel.add(L2_wd);
		
		JLabel L3_dp = new JLabel("Deposit");
		L3_dp.setForeground(new Color(255, 255, 0));
		L3_dp.setFont(new Font("Tahoma", Font.BOLD, 18));
		L3_dp.setBounds(296, 166, 106, 30);
		panel.add(L3_dp);
		
		JLabel L1_bi = new JLabel("Balance Inquiry");
		L1_bi.setForeground(new Color(255, 255, 0));
		L1_bi.setFont(new Font("Tahoma", Font.BOLD, 18));
		L1_bi.setBounds(10, 116, 155, 35);
		panel.add(L1_bi);
		
		JLabel L5_ex = new JLabel("Exit");
		L5_ex.setForeground(new Color(255, 0, 0));
		L5_ex.setFont(new Font("Tahoma", Font.BOLD, 18));
		L5_ex.setBounds(10, 198, 45, 13);
		panel.add(L5_ex);
		
		tb_input = new JTextField();
		tb_input.setFont(new Font("Tahoma", Font.BOLD, 15));
		tb_input.setBounds(124, 67, 165, 19);
		panel.add(tb_input);
		tb_input.setColumns(10);
		
		JLabel L6_clear = new JLabel("Clear");
		L6_clear.setForeground(new Color(0, 255, 0));
		L6_clear.setFont(new Font("Tahoma", Font.BOLD, 18));
		L6_clear.setBounds(347, 60, 63, 30);
		panel.add(L6_clear);
		
		
		JButton B1_WD = new JButton("");
		B1_WD.setBackground(new Color(192, 192, 192));
		B1_WD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  int amt = Integer.parseInt(tb_input.getText());
              user.withdraw(amt);
			}
		});
		B1_WD.setBounds(475, 185, 27, 32);
		contentPane.add(B1_WD);
		
		JButton B2_DP = new JButton("");
		B2_DP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amt2 = Integer.parseInt(tb_input.getText());
				user.deposit(amt2);
			}
		});
		B2_DP.setBackground(new Color(192, 192, 192));
		B2_DP.setBounds(475, 234, 27, 32);
		contentPane.add(B2_DP);
		
		JButton B3_balance = new JButton("");
		B3_balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             String str= user.checkBalance();
             tb_input.setText(str);

			}
		});
		B3_balance.setBackground(new Color(192, 192, 192));
		B3_balance.setBounds(8, 185, 27, 32);
		contentPane.add(B3_balance);
		
		JButton B4_EX = new JButton("");
		B4_EX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		B4_EX.setBackground(new Color(255, 0, 0));
		B4_EX.setBounds(8, 263, 27, 32);
		contentPane.add(B4_EX);
		
		JButton B5_clear = new JButton("");
		B5_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  tb_input.setText("");
			}
		});
		B5_clear.setBackground(Color.GREEN);
		B5_clear.setBounds(475, 125, 27, 32);
		contentPane.add(B5_clear);
	}
	
}
class ATM
{   private BankAccount account;
     
    public ATM(BankAccount account) {
    this.account = account;
   }

    void withdraw(float amount)
    {
    	 if(account.getBalance()>=amount)
    	 {
            account.withdraw(amount);
    		JOptionPane.showMessageDialog(null,"Withdrawal Successful","UK BANK",JOptionPane.INFORMATION_MESSAGE);
    	 }
    	 else {
      	    JOptionPane.showMessageDialog(null,"Insufficient balance.","UK BANK",JOptionPane.WARNING_MESSAGE);}
    }
    void deposit(float amount)
    {
    	 account.deposit(amount);
      	 JOptionPane.showMessageDialog(null,"Deposit Successful !","UK BANK",JOptionPane.INFORMATION_MESSAGE);
    }
    String checkBalance()
    {
      float amu = this.account.getBalance();
      String str = String.valueOf(amu);
      return str;
    }
	
}

class BankAccount{
	private float balance;
	
	public float getBalance() {
        return balance;
    }
	public void withdraw(float amount) {
        balance -= amount;
    }

    public void deposit(float amount) {
        balance += amount;
    }
}



























