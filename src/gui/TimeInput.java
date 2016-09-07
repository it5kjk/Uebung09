package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class TimeInput extends JFrame {

	private JPanel contentPane;
	// text fields
	private JTextField tfHourInput;
	private JTextField tfMinuteInput;
	// labels
	private JLabel lblHour;
	private JLabel lblMinute;
	private JLabel lblOutput;
	//buttons
	private JButton btnConfirm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
				}
				try {
					TimeInput frame = new TimeInput();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimeInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(100, 100, 355, 140);
		//setSize(1024,700);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblHour = new JLabel("Stunden");
		lblHour.setBounds(10, 20, 70, 10);
		contentPane.add(lblHour);
		
		lblMinute = new JLabel("Minuten");
		lblMinute.setBounds(125, 20, 50, 10);
		contentPane.add(lblMinute);
		
		
		tfHourInput = new JTextField();
		tfHourInput.setBounds(10, 35, 60, 20);
		contentPane.add(tfHourInput);
		
		tfMinuteInput = new JTextField();
		tfMinuteInput.setBounds(125, 35, 60, 20);
		contentPane.add(tfMinuteInput);

		
		btnConfirm = new JButton("Übernehmen");
		btnConfirm.setBounds(225, 30, 95, 25);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printTime();
			}
		});
		contentPane.add(btnConfirm);
		
		
		lblOutput = new JLabel("");
		lblOutput.setBounds(10, 70, 150, 15);
		contentPane.add(lblOutput);
	}
	
	private void printTime() {
		try {
			int x = Integer.parseInt(tfHourInput.getText());
			int y = Integer.parseInt(tfMinuteInput.getText());
			
			if ( x < 0 || x > 23 ) {
				throw new NumberFormatException("Ungültige Stundenangabe!");
			}
			
			if (y > 59) {
				throw new NumberFormatException("Ungültige Minutenangabe!");
			}
			
			String time = tfHourInput.getText().concat(":")
					.concat(tfMinuteInput.getText());
			lblOutput.setText("Ihre Uhrzeit ist " + time + " Uhr!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			lblOutput.setText(e.getMessage());
		}
	}
}
