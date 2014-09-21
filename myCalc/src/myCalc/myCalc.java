package myCalc;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class myCalc {
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */

	public static int operator;
	public static float answer;
	public static String var1;
	public static String var2;
	public static String equation = "";
	private static ImageIcon numButt;
	private static ImageIcon funButt;
	private static ImageIcon numButtAlt;
	private static ImageIcon funButtAlt;
	private static Color numKeys = new Color(99, 92, 75);

	private static ImageIcon equalsImage;

	private static ImageIcon redImage;
	private static ImageIcon greenImage;

	private static JLabel displayLabel = new JLabel("Hello",
			SwingConstants.RIGHT);
	private static JLabel equalsLabel = new JLabel("", SwingConstants.LEFT);

	private static JLabel num0Label = new JLabel("0");
	private static JLabel num1Label = new JLabel("1");
	private static JLabel num2Label = new JLabel("2");
	private static JLabel num3Label = new JLabel("3");
	private static JLabel num4Label = new JLabel("4");
	private static JLabel num5Label = new JLabel("5");
	private static JLabel num6Label = new JLabel("6");
	private static JLabel num7Label = new JLabel("7");
	private static JLabel num8Label = new JLabel("8");
	private static JLabel num9Label = new JLabel("9");
	private static JLabel addLabel = new JLabel("+");
	private static JLabel subLabel = new JLabel("-");
	private static JLabel multiLabel = new JLabel("x");
	private static JLabel divideLabel = new JLabel("/");
	private static JLabel clearLabel = new JLabel("CE");
	private static JLabel deciLabel = new JLabel(".");

	private static int screenY = -50;
	private static int screenX = 0;
	
	private static JButton num1 = new JButton("");

	public static void add(float numOne, float numTwo) {
		answer = numOne + numTwo;
		System.out.println(numOne + " + " + numTwo + " = " + answer);
		String sAnswer = String.valueOf(answer);
		displayLabel.setText(sAnswer);
	}

	public static void subtract(float numOne, float numTwo) {
		answer = numOne - numTwo;
		System.out.println(numOne + " - " + numTwo + " = " + answer);
		String sAnswer = String.valueOf(answer);
		displayLabel.setText(sAnswer);
	}

	public static void multiply(float numOne, float numTwo) {
		answer = numOne * numTwo;
		System.out.println(numOne + " * " + numTwo + " = " + answer);
		String sAnswer = String.valueOf(answer);
		displayLabel.setText(sAnswer);
	}

	public static void divide(float numOne, float numTwo) {
		answer = numOne / numTwo;
		System.out.println(numOne + " / " + numTwo + " = " + answer);
		String sAnswer = String.valueOf(answer);
		displayLabel.setText(sAnswer);
	}

	private static void createAndShowCalc() throws IOException,
			FontFormatException {
		// Load Images for Buttons

		numButt = new ImageIcon(ImageIO.read(new File("source/numButt.png")));
		numButtAlt = new ImageIcon(ImageIO.read(new File("source/numButtAlt.png")));
		funButt = new ImageIcon(ImageIO.read(new File("source/funButt.png")));
		funButtAlt = new ImageIcon(ImageIO.read(new File("source/funButtAlt.png")));

		equalsImage = new ImageIcon(ImageIO.read(new File("source/equals.png")));

		redImage = new ImageIcon(ImageIO.read(new File("source/red.png")));
		greenImage = new ImageIcon(ImageIO.read(new File("source/green.png")));

		/*
		 * BufferedImage bgShineImage = ImageIO.read(new
		 * File("source/bgShine.png")); JLabel bgShine = new JLabel(new
		 * ImageIcon(bgShineImage)); bgShine.setSize(251, 400);
		 * bgShine.setLocation(0,0);
		 */

		BufferedImage screenImage = ImageIO.read(new File("source/screen.png"));
		JLabel screen = new JLabel(new ImageIcon(screenImage));
		screen.setSize(189, 58);
		screen.setLocation(31 + screenX, 100 + screenY);

		BufferedImage nameImage = ImageIO
				.read(new File("source/logo_48_15.png"));
		JLabel name = new JLabel(new ImageIcon(nameImage));
		name.setSize(48, 15);
		name.setLocation(20 + screenX, 65 + screenY);

		BufferedImage leftBarImage = ImageIO.read(new File(
				"source/leftBar_5_40.png"));
		JLabel leftBar = new JLabel(new ImageIcon(leftBarImage));
		leftBar.setSize(16, 54);
		leftBar.setLocation(-6 + screenX, 100 + screenY);

		BufferedImage glowImage = ImageIO.read(new File(
				"source/glow_171_33.png"));
		JLabel glow = new JLabel(new ImageIcon(glowImage));
		glow.setSize(180, 70);
		glow.setLocation(35 + screenX, 97 + screenY);

		BufferedImage underlayImage = ImageIO.read(new File(
				"source/underlay.png"));
		JLabel underlay = new JLabel(new ImageIcon(underlayImage));
		underlay.setSize(31, 14);
		underlay.setLocation(200 + screenX, 65 + screenY);

		// Creation of two labels

		Font customFont = Font.createFont(Font.TRUETYPE_FONT,
				new File("source/DS-DIGIT.TTF")).deriveFont(12f);

		displayLabel.setFont(customFont.deriveFont(30f));

		displayLabel.setSize(165, 20);
		displayLabel.setLocation(40 + screenX, 120 + screenY);

		Font customFont2 = Font.createFont(Font.TRUETYPE_FONT,
				new File("source/Montserrat-Bold.ttf")).deriveFont(12f);
		equalsLabel.setForeground(Color.white);
		equalsLabel.setFont(customFont2.deriveFont(15f));

		equalsLabel.setSize(150, 20);
		equalsLabel.setLocation(40 + screenX, 390 + screenY);

		Font customFont3 = Font.createFont(Font.TRUETYPE_FONT,
				new File("source/Montserrat-Bold.ttf")).deriveFont(12f);
		num0Label.setForeground(numKeys);
		num0Label.setSize(50, 50);
		num1Label.setForeground(numKeys);
		num1Label.setSize(50, 50);
		num2Label.setForeground(numKeys);
		num2Label.setSize(50, 50);
		num3Label.setForeground(numKeys);
		num3Label.setSize(50, 50);
		num4Label.setForeground(numKeys);
		num4Label.setSize(50, 50);
		num5Label.setForeground(numKeys);
		num5Label.setSize(50, 50);
		num6Label.setForeground(numKeys);
		num6Label.setSize(50, 50);
		num7Label.setForeground(numKeys);
		num7Label.setSize(50, 50);
		num8Label.setForeground(numKeys);
		num8Label.setSize(50, 50);
		num9Label.setForeground(numKeys);
		num9Label.setSize(50, 50);

		multiLabel.setForeground(Color.white);
		multiLabel.setSize(50, 50);
		divideLabel.setForeground(Color.white);
		divideLabel.setSize(50, 50);
		addLabel.setForeground(Color.white);
		addLabel.setSize(50, 50);
		subLabel.setForeground(Color.white);
		subLabel.setSize(50, 50);
		clearLabel.setForeground(Color.white);
		clearLabel.setSize(50, 50);
		deciLabel.setForeground(Color.white);
		deciLabel.setSize(50, 50);

		// Create and set up the window.
		final JFrame frame = new JFrame("Calculator");
		// frame.getContentPane().setBackground(new Color(237,237,231));
		frame.getContentPane().setBackground(new Color(236, 236, 236));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(250, 420));
		frame.setLayout(null);
		frame.setResizable(false);
		// frame.setUndecorated(true);
		// frame.add(bgShine);
		frame.add(displayLabel);
		frame.add(equalsLabel);
		frame.add(glow);
		frame.add(screen);
		frame.add(name);
		frame.add(leftBar);

		// Create and setup BG change buttons
		final JButton red = new JButton("");
		final JButton green = new JButton("");
		red.setIcon(redImage);
		red.setContentAreaFilled(false);
		red.setBorderPainted(false);
		red.setSize(21, 21);
		red.setLocation(197 + screenX, 61 + screenY);
		red.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(new Color(35, 35, 35));
				green.setVisible(true);
				red.setVisible(false);
				//num1.setIcon(numButtAlt);

			}
		});

		green.setIcon(greenImage);
		green.setContentAreaFilled(false);
		green.setBorderPainted(false);
		green.setSize(21, 21);
		green.setLocation(218 + screenX, 61 + screenY);
		green.setVisible(false);
		green.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(new Color(237, 237, 231));
				System.out.println("this happened");
				red.setVisible(true);
				green.setVisible(false);

			}
		});

		frame.add(red);
		frame.add(green);
		frame.add(underlay);
		// BG Change BUttons

		// Creation of calc Buttons

		// Num1
		
		num1Label.setFont(customFont3.deriveFont(22f));
		num1Label.setLocation(45 + screenX, 275 + screenY);
		num1.setFocusable(false);
		num1.setMnemonic(KeyEvent.VK_1);
		num1.setOpaque(false);
		num1.setContentAreaFilled(false);
		num1.setBorderPainted(false);
		num1.setIcon(numButt);
		num1.setSize(50, 50);
		num1.setLocation(25 + screenX, 275 + screenY);
		num1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 1");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "1";
					displayLabel.setText(var1);
					equation = equation + "1";
				}
				if (var1 == null && operator == 0) {
					var1 = "1";
					displayLabel.setText(var1);
					equation = equation + "1";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "1";
					displayLabel.setText(var2);
					equation = equation + "1";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "1";
					displayLabel.setText(var2);
					equation = equation + "1";
				}

				equalsLabel.setText(equation);

			}
		});
		frame.add(num1Label);
		frame.add(num1);
		// Num1

		// Num2
		JButton num2 = new JButton("");
		num2Label.setFont(customFont3.deriveFont(22f));
		num2Label.setLocation(93 + screenX, 275 + screenY);
		num2.setFocusable(false);
		num2.setOpaque(false);
		num2.setContentAreaFilled(false);
		num2.setBorderPainted(false);
		num2.setIcon(numButt);
		num2.setSize(50, 50);
		num2.setLocation(75 + screenX, 275 + screenY);
		num2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 2");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "2";
					displayLabel.setText(var1);
					equation = equation + "2";
				}
				if (var1 == null && operator == 0) {
					var1 = "2";
					displayLabel.setText(var1);
					equation = equation + "2";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "2";
					displayLabel.setText(var2);
					equation = equation + "2";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "2";
					displayLabel.setText(var2);
					equation = equation + "2";
				}
				equalsLabel.setText(equation);

			}
		});
		frame.add(num2Label);
		frame.add(num2);
		// Num2

		// Num3
		JButton num3 = new JButton("");
		num3Label.setFont(customFont3.deriveFont(22f));
		num3Label.setLocation(144 + screenX, 275 + screenY);
		num3.setFocusable(false);
		num3.setOpaque(false);
		num3.setContentAreaFilled(false);
		num3.setBorderPainted(false);
		num3.setIcon(numButt);
		num3.setSize(50, 50);
		num3.setLocation(125 + screenX, 275 + screenY);
		num3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 3");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "3";
					displayLabel.setText(var1);
					equation = equation + "3";
				}
				if (var1 == null && operator == 0) {
					var1 = "3";
					displayLabel.setText(var1);
					equation = equation + "3";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "3";
					displayLabel.setText(var2);
					equation = equation + "3";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "3";
					displayLabel.setText(var2);
					equation = equation + "3";
				}
				equalsLabel.setText(equation);

			}
		});
		frame.add(num3Label);
		frame.add(num3);
		// Num3

		// Num4
		JButton num4 = new JButton("");
		num4Label.setFont(customFont3.deriveFont(22f));
		num4Label.setLocation(42 + screenX, 225 + screenY);
		num4.setFocusable(false);
		num4.setOpaque(false);
		num4.setContentAreaFilled(false);
		num4.setBorderPainted(false);
		num4.setIcon(numButt);
		num4.setSize(50, 50);
		num4.setLocation(25 + screenX, 225 + screenY);
		num4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 4");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "4";
					displayLabel.setText(var1);
					equation = equation + "4";
				}
				if (var1 == null && operator == 0) {
					var1 = "4";
					displayLabel.setText(var1);
					equation = equation + "4";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "4";
					displayLabel.setText(var2);
					equation = equation + "4";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "4";
					displayLabel.setText(var2);
					equation = equation + "4";
				}
				equalsLabel.setText(equation);

			}
		});
		frame.add(num4Label);
		frame.add(num4);
		// Num4

		// Num5
		JButton num5 = new JButton("");
		num5Label.setFont(customFont3.deriveFont(22f));
		num5Label.setLocation(92 + screenX, 225 + screenY);
		num5.setFocusable(false);
		num5.setOpaque(false);
		num5.setContentAreaFilled(false);
		num5.setBorderPainted(false);
		num5.setIcon(numButt);
		num5.setSize(50, 50);
		num5.setLocation(75 + screenX, 225 + screenY);
		num5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 5");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "5";
					displayLabel.setText(var1);
					equation = equation + "5";
				}
				if (var1 == null && operator == 0) {
					var1 = "5";
					displayLabel.setText(var1);
					equation = equation + "5";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "5";
					displayLabel.setText(var2);
					equation = equation + "5";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "5";
					displayLabel.setText(var2);
					equation = equation + "5";
				}
				equalsLabel.setText(equation);

			}
		});
		frame.add(num5Label);
		frame.add(num5);
		// Num5

		// Num6
		JButton num6 = new JButton("");
		num6Label.setFont(customFont3.deriveFont(22f));
		num6Label.setLocation(144 + screenX, 225 + screenY);
		num6.setFocusable(false);
		num6.setOpaque(false);
		num6.setContentAreaFilled(false);
		num6.setBorderPainted(false);
		num6.setIcon(numButt);
		num6.setSize(50, 50);
		num6.setLocation(125 + screenX, 225 + screenY);
		num6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 6");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "6";
					displayLabel.setText(var1);
					equation = equation + "6";
				}
				if (var1 == null && operator == 0) {
					var1 = "6";
					displayLabel.setText(var1);
					equation = equation + "6";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "6";
					displayLabel.setText(var2);
					equation = equation + "6";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "6";
					displayLabel.setText(var2);
					equation = equation + "6";
				}

				equalsLabel.setText(equation);
			}
		});
		frame.add(num6Label);
		frame.add(num6);
		// Num6

		// Num7
		JButton num7 = new JButton("");
		num7Label.setFont(customFont3.deriveFont(22f));
		num7Label.setLocation(43 + screenX, 175 + screenY);
		num7.setFocusable(false);
		num7.setOpaque(false);
		num7.setContentAreaFilled(false);
		num7.setBorderPainted(false);
		num7.setIcon(numButt);
		num7.setSize(50, 50);
		num7.setLocation(25 + screenX, 175 + screenY);
		num7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 7");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "7";
					displayLabel.setText(var1);
					equation = equation + "7";
				}
				if (var1 == null && operator == 0) {
					var1 = "7";
					displayLabel.setText(var1);
					equation = equation + "7";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "7";
					displayLabel.setText(var2);
					equation = equation + "7";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "7";
					displayLabel.setText(var2);
					equation = equation + "7";
				}
				equalsLabel.setText(equation);

			}
		});
		frame.add(num7Label);
		frame.add(num7);
		// Num7

		// Num8
		JButton num8 = new JButton("");
		num8Label.setFont(customFont3.deriveFont(22f));
		num8Label.setLocation(92 + screenX, 175 + screenY);
		num8.setFocusable(false);
		num8.setOpaque(false);
		num8.setContentAreaFilled(false);
		num8.setBorderPainted(false);
		num8.setIcon(numButt);
		num8.setSize(50, 50);
		num8.setLocation(75 + screenX, 175 + screenY);
		num8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 8");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "8";
					displayLabel.setText(var1);
					equation = equation + "8";
				}
				if (var1 == null && operator == 0) {
					var1 = "8";
					displayLabel.setText(var1);
					equation = equation + "8";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "8";
					displayLabel.setText(var2);
					equation = equation + "8";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "8";
					displayLabel.setText(var2);
					equation = equation + "8";
				}

				equalsLabel.setText(equation);
			}
		});
		frame.add(num8Label);
		frame.add(num8);
		// Num8

		// Num9
		JButton num9 = new JButton("");
		num9Label.setFont(customFont3.deriveFont(22f));
		num9Label.setLocation(144 + screenX, 175 + screenY);
		num9.setFocusable(false);
		num9.setIcon(numButt);
		num9.setOpaque(false);
		num9.setContentAreaFilled(false);
		num9.setBorderPainted(false);
		num9.setSize(50, 50);
		num9.setLocation(125 + screenX, 175 + screenY);
		num9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 9");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "9";
					displayLabel.setText(var1);
					equation = equation + "9";
				}
				if (var1 == null && operator == 0) {
					var1 = "9";
					displayLabel.setText(var1);
					equation = equation + "9";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "9";
					displayLabel.setText(var2);
					equation = equation + "9";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "9";
					displayLabel.setText(var2);
					equation = equation + "9";
				}
				equalsLabel.setText(equation);

			}
		});
		frame.add(num9Label);
		frame.add(num9);
		// Num9

		// Num0
		JButton num0 = new JButton("");
		num0Label.setFont(customFont3.deriveFont(22f));
		num0Label.setLocation(42 + screenX, 325 + screenY);
		num0.setFocusable(false);
		num0.setIcon(numButt);
		num0.setOpaque(false);
		num0.setContentAreaFilled(false);
		num0.setBorderPainted(false);
		num0.setSize(50, 50);
		num0.setLocation(25 + screenX, 325 + screenY);
		num0.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button 0");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "0";
					displayLabel.setText(var1);
					equation = equation + "0";
				}
				if (var1 == null && operator == 0) {
					var1 = "0";
					displayLabel.setText(var1);
					equation = equation + "0";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "0";
					equation = equation + "0";
					displayLabel.setText(var2);
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "0";
					displayLabel.setText(var2);
					equation = equation + "0";
				}
				equalsLabel.setText(equation);

			}
		});
		frame.add(num0Label);
		frame.add(num0);
		// Num0

		// Decimal
		JButton decimal = new JButton("");
		deciLabel.setFont(customFont3.deriveFont(22f));
		deciLabel.setLocation(97 + screenX, 320 + screenY);
		decimal.setFocusable(false);
		decimal.setOpaque(false);
		decimal.setContentAreaFilled(false);
		decimal.setBorderPainted(false);
		decimal.setIcon(funButt);
		decimal.setSize(50, 50);
		decimal.setLocation(75 + screenX, 325 + screenY);
		decimal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button .");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + ".";
					equation = equation + ".";
					displayLabel.setText(var1);
				}
				if (var1 == null && operator == 0) {
					var1 = "0.";
					equation = "0.";
					displayLabel.setText(var1);
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + ".";
					equation = equation + ".";
					displayLabel.setText(var2);
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "0.";
					equation = equation + "0.";
					displayLabel.setText(var2);
				}
				equalsLabel.setText(equation);
			}
		});
		frame.add(deciLabel);
		frame.add(decimal);
		// Decimal

		// Clear
		JButton clear = new JButton("");
		clearLabel.setFont(customFont3.deriveFont(18f));
		clearLabel.setLocation(138 + screenX, 324 + screenY);
		clear.setFocusable(false);
		clear.setOpaque(false);
		clear.setContentAreaFilled(false);
		clear.setBorderPainted(false);
		clear.setIcon(funButt);
		clear.setSize(50, 50);
		clear.setLocation(125 + screenX, 325 + screenY);
		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button CLEAR");
				var1 = null;
				var2 = null;
				operator = 0;
				displayLabel.setText("");
				equation = "";
				equalsLabel.setText(equation);

			}
		});
		frame.add(clearLabel);
		frame.add(clear);
		// Clear

		// Add
		JButton add = new JButton("");
		addLabel.setFont(customFont3.deriveFont(22f));
		addLabel.setLocation(193 + screenX, 325 + screenY);
		add.setFocusable(false);
		add.setOpaque(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		add.setIcon(funButt);
		add.setSize(50, 50);
		add.setLocation(175 + screenX, 325 + screenY);
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button ADD");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 1;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " + ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " + ";
					equalsLabel.setText(equation);
					operator = 1;
				}

			}
		});
		frame.add(addLabel);
		frame.add(add);
		// Add

		// Subtract
		JButton subtract = new JButton("");
		subLabel.setFont(customFont3.deriveFont(22f));
		subLabel.setLocation(194 + screenX, 275 + screenY);
		subtract.setFocusable(false);
		subtract.setOpaque(false);
		subtract.setContentAreaFilled(false);
		subtract.setBorderPainted(false);
		subtract.setIcon(funButt);
		subtract.setSize(50, 50);
		subtract.setLocation(175 + screenX, 275 + screenY);
		subtract.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button SUBTRACT");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 2;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " - ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " - ";
					equalsLabel.setText(equation);
					operator = 2;
				}
			}
		});
		frame.add(subLabel);
		frame.add(subtract);
		// Subtract

		// Multi
		JButton multi = new JButton("");
		multiLabel.setFont(customFont3.deriveFont(22f));
		multiLabel.setLocation(194 + screenX, 223 + screenY);
		multi.setFocusable(false);
		multi.setOpaque(false);
		multi.setContentAreaFilled(false);
		multi.setBorderPainted(false);
		multi.setIcon(funButt);
		multi.setSize(50, 50);
		multi.setLocation(175 + screenX, 225 + screenY);
		multi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { // Execute when button
															// is pressed
				System.out.println("You clicked the button MULTI");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 3;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " x ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " x ";
					equalsLabel.setText(equation);
					operator = 3;
				}

			}
		});
		frame.add(multiLabel);
		frame.add(multi);
		// Multi

		// Divide
		JButton divide = new JButton("");
		divideLabel.setFont(customFont3.deriveFont(15f));
		divideLabel.setLocation(195 + screenX, 175 + screenY);
		divide.setFocusable(false);
		divide.setOpaque(false);
		divide.setContentAreaFilled(false);
		divide.setBorderPainted(false);
		divide.setIcon(funButt);
		divide.setSize(50, 50);
		divide.setLocation(175 + screenX, 175 + screenY);
		divide.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button DIVIDE");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 4;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " / ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " / ";
					equalsLabel.setText(equation);
					operator = 4;
				}

			}
		});
		frame.add(divideLabel);
		frame.add(divide);
		// Divide

		// Equals
		JButton equals = new JButton("");
		equals.setFocusable(false);
		equals.setOpaque(false);
		equals.setContentAreaFilled(false);
		equals.setBorderPainted(false);
		equals.setIcon(equalsImage);
		equals.setSize(200, 50);
		equals.setLocation(25 + screenX, 375 + screenY);
		equals.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button EQUALS");
				System.out.println(var1 + " " + operator + " " + var2);
				if (var1 != null & var2 != null & operator != 0) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);

					switch (operator) {
					case 1:
						add(num1, num2);
						break;
					case 2:
						subtract(num1, num2);
						break;
					case 3:
						multiply(num1, num2);
						break;
					case 4:
						divide(num1, num2);
						break;
					default:
						break;
					}

					/*
					 * //Eggs
					 * 
					 * if(answer == 1337){ displayLabel.setText("ELITE");
					 * 
					 * } if(answer == 17111991){ displayLabel.setText("Rohan");
					 * 
					 * } if(answer == 8008){ displayLabel.setText("Boobies");
					 * 
					 * }
					 */

				}
				var1 = null;
				var2 = null;
				operator = 0;
				equation = "";
				equalsLabel.setText(equation);
				// displayLabel.setText("");

			}
		});

		frame.add(equals);
		// equals

		// Keyboard
		frame.addKeyListener(new CustomKeyListener());
		// Keyboard

		// Display the window.
		frame.setFocusable(true);
		frame.pack();
		frame.setVisible(true);
	}

	public static class CustomKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_1) {
				System.out.println("YOU PRESSED 1");
				// Execute when button is pressed
				System.out.println("You clicked the button 1");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "1";
					displayLabel.setText(var1);
					equation = equation + "1";
				}
				if (var1 == null && operator == 0) {
					var1 = "1";
					displayLabel.setText(var1);
					equation = equation + "1";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "1";
					displayLabel.setText(var2);
					equation = equation + "1";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "1";
					displayLabel.setText(var2);
					equation = equation + "1";
				}

				equalsLabel.setText(equation);
			}

			if (key == KeyEvent.VK_2) {
				System.out.println("YOU PRESSED 2");
				// Execute when button is pressed
				System.out.println("You clicked the button 2");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "2";
					displayLabel.setText(var1);
					equation = equation + "2";
				}
				if (var1 == null && operator == 0) {
					var1 = "2";
					displayLabel.setText(var1);
					equation = equation + "2";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "2";
					displayLabel.setText(var2);
					equation = equation + "2";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "2";
					displayLabel.setText(var2);
					equation = equation + "2";
				}
				equalsLabel.setText(equation);
			}

			if (key == KeyEvent.VK_3) {
				System.out.println("YOU PRESSED 3");
				// Execute when button is pressed
				System.out.println("You clicked the button 3");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "3";
					displayLabel.setText(var1);
					equation = equation + "3";
				}
				if (var1 == null && operator == 0) {
					var1 = "3";
					displayLabel.setText(var1);
					equation = equation + "3";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "3";
					displayLabel.setText(var2);
					equation = equation + "3";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "3";
					displayLabel.setText(var2);
					equation = equation + "3";
				}
				equalsLabel.setText(equation);
			}

			if (key == KeyEvent.VK_4) {
				System.out.println("YOU PRESSED 4");
				// Execute when button is pressed
				System.out.println("You clicked the button 4");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "4";
					displayLabel.setText(var1);
					equation = equation + "4";
				}
				if (var1 == null && operator == 0) {
					var1 = "4";
					displayLabel.setText(var1);
					equation = equation + "4";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "4";
					displayLabel.setText(var2);
					equation = equation + "4";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "4";
					displayLabel.setText(var2);
					equation = equation + "4";
				}
				equalsLabel.setText(equation);
			}
			if (key == KeyEvent.VK_5) {
				System.out.println("YOU PRESSED 5");
				// Execute when button is pressed
				System.out.println("You clicked the button 5");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "5";
					displayLabel.setText(var1);
					equation = equation + "5";
				}
				if (var1 == null && operator == 0) {
					var1 = "5";
					displayLabel.setText(var1);
					equation = equation + "5";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "5";
					displayLabel.setText(var2);
					equation = equation + "5";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "5";
					displayLabel.setText(var2);
					equation = equation + "5";
				}
				equalsLabel.setText(equation);
			}
			if (key == KeyEvent.VK_6) {
				System.out.println("YOU PRESSED 6");
				// Execute when button is pressed
				System.out.println("You clicked the button 6");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "6";
					displayLabel.setText(var1);
					equation = equation + "6";
				}
				if (var1 == null && operator == 0) {
					var1 = "6";
					displayLabel.setText(var1);
					equation = equation + "6";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "6";
					displayLabel.setText(var2);
					equation = equation + "6";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "6";
					displayLabel.setText(var2);
					equation = equation + "6";
				}

				equalsLabel.setText(equation);
			}
			if (key == KeyEvent.VK_7) {
				System.out.println("YOU PRESSED 7");
				// Execute when button is pressed
				System.out.println("You clicked the button 7");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "7";
					displayLabel.setText(var1);
					equation = equation + "7";
				}
				if (var1 == null && operator == 0) {
					var1 = "7";
					displayLabel.setText(var1);
					equation = equation + "7";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "7";
					displayLabel.setText(var2);
					equation = equation + "7";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "7";
					displayLabel.setText(var2);
					equation = equation + "7";
				}
				equalsLabel.setText(equation);
			}
			if (key == KeyEvent.VK_8 && !e.isShiftDown()) {
				System.out.println("YOU PRESSED 8");
				// Execute when button is pressed
				System.out.println("You clicked the button 8");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "8";
					displayLabel.setText(var1);
					equation = equation + "8";
				}
				if (var1 == null && operator == 0) {
					var1 = "8";
					displayLabel.setText(var1);
					equation = equation + "8";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "8";
					displayLabel.setText(var2);
					equation = equation + "8";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "8";
					displayLabel.setText(var2);
					equation = equation + "8";
				}

				equalsLabel.setText(equation);
			}
			if (key == KeyEvent.VK_9) {
				System.out.println("YOU PRESSED 9");
				// Execute when button is pressed
				System.out.println("You clicked the button 9");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "9";
					displayLabel.setText(var1);
					equation = equation + "9";
				}
				if (var1 == null && operator == 0) {
					var1 = "9";
					displayLabel.setText(var1);
					equation = equation + "9";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "9";
					displayLabel.setText(var2);
					equation = equation + "9";
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "9";
					displayLabel.setText(var2);
					equation = equation + "9";
				}
				equalsLabel.setText(equation);

			}
			if (key == KeyEvent.VK_0) {
				System.out.println("YOU PRESSED 0");
				// Execute when button is pressed
				System.out.println("You clicked the button 0");
				displayLabel.setText("");

				if (var1 != null && operator == 0) {
					var1 = var1 + "0";
					displayLabel.setText(var1);
					equation = equation + "0";
				}
				if (var1 == null && operator == 0) {
					var1 = "0";
					displayLabel.setText(var1);
					equation = equation + "0";
				}
				if (var1 != null && operator != 0 && var2 != null) {
					var2 = var2 + "0";
					equation = equation + "0";
					displayLabel.setText(var2);
				}
				if (var1 != null && operator != 0 && var2 == null) {
					var2 = "0";
					displayLabel.setText(var2);
					equation = equation + "0";
				}
				equalsLabel.setText(equation);

			}

			if (e.isShiftDown() && (key == KeyEvent.VK_EQUALS)) {
				System.out.println("YOU PRESSED +");
				// Execute when button is pressed
				System.out.println("You clicked the button ADD");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 1;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " + ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " + ";
					equalsLabel.setText(equation);
					operator = 1;
				}
			}
			if (key == KeyEvent.VK_MINUS) {
				System.out.println("YOU PRESSED -");
				System.out.println("You clicked the button SUBTRACT");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 2;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " - ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " - ";
					equalsLabel.setText(equation);
					operator = 2;
				}
			}
			if (e.isShiftDown() && (key == KeyEvent.VK_8)) {
				System.out.println("YOU PRESSED *");
				System.out.println("You clicked the button MULTI");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 3;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " x ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " x ";
					equalsLabel.setText(equation);
					operator = 3;
				}

			}
			if (key == KeyEvent.VK_SLASH) {
				System.out.println("YOU PRESSED /");
				System.out.println("You clicked the button DIVIDE");
				float tempAnswer = 0.0f;
				if (var1 != null && operator != 0 && var2 != null) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);
					if (var1 != null & var2 != null & operator != 0) {

						switch (operator) {
						case 1:
							tempAnswer = num1 + num2;
							break;
						case 2:
							tempAnswer = num1 - num2;
							break;
						case 3:
							tempAnswer = num1 * num2;
							break;
						case 4:
							tempAnswer = num1 / num2;
							break;
						default:
							break;
						}
					}
					operator = 4;
					var1 = String.valueOf(tempAnswer);
					var2 = "";
					equation = equation + " / ";
					equalsLabel.setText(equation);
					System.out.println(var1);

				}
				if (var1 != null && operator == 0) {
					equation = equation + " / ";
					equalsLabel.setText(equation);
					operator = 4;
				}

			}
			if (key == KeyEvent.VK_ENTER) {
				System.out.println("YOU PRESSED ENTER");

				// Execute when button is pressed
				System.out.println("You clicked the button EQUALS");
				System.out.println(var1 + " " + operator + " " + var2);
				if (var1 != null & var2 != null & operator != 0) {
					float num1 = Float.parseFloat(var1);
					float num2 = Float.parseFloat(var2);

					switch (operator) {
					case 1:
						add(num1, num2);
						break;
					case 2:
						subtract(num1, num2);
						break;
					case 3:
						multiply(num1, num2);
						break;
					case 4:
						divide(num1, num2);
						break;
					default:
						break;
					}

					/*
					 * //Eggs
					 * 
					 * if(answer == 1337){ displayLabel.setText("ELITE");
					 * 
					 * } if(answer == 17111991){ displayLabel.setText("Rohan");
					 * 
					 * } if(answer == 8008){ displayLabel.setText("Boobies");
					 * 
					 * }
					 */

				}
				var1 = null;
				var2 = null;
				operator = 0;
				equation = "";
				equalsLabel.setText(equation);
				// displayLabel.setText("");

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowCalc();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FontFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
