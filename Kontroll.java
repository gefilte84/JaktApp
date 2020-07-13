import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Double.*;
import java.io.*;

import javax.swing.JOptionPane;

public class Kontroll {

		private final String[] ALTERNATIVER = {"Hare fangst","Gaupe fangst", "Gjenfanget dyr","Søk på dyr","Rapport","Avslutt"};
		private final int regNyHare = 0;
		private final int regNyGaupe = 1;
		private final int gjenfangetDyr = 2;
		private final int sokDyr = 3;
		private final int rapportDyr = 4;
		
		private ArrayList<Hare> fangedeHarer = new ArrayList<>();
		private final String FILNAVNh = "fangedeHarer.txt";
		private ArrayList<Gaupe> fangedeGauper = new ArrayList<>();
		private final String FILNAVNg = "fangedeGauper.txt";

		private ArrayList<GjenfangetDyr> gjenfangedeDyr = new ArrayList<GjenfangetDyr>();
	
	public void meny() {
		boolean fortsett = true;
		while(fortsett) {
			int valg = JOptionPane.showOptionDialog(
					null,
					"Tast ønsket operasjon",
					"Registrering av dyr",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					ALTERNATIVER,
					ALTERNATIVER[0]);
			switch(valg) {
			case regNyHare: NyHare();
				break;
			case regNyGaupe: nyGaupe();
				break;
			case gjenfangetDyr: regGjenfangetDyr();
				break;
			case sokDyr: SokeDyr();
				break;
			case rapportDyr: visRapDyr();
				break;
			default: fortsett = false;
			}
		}
	}

	private void SokeDyr() {
		String id = JOptionPane.showInputDialog("Dyrets ID:");
		boolean finnesID = false;
		
		//Lage en for løkke for Harer for å hente input knyttet til den. 
		for(Hare hare:fangedeHarer) {
			if(hare.getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "Dyrets opplysninger: " + hare.toString());
				
				for(GjenfangetDyr gjenfangetDyr:gjenfangedeDyr) {
					if (gjenfangetDyr.getId().equals(id)) {
						JOptionPane.showMessageDialog(null, "Gjenfangst opplysninger: " + gjenfangetDyr.toString());
					}
				}
				
				finnesID = true;
			}
		}
		
		//Lage en for løkke for Gauper for å hente input knyttet til den. 
		for(Gaupe gaupe:fangedeGauper) {
			if(gaupe.getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "Dyrets opplysninger: " + gaupe.toString());
				
				for(GjenfangetDyr gjenfangetDyr:gjenfangedeDyr) {
					if (gjenfangetDyr.getId().equals(id)) {
						JOptionPane.showMessageDialog(null, "Gjenfangst opplysninger: " + gjenfangetDyr.toString());
				
					}
				}
				finnesID = true;
			}
		}
		if (finnesID == false) {
			JOptionPane.showMessageDialog(null, "ID ikke registrert");
		}
		
	}

	private void visRapDyr() {
			//Skriv ut innhold i filen
			JOptionPane.showMessageDialog(null, "Alle dyr: " + fangedeHarer.toString());
	}

	public void NyHare() {
		
		//Denne metoden skal ta i mot input fra brukeren
		String kjonnH = JOptionPane.showInputDialog("Kjønn: ");
		String lengdeH = JOptionPane.showInputDialog("Lengde: ");
		double lengdenH = parseDouble(lengdeH);
		String vektH = JOptionPane.showInputDialog("Vekt: ");
		double vektenH = parseDouble(vektH);
		String typeH = JOptionPane.showInputDialog("Type hare (V = vanlig, S = Sørhare:) ");
		String pelsH = JOptionPane.showInputDialog("Pels farge: ");
		String dato = JOptionPane.showInputDialog("Dato: ");
		String sted = JOptionPane.showInputDialog("Sted: ");
		
		
		//Øker H + 1
		String id = "H" + (fangedeHarer.size() + 1);
		
		//Opprette hareobjekt basert på input
		Hare h1 = new Hare(id, kjonnH, lengdenH, vektenH, typeH, pelsH, dato, sted);
		
		//Hareobjektet skal registreres inn i listen
		fangedeHarer.add(h1);
		//Skrive innhold i h1 til fil
		
	}	
	
	public void nyGaupe() {
		
		//Denne metoden skal ta i mot input fra brukeren
		//String id = JOptionPane.showInputDialog("Dyrets ID: " );
		String kjonnG = JOptionPane.showInputDialog("Kjønn: ");
		String lengdeG = JOptionPane.showInputDialog("Lengde: ");
		double lengdenG = parseDouble(lengdeG);
		String vektG = JOptionPane.showInputDialog("Vekt: ");
		double vektenG = parseDouble(vektG);
		String orer = JOptionPane.showInputDialog("Lengde ører: ");
		double orerG = parseDouble(orer);
		String dato = JOptionPane.showInputDialog("Dato: ");
		String sted = JOptionPane.showInputDialog("Sted: ");
		
		
		
		//Øker G + 1
		String id = "G" + (fangedeGauper.size() + 1);
		
		//Opprette Gaupeobjekt basert på input
		Gaupe g1 = new Gaupe(id, kjonnG, lengdenG, vektenG, orerG, dato, sted);
		
		//Gaupeobjektet skal registeres inn i listen
		fangedeGauper.add(g1);
		
	}
	public void regGjenfangetDyr() {
		
		//Denne metoden skal ta i mot gjenfangetdyr opplysninger
		String id = JOptionPane.showInputDialog("Dyrets ID: " );
		String pels = "";
		String orer = "";
		boolean erGjenfangetDyr = false;
		
		//Lage en for løkke for Harer for å hente input knyttet til den. 
		for(Hare hare:fangedeHarer) {
			if(hare.getId().equals(id)) {
				pels =  JOptionPane.showInputDialog("Pels: ");
				erGjenfangetDyr = true;
			}
		}
		
		//Lage en for løkke for Gauper for å hente input knyttet til den. 
		for(Gaupe gaupe:fangedeGauper) {
			if(gaupe.getId().equals(id)) {
				orer =  JOptionPane.showInputDialog("Ører: ");
				erGjenfangetDyr = true;
			}
		}
		
		if(erGjenfangetDyr) {
			String date = JOptionPane.showInputDialog("Dato: ");
			String sted = JOptionPane.showInputDialog("Sted: ");
			double lengde = parseDouble(JOptionPane.showInputDialog("Lengde: "));
			double vekt = parseDouble(JOptionPane.showInputDialog("Vekt: "));
			
			GjenfangetDyr gjenfangetDyr = new GjenfangetDyr(id, date, sted, lengde, vekt, pels, orer);
			
			gjenfangedeDyr.add(gjenfangetDyr);
		}else {
			JOptionPane.showMessageDialog(null, "Dyrets ID finnes ikke i registeret");
		}

		}
	public ArrayList<Hare> getHare() {
		return fangedeHarer;
	}
	
	
		//Lage en metode for å skrive harer til fil	
	public PrintWriter lagSkrivefilH (String FILNAVNh) {
		PrintWriter skriver = null;
		try {
			FileWriter forbindelse = new FileWriter(FILNAVNh);
			BufferedWriter skriverBuffer = new BufferedWriter(forbindelse);
			skriver = new PrintWriter(skriverBuffer);
			
		}catch(Exception e) {}
		return skriver;
		}
		//Lage en metode for å skrive gauper til fil	
	public PrintWriter lagSkrivefilG (String FILNAVNg) {
		PrintWriter skriver = null;
		try {
			FileWriter forbindelse = new FileWriter(FILNAVNg);
			BufferedWriter skriverBuffer = new BufferedWriter(forbindelse);
			skriver = new PrintWriter(skriverBuffer);
			
		}catch(Exception e) {}
		return skriver;

	}
		//Lage en metode for å lesefil harer
	public BufferedReader lagLesefilharer(String FILNAVNh) {
		BufferedReader innfil = null;
		try {
			FileReader forbindelse = new FileReader(FILNAVNh);
			innfil = new BufferedReader(forbindelse);
		}catch(Exception e) {}
		return innfil;
	}
		//lage en metode for å lesefil gaupe
	public BufferedReader lagLesefilgauper(String FILNAVNg) {
		BufferedReader innfil = null;
		try {
			FileReader forbindelse = new FileReader(FILNAVNg);
			innfil = new BufferedReader(forbindelse);
		}catch(Exception e) {}
		return innfil;
	}
	//Lage metode for å skrive data til harer fil
	public void skrivDataH() {
		try{
			PrintWriter utfil = lagSkrivefilH(FILNAVNh);
			for(Hare h : fangedeHarer) {
				utfil.println(h.toFile());
			}	
			utfil.close();
		}catch(Exception e) {}
	}
	
	//Lage metode for å skrive data til gauper fil
	public void skrivDataG() {
		try{
			PrintWriter utfil = lagSkrivefilH(FILNAVNg);
			for(Gaupe g : fangedeGauper) {
				utfil.println(g.toFile());
			}	
			utfil.close();
		}catch(Exception e) {}
	}
	//Metode for å lese harer fil
	public void lesDataH() {
		try {
			BufferedReader innfil = lagLesefilharer(FILNAVNh);
			String linje = innfil.readLine();
			while(linje !=null) {
				StringTokenizer innhold = new StringTokenizer(linje,",");
				String id = innhold.nextToken();
				String kjonnH = innhold.nextToken();
				double lengdeH = parseDouble(innhold.nextToken());
				double vektH = parseDouble(innhold.nextToken());
				String typeH = innhold.nextToken();
				String pelsH = innhold.nextToken();
				String dato = innhold.nextToken();
				String sted = innhold.nextToken();
				fangedeHarer.add(new Hare(id,kjonnH,lengdeH,vektH,typeH,pelsH,dato,sted ));
				linje = innfil.readLine();				
			} //løkke
			innfil.close();
		}catch(Exception e) {}
	}
	//Metode for å lese gaupe fil
	public void lesDataG() {
		try {
			BufferedReader innfil = lagLesefilharer(FILNAVNh);
			String linje = innfil.readLine();
			while(linje !=null) {
				StringTokenizer innhold = new StringTokenizer(linje,",");
				String id = innhold.nextToken();
				String kjonnG = innhold.nextToken();
				double lengdeG = parseDouble(innhold.nextToken());
				double vektG = parseDouble(innhold.nextToken());
				double orer = parseDouble(innhold.nextToken());
				String dato = innhold.nextToken();
				String sted = innhold.nextToken();
				fangedeGauper.add(new Gaupe(id,kjonnG,lengdeG,vektG,orer,dato,sted ));
				linje = innfil.readLine();				
			} //løkke
			innfil.close();
		}catch(Exception e) {}
	}
}
	


