package service;

import java.text.DecimalFormat;

import entitie.Boisson;
import entitie.TypeBoisson;
import repositories.CommandeRepositoryI;
import repositories.ReportCommandeRepository;


public class BoissonService {
	
	private final static String MESSAGE_PRIX_MANQUANT = "M: prix manquant ";

	public  String getBoisson(Boisson commandeBoissonMachine, double prix) {
		if (commandeBoissonMachine.getTypeBoisson().getPrix() > prix) {
			
				return argentInsuffisantMessage(commandeBoissonMachine.getTypeBoisson(), prix);
		}else {
			return protocoleCommandeEnvoye(commandeBoissonMachine);
		}

	}


	private static String argentInsuffisantMessage(TypeBoisson typeBoisson, double prix) {
			DecimalFormat df = new DecimalFormat("#.##");
			double prixManquant =  typeBoisson.getPrix() -prix ;
			String plop = df.format(prixManquant);
			StringBuilder sb = new StringBuilder();
			sb.append(MESSAGE_PRIX_MANQUANT);
			sb.append(plop);
			return sb.toString();
	}


	private static String protocoleCommandeEnvoye(Boisson boissonCompleteDemande) {
		
		String typeBoisson = boissonCompleteDemande.getTypeBoisson().getCodeBoisson();
		
		String nbSucre = boissonCompleteDemande.getNbSucre();

		String touillette = boissonCompleteDemande.getTouillete();

		if(boissonCompleteDemande.estUneBoissonChaude()) {
			typeBoisson = String.join("",typeBoisson, "h");
		}
		String boissonProtocole = String.join(":", typeBoisson,nbSucre,touillette);
		return boissonProtocole;
	}


}
