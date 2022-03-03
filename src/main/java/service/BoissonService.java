package service;

import java.text.DecimalFormat;

import entitie.Boisson;
import entitie.TypeBoisson;
import repositories.BeverageQuantityChecker;
import repositories.CommandeRepositoryI;
import repositories.EmailNotifier;
import repositories.ReportCommandeRepository;


public class BoissonService {
	
	private final static String MESSAGE_PRIX_MANQUANT = "M: prix manquant ";
	private final static String MESSAGE_PRODUIT_MANQUANT = "P: produit manquant ";
	private final  CommandeRepositoryI commandeRepo ;
	private final  EmailNotifier notifier;
	private final BeverageQuantityChecker beverageCheck;
	
	public BoissonService(CommandeRepositoryI commandeRepo, EmailNotifier notif, BeverageQuantityChecker beverageCheck) {
		this.commandeRepo = commandeRepo;
		this.notifier =notif;
		this.beverageCheck = beverageCheck;
	}


	public  String getBoisson(Boisson commandeBoissonMachine, double prix) {
		if (commandeBoissonMachine.getTypeBoisson().getPrix() > prix) {
			
				return argentInsuffisantMessage(commandeBoissonMachine.getTypeBoisson(), prix);
		
		}else {
			if (beverageCheck.isEmpty(commandeBoissonMachine.getTypeBoisson().getCodeBoisson())) {
				notifier.notifyMissingDrink(commandeBoissonMachine.getTypeBoisson().getCodeBoisson());
				return quantiteInsuffisante(commandeBoissonMachine.getTypeBoisson());
			}
			commandeRepo.ajouterBoisson(commandeBoissonMachine.getTypeBoisson());
			return protocoleCommandeEnvoye(commandeBoissonMachine);
		}

	}


	private String quantiteInsuffisante(TypeBoisson typeBoisson) {
		StringBuilder sb = new StringBuilder();
	
			sb.append(MESSAGE_PRODUIT_MANQUANT);
			sb.append(typeBoisson.getCodeBoisson());

		return sb.toString();
		
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

	public static void main(String[] args) {

//		Boisson boisson = new Boisson (TypeBoisson.CHOCOLATE,"","", true);
//		Boisson boisso2n = new Boisson (TypeBoisson.CHOCOLATE,"","", true);
//		CommandeRepositoryI plop= new ReportCommandeRepository();
//		AffichageCommandeService d = new AffichageCommandeService(plop);
//		BoissonService servicer = new BoissonService(plop);
//		plop.nbVenteByCodeBoisson(MESSAGE_PRIX_MANQUANT);
//		servicer.getBoisson(boisson,0.5);
//		servicer.getBoisson(boisso2n,0.5);
//		long ici = plop.nbVenteByCodeBoisson(TypeBoisson.CHOCOLATE.getCodeBoisson());
//		System.out.println(" combien chocolat " + ici);
	}

}
