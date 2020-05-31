package visualsort;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

class GUI {
	JFrame mainFrame;
	JPanel panel;
	static JTextField tf0, tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	Font font;
	JButton sortButton;
	JRadioButton option1, option2;
	ButtonGroup group;
	boolean smallToGreat = false, greatToSmall = false;

	GUI() {
		font = new Font("Lucida Console", Font.BOLD, 40);
		
		mainFrame = new JFrame("Visual Sort");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(550, 350);
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainFrame.getContentPane().setBackground(Color.GRAY);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(440, 290));
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		tf0 = new JTextField();
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();	
		tf7 = new JTextField();	
		
		tf0.setBounds(5, 2, 100, 80);
		tf0.setFont(font);
		tf0.setHorizontalAlignment(JTextField.CENTER);
		
		tf1.setBounds(115, 2, 100, 80);
		tf1.setFont(font);
		tf1.setHorizontalAlignment(JTextField.CENTER);

		tf2.setBounds(225, 2, 100, 80);
		tf2.setFont(font);
		tf2.setHorizontalAlignment(JTextField.CENTER);
		
		tf3.setBounds(335, 2, 100, 80);
		tf3.setFont(font);
		tf3.setHorizontalAlignment(JTextField.CENTER);

		option1 = new JRadioButton("Smallest to Greatest", true);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				smallToGreat = true;
				greatToSmall = false;
			}
		});
		
		option2 = new JRadioButton("Greatest to Smallest");
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				greatToSmall = true;
				smallToGreat = false;
			}
		});
		
		group = new ButtonGroup();
		group.add(option1);
		group.add(option2);

		sortButton = new JButton("SORT");
		sortButton.setForeground(Color.GREEN);
		sortButton.setBounds(120, 140, 200, 40);
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetAllBoxes();

				boolean successful = false;
				int[] nums = new int[4];
				int[] result;

				addBorders();
				
				nums[0] = Integer.parseInt(tf0.getText());
				nums[1] = Integer.parseInt(tf1.getText());
				nums[2] = Integer.parseInt(tf2.getText());
				nums[3] = Integer.parseInt(tf3.getText());
				
				if (smallToGreat) {
					result = smallToGreatSort(nums);
				} else if (greatToSmall) {
					result = greatToSmallSort(nums);
				} else {
					result = smallToGreatSort(nums);
				}

				tf4.setText(Integer.toString(result[0]));
				tf5.setText(Integer.toString(result[1]));
				tf6.setText(Integer.toString(result[2]));
				tf7.setText(Integer.toString(result[3]));
				successful = true;

				removeBorders();
				if (successful) greenBordersForResult();
			}
		});

		tf4.setBounds(5, 200, 100, 80);
		tf4.setFont(font);
		tf4.setHorizontalAlignment(JTextField.CENTER);

		tf5.setBounds(115, 200, 100, 80);
		tf5.setFont(font);
		tf5.setHorizontalAlignment(JTextField.CENTER);
		
		tf6.setBounds(225, 200, 100, 80);
		tf6.setFont(font);
		tf6.setHorizontalAlignment(JTextField.CENTER);
		
		tf7.setBounds(335, 200, 100, 80);
		tf7.setFont(font);
		tf7.setHorizontalAlignment(JTextField.CENTER);

		option1.setBounds(75, 100, 150, 15);
		option2.setBounds(250, 100, 150, 15);

		option1.setBackground(Color.GRAY);
		option2.setBackground(Color.GRAY);
		
		panel.add(tf0);
		panel.add(tf1);
		panel.add(tf2);
		panel.add(tf3);
		panel.add(sortButton);
		panel.add(option1);
		panel.add(option2);
		panel.add(tf4);
		panel.add(tf5);
		panel.add(tf6);
		panel.add(tf7);
		
		mainFrame.add(panel);
	}

	public static int[] smallToGreatSort(int[] array) {
		try {
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = 0, k = 1; j < array.length - 1; j++, k++) {
					if (array[j] > array[k]) {
						int temp = array[j];
						array[j] = array[k];
						array[k] = temp;
					} else {
						continue;
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return array;
	}

	public static int[] greatToSmallSort(int[] array) {
		try {
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = 0, k = 1; j < array.length - 1; j++, k++) {
					if (array[j] < array[k]) {
						int temp = array[j];
						array[j] = array[k];
						array[k] = temp;
					} else {
						continue;
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return array;
	}

	public static void addBorders() {
		if (tf0.getText().isEmpty() || isNumeric(tf0.getText()) == false) 
			tf0.setBorder(new LineBorder(Color.RED, 3));
		else
			tf0.setBorder(new LineBorder(Color.GRAY, 3));

		if (tf1.getText().isEmpty() || isNumeric(tf1.getText()) == false) 
			tf1.setBorder(new LineBorder(Color.RED, 3));
		else
			tf1.setBorder(new LineBorder(Color.GRAY, 3));

		if (tf2.getText().isEmpty() || isNumeric(tf2.getText()) == false) 
			tf2.setBorder(new LineBorder(Color.RED, 3));
		else
			tf2.setBorder(new LineBorder(Color.GRAY, 3));

		if (tf3.getText().isEmpty() || isNumeric(tf3.getText()) == false) 
			tf3.setBorder(new LineBorder(Color.RED, 3));
		else
			tf3.setBorder(new LineBorder(Color.GRAY, 3));

	}

	public static void removeBorders() {
		tf0.setBorder(new LineBorder(Color.GRAY, 3));
		tf1.setBorder(new LineBorder(Color.GRAY, 3));
		tf2.setBorder(new LineBorder(Color.GRAY, 3));
		tf3.setBorder(new LineBorder(Color.GRAY, 3));
	}

	public static void greenBordersForResult() {
		tf4.setBorder(new LineBorder(Color.GREEN, 3));
		tf5.setBorder(new LineBorder(Color.GREEN, 3));
		tf6.setBorder(new LineBorder(Color.GREEN, 3));
		tf7.setBorder(new LineBorder(Color.GREEN, 3));
	}

	public static void resetAllBoxes() {
		tf0.setBorder(new LineBorder(Color.GRAY, 3));
		tf1.setBorder(new LineBorder(Color.GRAY, 3));
		tf2.setBorder(new LineBorder(Color.GRAY, 3));
		tf3.setBorder(new LineBorder(Color.GRAY, 3));
		tf4.setBorder(new LineBorder(Color.GRAY, 3));
		tf5.setBorder(new LineBorder(Color.GRAY, 3));
		tf6.setBorder(new LineBorder(Color.GRAY, 3));
		tf7.setBorder(new LineBorder(Color.GRAY, 3));
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
	    }
		try {
			int d = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;			    
		}													    
		return true;
	}

}
