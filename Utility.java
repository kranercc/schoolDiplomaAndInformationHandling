import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utility
{
	
	public Vector<String> extremSearch(String nume)
	{
		Handle_XMLSX xlsx = new Handle_XMLSX();
		Vector<String> info = xlsx.checkStatusFromName(nume, true);
	
		return info;
	}

	
	public String calcululButonuluiDeShuffle(Vector<String> totiEleviiDupaNume)
	{
		int int_calcululPentruCazuri = (totiEleviiDupaNume.size() - 5);
		String calcululPentruCazuri = new String().valueOf(int_calcululPentruCazuri);
		
		boolean result = int_calcululPentruCazuri > 5 ? true : false;
		
		if (result) { return "Au mai ramas: " + calcululPentruCazuri; } 
		else { return "Acestia sunt toti elevii"; }
		
		
	}
	
	public void DisplayInfo(JTextField txtNume, JLabel numeleElev, JTextField txtInitTata, JTextField txtPrenume, Vector<String> INFORMATII_DESPRE_ELEV_DIN_DB, JLabel lblNumeComplet,
							JLabel lblAnulabsolvirii, JLabel lblFormaabsolvirii, JLabel lblCalificarea, JLabel lblDiploma, JPanel ExtremeSearch, JPanel InformatiiElev)
	{
		Handle_XMLSX xlsx = new Handle_XMLSX();
		String numeleComplet = numeleElev.getText();
		System.out.println(numeleComplet);
		numeleComplet = numeleComplet.toUpperCase();
		
		INFORMATII_DESPRE_ELEV_DIN_DB = xlsx.checkStatusFromName(numeleComplet, false);
		
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
		
		ExtremeSearch.setVisible(false);
		InformatiiElev.setVisible(true);
	}
}

