import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class How_Much_Is_Too_Much extends JFrame {

	private JPanel contentPane;
	public String age;
	public String weight;
	public double multiplier;		//alcohol resistance
	public double maxAlcohol;		//default alcohol resistance
	public double threshold;		//shouldn't drink over
	public double initialThreshold;	//threshold
	public double percentage;
	private JTextField textField;
	public ImageIcon default_icon;
	public ArrayList<String> userInput = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					How_Much_Is_Too_Much frame = new How_Much_Is_Too_Much();
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
	public How_Much_Is_Too_Much() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel input_Panel = new JPanel();
		contentPane.add(input_Panel, BorderLayout.WEST);
		input_Panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		input_Panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Age range:");
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setBackground(Color.DARK_GRAY);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "18-25", "26-35", "36-50", "51+"}));
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		input_Panel.add(panel_2);
		
		JLabel lblWeight = new JLabel("Weight (kg):");
		panel_2.add(lblWeight);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.WHITE);
		comboBox_2.setBackground(Color.BLACK);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "45-55", "56-70", "71-90", "91+"}));
		panel_2.add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		input_Panel.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Height (ft):");
		panel_3.add(lblNewLabel_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setForeground(Color.WHITE);
		comboBox_3.setBackground(Color.DARK_GRAY);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "Below 5ft", "5'1' - 6'0'", "6'1' - 7'0'", "Above 7'0'"}));
		panel_3.add(comboBox_3);
		
		JPanel panel_4 = new JPanel();
		input_Panel.add(panel_4);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				age = comboBox_1.getSelectedItem().toString();
				weight = comboBox_2.getSelectedItem().toString();
				userInput.clear();
				userInput.add(age);
				userInput.add(weight);
				System.out.println(userInput);
				switch(age) {
					case "18-25":
						multiplier = 1;
						break;
					case "26-35":
						multiplier = 1.2;
						break;
					case "36-50":
						multiplier = 0.8;
						break;
					case "51+":
						multiplier = 0.6;
						break;
				}
				switch(weight) {
					case "45-55":
						maxAlcohol = 70;
						break;
					case "56-70":
						maxAlcohol = 90;
						break;
					case "71-90":
						maxAlcohol = 110;
						break;
					case "91+":
						maxAlcohol = 120;
						break;
				}
				threshold = maxAlcohol * multiplier;
				initialThreshold = threshold;	//constant
				
			}
		});
//		btnNewButton.setVerticalAlignment(SwingConstants.CENTER);
		panel_4.add(btnNewButton);
		
		JPanel ouput_Panel = new JPanel();
		contentPane.add(ouput_Panel, BorderLayout.EAST);
		ouput_Panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		ouput_Panel.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Type:");
		panel_6.add(lblNewLabel_2);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setForeground(Color.WHITE);
		comboBox_4.setBackground(Color.DARK_GRAY);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"", "Beer", "Cider", "Wine", "Whiskey", "Liquor", "Vodka", "Tequila", "Absinthe"}));
		panel_6.add(comboBox_4);
		
		JPanel panel_7 = new JPanel();
		ouput_Panel.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Size (ml):");
		panel_7.add(lblNewLabel_3);
			
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setForeground(Color.WHITE);
		comboBox_5.setBackground(Color.DARK_GRAY);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"", "10", "25", "50", "100", "250", "500"}));
		panel_7.add(comboBox_5);
		
		JPanel panel_8 = new JPanel();
		ouput_Panel.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_9 = new JPanel();
		ouput_Panel.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(11);
		
	
		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10, BorderLayout.CENTER);
		
		
		JPanel panel_11 = new JPanel();
		contentPane.add(panel_11, BorderLayout.NORTH);
		
		
		JLabel lblNewLabel_5 = new JLabel("How Much is 2 Much?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_11.add(lblNewLabel_5);
		
		ImageIcon empty = new ImageIcon(this.getClass().getResource("empty.png"));
		ImageIcon green = new ImageIcon(this.getClass().getResource("green.png"));
		ImageIcon yellow = new ImageIcon(this.getClass().getResource("yellow.png"));
		ImageIcon red = new ImageIcon(this.getClass().getResource("red.png"));
		JLabel lblNewLabel_4 = new JLabel(empty);
		panel_10.add(lblNewLabel_4);
		
		
		JButton btnNewButton_1 = new JButton("Drink");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = comboBox_4.getSelectedItem().toString();
				if(x=="Beer" || x == "Cider") {
					threshold -= Integer.valueOf(comboBox_5.getSelectedItem().toString()) * 0.04;
				}
				else if (x == "Wine") {
					threshold -= Integer.valueOf(comboBox_5.getSelectedItem().toString()) * 0.14;
				}
				else if (x=="Whiskey" || x == "Liquor") {
					threshold -= Integer.valueOf(comboBox_5.getSelectedItem().toString()) * 0.4;
				}
				else if (x == "Vodka" || x == "Tequila") {
					threshold -= Integer.valueOf(comboBox_5.getSelectedItem().toString()) * 0.65;
				}
				else {
					threshold -= Integer.valueOf(comboBox_5.getSelectedItem().toString()) * 0.8;
				}
				textField.setText("");
				percentage = 100 - ((threshold/initialThreshold)*100);
				
				if(percentage < 100) {
					textField.setText(String.format("%.0f", percentage) + "%");
				}
				else {
					textField.setText("Over Alcohol limit!");
				}
				if (percentage <25) {
					lblNewLabel_4.setIcon(empty);			
				}
				else if (percentage <50 && percentage >25) {
					lblNewLabel_4.setIcon(green);	
					
				}
				else if (percentage<75 && percentage >50) {
					lblNewLabel_4.setIcon(yellow);	
					
				}
				else {
					lblNewLabel_4.setIcon(red);	}
			}
		});
		panel_9.add(btnNewButton_1);
		
		
		
	}

}