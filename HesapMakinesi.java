package odevJavacamp;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class HesapMakinesi {
	
	private JFrame frame;
	private JTextField value1;
	private JTextField value2;
	private JTextField result;
	private final String EN_LANG = "ENG";
	private final String TR_LANG = "TR";
	
	ResourceBundle bundle = null;
	
	private String currentFlag;
	private String currentLang;

	// define buttons
	JLabel first_number = new JLabel();
	JLabel second_number = new JLabel();
	JLabel hearder_text = new JLabel();
	JLabel result_text = new JLabel();
	JButton lang_button = new JButton();
	JButton btnToplama = new JButton();
	JButton btnCikarma = new JButton();
	JButton btnCarpma = new JButton();
	JButton btnBolme = new JButton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HesapMakinesi window = new HesapMakinesi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HesapMakinesi() {
		setLanguage(EN_LANG);
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void setLanguage(String language) {

		if (language.equals(EN_LANG)) {
			bundle = ResourceBundle.getBundle("resources/turkish");
			currentFlag = EN_LANG;
			currentLang = TR_LANG;
		} else {
			bundle = ResourceBundle.getBundle("resources/english");
			currentFlag = TR_LANG;
			currentLang = EN_LANG;
		}

	}

	public void updateLanguage() {
		lang_button.setText(bundle.getString("language"));
		first_number.setText(bundle.getString("birinci_sayi"));
		second_number.setText(bundle.getString("ikinci_sayi"));
		result_text.setText(bundle.getString("sonuc"));
		hearder_text.setText(bundle.getString("hesapmakinesi"));
		btnToplama.setText(bundle.getString("toplama"));
		btnCikarma.setText(bundle.getString("cikarma"));
		btnCarpma.setText(bundle.getString("carpma"));
		btnBolme.setText(bundle.getString("bölme"));

	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 554, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		OSGIservice service = new OSGIservice();
		OSGIservice2 service2 = new OSGIservice2();

		first_number.setText(bundle.getString("birinci_sayi"));
		first_number.setFont(new Font("Arial", Font.BOLD, 12));
		first_number.setBounds(58, 51, 109, 29);
		frame.getContentPane().add(first_number);

		second_number.setText(bundle.getString("ikinci_sayi"));
		second_number.setFont(new Font("Arial", Font.BOLD, 12));
		second_number.setBounds(58, 98, 109, 29);
		frame.getContentPane().add(second_number);

		result_text.setText(bundle.getString("sonuc"));
		result_text.setFont(new Font("Arial", Font.BOLD, 12));
		result_text.setBounds(100, 229, 85, 29);
		frame.getContentPane().add(result_text);

		value1 = new JTextField();
		value1.setBounds(184, 56, 96, 19);
		frame.getContentPane().add(value1);
		value1.setColumns(10);

		value2 = new JTextField();
		value2.setBounds(184, 103, 96, 19);
		frame.getContentPane().add(value2);
		value2.setColumns(10);

		result = new JTextField();
		result.setBounds(184, 234, 270, 19);
		frame.getContentPane().add(result);
		result.setColumns(10);

		btnToplama.setText(bundle.getString("toplama"));
		btnToplama.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnToplama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long v1 = service2.wordToNumber(value1.getText(), currentLang);
				long v2 = service2.wordToNumber(value2.getText(), currentLang);
				long sum = v1 + v2;
				result.setText(service.NumberToWords((int) sum, currentLang));
			}
			
		});
		btnToplama.setBounds(10, 174, 109, 21);
		frame.getContentPane().add(btnToplama);

		btnCikarma.setText(bundle.getString("cikarma"));
		btnCikarma.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnCikarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long v1 = service2.wordToNumber(value1.getText(), currentLang);
				long v2 = service2.wordToNumber(value2.getText(), currentLang);
				long extraction = v1 - v2;
				result.setText(service.NumberToWords((int) extraction, currentLang));
			}
			
		});
		btnCikarma.setBounds(144, 174, 114, 21);
		frame.getContentPane().add(btnCikarma);

		btnCarpma.setText(bundle.getString("carpma"));
		btnCarpma.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnCarpma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long v1 = service2.wordToNumber(value1.getText(), currentLang);
				long v2 = service2.wordToNumber(value2.getText(), currentLang);
				long multiplication = v1 * v2;
				result.setText(service.NumberToWords((int) multiplication, currentLang));
			}
			
		});
		btnCarpma.setBounds(279, 174, 137, 21);
		frame.getContentPane().add(btnCarpma);

		btnBolme.setText(bundle.getString("bölme"));
		btnBolme.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnBolme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long v1 = service2.wordToNumber(value1.getText(), currentLang);
				long v2 = service2.wordToNumber(value2.getText(), currentLang);
				long division = v1 / v2;
				result.setText(service.NumberToWords((int) division, currentLang));
			}
		});
		btnBolme.setBounds(426, 174, 109, 21);
		frame.getContentPane().add(btnBolme);

		hearder_text.setText(bundle.getString("hesapmakinesi"));
		hearder_text.setFont(new Font("Arial", Font.BOLD, 12));
		hearder_text.setBounds(226, 16, 160, 30);
		frame.getContentPane().add(hearder_text);

		lang_button.setText(bundle.getString("language"));
		lang_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentFlag.equals(EN_LANG)) {
					setLanguage(TR_LANG);
				} else {
					setLanguage(EN_LANG);
				}
				updateLanguage();
			}
		});
		lang_button.setBounds(403, 55, 85, 21);
		frame.getContentPane().add(lang_button);
	}

}
