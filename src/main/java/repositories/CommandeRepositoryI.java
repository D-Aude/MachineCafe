package repositories;

import java.util.List;

import entitie.Boisson;
import entitie.TypeBoisson;

public interface CommandeRepositoryI {
	
	long nbVenteByCodeBoisson(String codeBoisson);
	
	double totalPrixVente();
	
	void ajouterBoisson(TypeBoisson boisson);

}
