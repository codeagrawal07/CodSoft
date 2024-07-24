package Task_04;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.json.JSONObject;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class CurrencyConverter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
    private JComboBox<String> c1;
    private JComboBox<String> c2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter frame = new CurrencyConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CurrencyConverter() {                                  //Enter icon URL or set image path
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91766\\eclipse-workspace\\CodeSoft_Intership_Task\\img\\rupee-symbol.png"));
		setBackground(new Color(255, 255, 172));
		setTitle("CURRENCY CONVERTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 159));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("CURRENCY CONVERTER");
		l1.setFont(new Font("Tahoma", Font.BOLD, 25));
		l1.setBounds(68, 10, 313, 65);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 11));
		t1.setBackground(new Color(255, 255, 255));
		t1.setBounds(54, 155, 115, 22);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2.setBackground(new Color(255, 255, 255));
		t2.setBounds(281, 155, 115, 22);
		contentPane.add(t2);
		t2.setColumns(10);
		t2.setEditable(false);
		
		c1 = new JComboBox<String>();
		c1.setModel(new DefaultComboBoxModel<String>(new String[] {"AFN","AUD","BAM","INR", "USD", "EUR"}));
		c1.setBounds(54, 102, 115, 21);
		contentPane.add(c1);
		
		c2 = new JComboBox<String>();
		c2.setModel(new DefaultComboBoxModel<String>(new String[] {"AFN","AUD","BAM","INR", "USD", "EUR"}));
		c2.setBounds(281, 102, 115, 21);
		contentPane.add(c2);
		
		JButton b1 = new JButton("Convert");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				API obj = new API();
				try {
					obj.convert(c1,c2, t1,t2);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		b1.setForeground(new Color(0, 0, 0));
		b1.setBackground(new Color(0, 255, 0));
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBounds(20, 212, 96, 30);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Reset");
		b2.setForeground(new Color(0, 0, 0));
		b2.setBackground(new Color(65, 194, 250));
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				c1.setSelectedIndex(0);
				c2.setSelectedIndex(0);
			}
		});
		b2.setBounds(178, 212, 96, 30);
		contentPane.add(b2);
		
		JButton b3 = new JButton("Exit");
		b3.setForeground(new Color(255, 255, 255));
		b3.setBackground(new Color(255, 0, 0));
		b3.setFont(new Font("Tahoma", Font.BOLD, 12));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b3.setBounds(318, 212, 96, 30);
		contentPane.add(b3);
	}
}
class API {

    public void convert(JComboBox<String> c1, JComboBox<String> c2, JTextField t1, JTextField t2) throws IOException, InterruptedException {
        String str1=(String) c1.getSelectedItem();
        String str2=(String) c2.getSelectedItem();
        int amount = Integer.parseInt(t1.getText());                                           //past your api key
        var url="https://api.fastforex.io/convert?from="+str1+"&to="+str2+"&amount="+amount+"&api_key=accf2c584d-3b703d0fb5-sg9ayf";
        
        var request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client= HttpClient.newBuilder().build();
        var  response=client.send(request, HttpResponse.BodyHandlers.ofString());
        
       // System.out.println(response.body());
       
        JSONObject jsonResponse = new JSONObject(response.body());
        double str1Value = jsonResponse.getJSONObject("result").getDouble(str2);
        String result = String.valueOf(str1Value);
        t2.setText(result);
        System.out.print(str1Value);
}
    }
