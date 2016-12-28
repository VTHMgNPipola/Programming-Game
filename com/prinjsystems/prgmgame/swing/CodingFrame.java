package com.prinjsystems.prgmgame.swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.prinjsystems.prgmgame.MainLoop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CodingFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public JTextArea codingPane = new JTextArea();
	public JTextArea textArea = new JTextArea();
	
	public CodingFrame() {
		setTitle("Programming Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProject = new JMenu("Project");
		menuBar.add(mnProject);
		
		JMenuItem mntmCompile = new JMenuItem("Compile");
		mnProject.add(mntmCompile);
		
		JMenuItem mntmRun = new JMenuItem("Run");
		mnProject.add(mntmRun);
		
		JMenuItem mntmCompileRun = new JMenuItem("Compile & Run");
		mnProject.add(mntmCompileRun);
		
		JSeparator separator = new JSeparator();
		mnProject.add(separator);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnProject.add(mntmSave);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Button button = new Button("Compile");
		button.setBounds(0, 0, 70, 22);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = codingPane.getText();
				Scanner scn = new Scanner(text);
				
				List<String> code = new ArrayList<>();
				
				while(scn.hasNextLine()) {
					String s = scn.nextLine();
					
					String[] str = s.split("//");
					
					if(str.length > 1) {
						code.add(str[0]);
					} else {
						code.add(s);
					}
				}
				
				MainLoop.setCode(code);
				
				scn.close();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);
		
		Button button_1 = new Button("Run");
		button_1.setBounds(70, 0, 70, 22);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainLoop.runCode();
			}
		});
		contentPane.add(button_1);
		
		Button button_2 = new Button("Compile & Run");
		button_2.setBounds(0, 25, 140, 22);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = codingPane.getText();
				Scanner scn = new Scanner(text);
				
				List<String> code = new ArrayList<>();
				
				while(scn.hasNextLine()) {
					String s = scn.nextLine();
					
					String[] str = s.split("//");
					
					if(str.length > 1) {
						code.add(str[0]);
					} else {
						code.add(s);
					}
				}
				
				MainLoop.setCode(code);
				MainLoop.runCode();
				
				scn.close();
			}
		});
		contentPane.add(button_2);
		codingPane.setBounds(1, 1, 783, 391);
		codingPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
		codingPane.setText("print Hello World!");
		
		codingPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		codingPane.setLineWrap(true);
		codingPane.setWrapStyleWord(true);
		contentPane.add(codingPane);
		
		JScrollPane scroll = new JScrollPane(codingPane);
		scroll.setBounds(0, 48, 783, 391);
		contentPane.add(scroll);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(MainLoop.isReading == true) {
					textArea.setEditable(true);
				} else {
					textArea.setEditable(false);
				}
			}
		});
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(MainLoop.isReading == true) {
					textArea.setEditable(true);
				} else {
					textArea.setEditable(false);
				}
			}
		});
		
		textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 441, 783, 100);
		contentPane.add(scrollPane);
	}
	
	public void setRead(boolean b) {
		textArea.setEditable(b);
	}
}
