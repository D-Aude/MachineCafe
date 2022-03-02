package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import entitie.Boisson;
import entitie.TypeBoisson;

public class ReportCommandeRepository implements CommandeRepositoryI {
	List<TypeBoisson> listBoisson = new ArrayList<>();
	
	@Override
	public long nbVenteByCodeBoisson(String codeBoisson) {
		long nbVente = this.listBoisson.stream()
				.filter(line ->line.getCodeBoisson().equals(codeBoisson))
				.count();
		return nbVente;
	}

	@Override
	public double totalPrixVente() {
		return this.listBoisson.stream().mapToDouble(TypeBoisson::getPrix).sum();
		
	}

	@Override
	public void ajouterBoisson(TypeBoisson boisson) {
		listBoisson.add(boisson);
	}

}
