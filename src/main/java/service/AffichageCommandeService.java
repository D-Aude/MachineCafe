package service;

import java.util.stream.Stream;

import entitie.TypeBoisson;
import repositories.CommandeRepositoryI;

public class AffichageCommandeService {

	private final CommandeRepositoryI commandeRepo ;


	public AffichageCommandeService(CommandeRepositoryI commandeRepo) {
		this.commandeRepo = commandeRepo;
	}


	public void nombreVenteParCodeBoisson(TypeBoisson typeBoisson) {
		long nbVente =	commandeRepo.nbVenteByCodeBoisson(typeBoisson.getCodeBoisson());
		System.out.println(" Nombre de vente pour les " + typeBoisson.getCodeBoisson()+ " = "+ nbVente);
	}
	
	public void afficherNbCommandeParBoisson() {
		Stream.of(TypeBoisson.values())
        .forEach(this::nombreVenteParCodeBoisson);
	}
	
	public void totalPrixDesVentes() {
		double result = commandeRepo.totalPrixVente();
		System.out.println("Prix des ventes : "+result);
	}

}
