import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Utility
{
	
	public Vector<String> extremSearch(String nume)
	{
		Handle_XMLSX xlsx = new Handle_XMLSX();
		Vector<String> info = xlsx.checkStatusFromName(nume, true);
	
		return info;
	}
	
	public void saveFile(Vector<String> toateNumeleRelevante)
	{

		FileOutputStream outputStream;
		for(String s : toateNumeleRelevante)
		{
			 
		    try
			{
				outputStream = new FileOutputStream("temp.txt", true);
				 byte[] strToBytes = s.getBytes();
				    outputStream.write(strToBytes);
				  
				    outputStream.close();
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public Vector<String> readFile()
	{
		Vector<String> result = new Vector<String>();
		File file = new File("temp.txt"); 
	    Scanner sc;
		try
		{
			sc = new Scanner(file);
			while (sc.hasNextLine()) 
			      result.add(sc.nextLine()); 
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			  
			    
		return result;
	}
	
}

/*
 * Handle_XMLSX xlsx = new Handle_XMLSX();
				String numeleComplet = txtNumeelev.getText() + " " + txtinitialaTatalui.getText() + " " + txtPrenume.getText();
				numeleComplet = numeleComplet.toUpperCase();
				
				Vector<String> info = xlsx.checkStatusFromName(numeleComplet, false);
				for(String s : info)
				{
					System.out.println(s);
				}
				if (info.size() < 1)
				{
					JOptionPane.showMessageDialog(null, "Acest elev nu are informatiile trecute sau nu exista in baza de date.");
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Doriti sa cautati nume asemanatoare?", "Cautare extrema", dialogButton);
					if(dialogResult == 0) 
					{
						
						String numeExtreme = JOptionPane.showInputDialog(null, "Nume: ");
						numeExtreme = numeExtreme.toUpperCase();
						Vector<String> toateNumeleRelevante = new Utility().extremSearch(numeExtreme);
						new Utility().saveFile(toateNumeleRelevante);
						
						for(String s : new Utility().readFile())
						{
							System.out.println(s);
						}
						
						
					} 
					else 
					{
					
					} 				
				}
				else
				{
					lblNumeComplet.setText("Nume: " +info.get(0));
					lblAnulabsolvirii.setText("Anul absolvirii: " + info.get(1).substring(0, info.get(1).indexOf('.')));
					lblFormaabsolvirii.setText("Forma absolvirii: " + info.get(2));
					lblCalificareaprofesionala.setText("Calificare: " + info.get(3));
					
					String diplomaAnswer = info.get(4).toUpperCase();
					
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
 */
