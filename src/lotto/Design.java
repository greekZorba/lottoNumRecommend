package lotto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class Design {

	BusinessLogic businessLogic = new BusinessLogic();
	
	JFrame jFrame = new JFrame();
	JPanel jPanelNorth = new JPanel();
	JPanel jPanelCenter = new JPanel();
	JPanel jPanelSouth = new JPanel();
	
	JTextField jTextField = new JTextField();
	JFormattedTextField jFormattedTextField = new JFormattedTextField(new NumberFormatter());
	
	JButton drawingLots = new JButton("추첨");
	Font font = new Font("돋움", Font.BOLD, 15);
	
	public Design() {
	
		jPanelNorth.setBackground(Color.LIGHT_GRAY);
		jPanelCenter.setBackground(Color.LIGHT_GRAY);
		jPanelSouth.setBackground(Color.LIGHT_GRAY);
		
		jFrame.setSize(400,200);
		jFrame.setLocation(800, 300);
		jTextField.setBackground(Color.WHITE);
		jTextField.setText("로또번호 추첨");
		jTextField.setEditable(false);
		jPanelNorth.add(jTextField);
		
		jFormattedTextField.setText("");
		jFormattedTextField.setFont(font);
		jFormattedTextField.setForeground(Color.WHITE);
		jFormattedTextField.setHorizontalAlignment(JTextField.CENTER);
		jFormattedTextField.setBackground(Color.BLACK);
		jFormattedTextField.setPreferredSize(new Dimension(300, 100));
		jPanelCenter.add(jFormattedTextField);
		
		drawingLots.addActionListener(new doActionListener());
		jPanelSouth.add(drawingLots);
		
		jFrame.add(jPanelNorth, "North");
		jFrame.add(jPanelCenter, "Center");
		jFrame.add(jPanelSouth, "South");
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jFrame.setVisible(true);
	}
	
	private class doActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			businessLogic.makeLotteryNum();
			String lotteryNum = businessLogic.getOutputLotteryNum();
			jFormattedTextField.setText(lotteryNum);
		}
		
	}
}
