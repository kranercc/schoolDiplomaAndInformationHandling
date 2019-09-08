import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
		
		JTextArea textArea = new JTextArea(17, 45);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setLocation(10, 10);
		scroll.setSize(523, 216);
		//this.add(textArea); // get rid of this
		ExtremeSearch.add(scroll);
		
		JButton btnInapoi_1 = new JButton("Inapoi");
		btnInapoi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExtremeSearch.setVisible(false);
				HomePanel.setVisible(true);
			}
		});
		btnInapoi_1.setBounds(433, 240, 114, 20);
		ExtremeSearch.add(btnInapoi_1);
		
		
		
		
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
		
		btnInapoi.setBounds(433, 240, 114, 25);
		InformatiiElev.add(btnInapoi);
		
		
		
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
	}
}
