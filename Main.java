import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Label;
import java.awt.event.MouseAdapter;

public class Main
{

	private JFrame frame;
	private JTextField txtNume;
	private JTextField txtInitTata;
	private JTextField txtPrenume;
	private JPanel HomePanel;
	private JPanel ExtremeSearch;
	private JPanel InformatiiElev;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Vector<String> INFORMATII_DESPRE_ELEV_DIN_DB = new Vector<String>();
	private void initialize()
	{
		
	
		
	

		frame = new JFrame();
		frame.setBounds(100, 100, 559, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		HomePanel = new JPanel();
		frame.getContentPane().add(HomePanel, "name_6743978421760");
		HomePanel.setLayout(null);
		HomePanel.setVisible(true);
		
		JLabel lblNume = new JLabel("Nume:");
		lblNume.setBounds(55, 76, 66, 15);
		HomePanel.add(lblNume);
		
		JLabel lblInitialaTatalui = new JLabel("Initiala Tatalui");
		lblInitialaTatalui.setBounds(227, 76, 110, 15);
		HomePanel.add(lblInitialaTatalui);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setBounds(397, 76, 70, 15);
		HomePanel.add(lblPrenume);
		
		txtNume = new JTextField();
		txtNume.setBounds(52, 105, 124, 19);
		HomePanel.add(txtNume);
		txtNume.setColumns(10);
		
		txtInitTata = new JTextField();
		txtInitTata.setBounds(227, 105, 124, 19);
		HomePanel.add(txtInitTata);
		txtInitTata.setColumns(10);
		
		txtPrenume = new JTextField();
		txtPrenume.setBounds(397, 105, 124, 19);
		HomePanel.add(txtPrenume);
		txtPrenume.setColumns(10);
		
		
		ExtremeSearch = new JPanel();
		frame.getContentPane().add(ExtremeSearch, "name_6766352778614");
		ExtremeSearch.setLayout(null);
		
		JButton btnInapoi_1 = new JButton("Inapoi");
		btnInapoi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExtremeSearch.setVisible(false);
				HomePanel.setVisible(true);
			}
		});
		btnInapoi_1.setBounds(407, 235, 114, 20);
		ExtremeSearch.add(btnInapoi_1);
		
		JLabel labelelev1 = new JLabel("elev1");
		
		
		labelelev1.setBounds(38, 23, 467, 30);
		ExtremeSearch.add(labelelev1);
		
		JLabel labelElev2 = new JLabel("elev1");
		
		labelElev2.setBounds(38, 52, 467, 30);
		ExtremeSearch.add(labelElev2);
		
		JLabel labelelev3 = new JLabel("elev1");
	
		labelelev3.setBounds(38, 78, 467, 30);
		ExtremeSearch.add(labelelev3);
		
		JLabel labelelev4 = new JLabel("elev1");
		
		labelelev4.setBounds(38, 107, 467, 30);
		ExtremeSearch.add(labelelev4);
		
		JLabel labelelev5 = new JLabel("elev1");
		
		labelelev5.setBounds(38, 133, 467, 30);
		ExtremeSearch.add(labelelev5);
		
		JButton btnCautaDinNou = new JButton("Cauta din nou");
		
		
		btnCautaDinNou.setBounds(38, 234, 155, 20);
		ExtremeSearch.add(btnCautaDinNou);
		
		JLabel lblCazuriposibile = new JLabel("cazuriPosibile");
		lblCazuriposibile.setBounds(38, 209, 166, 14);
		ExtremeSearch.add(lblCazuriposibile);
		
		
		
		
		InformatiiElev = new JPanel();
		frame.getContentPane().add(InformatiiElev, "name_7186483454449");
		InformatiiElev.setLayout(null);
		InformatiiElev.setVisible(false);
		
		
		JLabel lblNumeComplet = new JLabel("Nume complet");
		lblNumeComplet.setBounds(55, 41, 413, 15);
		InformatiiElev.add(lblNumeComplet);
		
		JLabel lblAnulabsolvirii = new JLabel("AnulAbsolvirii");
		lblAnulabsolvirii.setBounds(55, 81, 165, 15);
		InformatiiElev.add(lblAnulabsolvirii);
		
		JLabel lblFormaabsolvirii = new JLabel("FormaAbsolvirii");
		lblFormaabsolvirii.setBounds(55, 108, 345, 15);
		InformatiiElev.add(lblFormaabsolvirii);
		
		JLabel lblCalificarea = new JLabel("Calificarea");
		lblCalificarea.setBounds(55, 143, 359, 15);
		InformatiiElev.add(lblCalificarea);
		
		JLabel lblDiploma = new JLabel("Diploma");
		lblDiploma.setBounds(55, 194, 386, 15);
		InformatiiElev.add(lblDiploma);
		
		JButton btnInapoi = new JButton("Inapoi");
		
		btnInapoi.setBounds(419, 230, 114, 20);
		InformatiiElev.add(btnInapoi);
		
		labelelev1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//ia informatiile despre el
				new Utility().DisplayInfo(txtNume, labelelev1, txtInitTata, txtPrenume, INFORMATII_DESPRE_ELEV_DIN_DB, lblNumeComplet, lblAnulabsolvirii, lblFormaabsolvirii, lblCalificarea, lblDiploma, ExtremeSearch, InformatiiElev);
				
			}
		});
		labelElev2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//ia informatiile despre el
				new Utility().DisplayInfo(txtNume, labelElev2, txtInitTata, txtPrenume, INFORMATII_DESPRE_ELEV_DIN_DB, lblNumeComplet, lblAnulabsolvirii, lblFormaabsolvirii, lblCalificarea, lblDiploma, ExtremeSearch, InformatiiElev);
				
			}
		});labelelev3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//ia informatiile despre el
				new Utility().DisplayInfo(txtNume, labelelev3, txtInitTata, txtPrenume, INFORMATII_DESPRE_ELEV_DIN_DB, lblNumeComplet, lblAnulabsolvirii, lblFormaabsolvirii, lblCalificarea, lblDiploma, ExtremeSearch, InformatiiElev);
				
			}
		});labelelev4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//ia informatiile despre el
				new Utility().DisplayInfo(txtNume, labelelev4, txtInitTata, txtPrenume, INFORMATII_DESPRE_ELEV_DIN_DB, lblNumeComplet, lblAnulabsolvirii, lblFormaabsolvirii, lblCalificarea, lblDiploma, ExtremeSearch, InformatiiElev);
				
			}
		});labelelev5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//ia informatiile despre el
				new Utility().DisplayInfo(txtNume, labelelev5, txtInitTata, txtPrenume, INFORMATII_DESPRE_ELEV_DIN_DB, lblNumeComplet, lblAnulabsolvirii, lblFormaabsolvirii, lblCalificarea, lblDiploma, ExtremeSearch, InformatiiElev);
				
			}
		});
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Handle_XMLSX xlsx = new Handle_XMLSX();
				String numeleComplet = txtNume.getText() + " " + txtInitTata.getText() + " " + txtPrenume.getText();
				numeleComplet = numeleComplet.toUpperCase();
				
				INFORMATII_DESPRE_ELEV_DIN_DB = xlsx.checkStatusFromName(numeleComplet, false);
				
				if (INFORMATII_DESPRE_ELEV_DIN_DB.size() < 1)
				{
					JOptionPane.showMessageDialog(null, "Acest elev nu are informatiile trecute sau nu exista in baza de date.");
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Doriti sa cautati nume asemanatoare?", "Cautare extrema", dialogButton);
					
					if(dialogResult == 0) 
					{
						String numeExtreme = JOptionPane.showInputDialog(null, "Nume: ");
						numeExtreme = numeExtreme.toUpperCase();
						HomePanel.setVisible(false);
						ExtremeSearch.setVisible(true);
						
						//
						//	HANDLE PARTEA DE EXTREM
						//
						Vector<String> totiEleviiDupaNume = new Vector<String>();
						totiEleviiDupaNume = new Utility().extremSearch(numeExtreme);
						
						JLabel[] labeleElevi = { labelelev1, labelElev2, labelelev3, labelelev4, labelelev5 };
						
						for (int i = 0; i < 5; i ++)
						{
							labeleElevi[i].setText(totiEleviiDupaNume.get(i));
							
						}
						
						
						for(int i2 = 0; i2 < 5; i2++)
						{
							try 
							{
								totiEleviiDupaNume.remove(i2);			
							}
							catch(Exception e3) 
							{
								// TODO: handle exception
							}
						}
						
						lblCazuriposibile.setText(new Utility().calcululButonuluiDeShuffle(totiEleviiDupaNume));
					
					}
					
					else 
					{
					
						
						
					} 				
				}
				else
				{
					lblNumeComplet.setText("Nume: " + INFORMATII_DESPRE_ELEV_DIN_DB.get(0));
					lblAnulabsolvirii.setText("Anul absolvirii: " + INFORMATII_DESPRE_ELEV_DIN_DB.get(1).substring(0, INFORMATII_DESPRE_ELEV_DIN_DB.get(1).indexOf('.')));
					lblFormaabsolvirii.setText("Forma absolvirii: " + INFORMATII_DESPRE_ELEV_DIN_DB.get(2));
					lblCalificarea.setText("Calificare: " + INFORMATII_DESPRE_ELEV_DIN_DB.get(3));
					
					String diplomaAnswer = INFORMATII_DESPRE_ELEV_DIN_DB.get(4).toUpperCase();
					
					if ( diplomaAnswer.equals("DA") )
					{
						lblDiploma.setText("Elevul a ridicat diploma.");
					}
					else if ( diplomaAnswer.equals("NU") )
					{
						lblDiploma.setText("Elevul nu a ridicat diploma.");
						
					}
					else
					{
						lblDiploma.setText("Nu se stie daca are sau nu diploma.");
					}
					
					HomePanel.setVisible(false);
					InformatiiElev.setVisible(true);
					
				}
			}
		
			
			
		});
		btnCauta.setBounds(220, 172, 114, 20);
		HomePanel.add(btnCauta);
		
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InformatiiElev.setVisible(false);
				HomePanel.setVisible(true);
				
			}
		});
		
		btnCautaDinNou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			
			{
			}
		});
	}
}
