import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import entitie.Boisson;
import entitie.TypeBoisson;
import repositories.CommandeRepositoryI;
import repositories.ReportCommandeRepository;
import service.AffichageCommandeService;


@ExtendWith(MockitoExtension.class)
public class AffichageCommandeServiceTest {

	
	@Mock
	private AffichageCommandeService affichageCommandeService;

	@Mock
	private CommandeRepositoryI commandeRepo;
	
	

	  @Before
	  public void init() {
		  commandeRepo = new ReportCommandeRepository();
		  affichageCommandeService = new AffichageCommandeService(commandeRepo);
		 // boissonService = new BoissonService(this.commandeRepo);
	  }

	  
	
	@Test
	public void nombreVenduParBoisson() {
		
		 Boisson boisson1 = new Boisson(TypeBoisson.TEA, "0", "2",true);
	     Boisson boisson2 = new Boisson(TypeBoisson.COFFEE, "", "",true);
	     Boisson boisson3 = new Boisson(TypeBoisson.TEA, "1", "0",true);
	     Boisson boisson4 = new Boisson(TypeBoisson.ORANGE, "", "",false);
	     Boisson boisson5 = new Boisson(TypeBoisson.COFFEE, "", "",true);
	     Boisson boisson6 = new Boisson(TypeBoisson.COFFEE, "", "",true);
		
	    
		commandeRepo.ajouterBoisson(boisson1.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson2.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson3.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson4.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson5.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson6.getTypeBoisson());
		
		long nbThe =commandeRepo.nbVenteByCodeBoisson(TypeBoisson.TEA.getCodeBoisson());
		assertEquals(2, nbThe);
		long nbOrange =commandeRepo.nbVenteByCodeBoisson(TypeBoisson.ORANGE.getCodeBoisson());
		assertEquals(1, nbOrange);
		long nbChocolate =commandeRepo.nbVenteByCodeBoisson(TypeBoisson.CHOCOLATE.getCodeBoisson());
		assertEquals(0, nbChocolate);
		long nbCafe =commandeRepo.nbVenteByCodeBoisson(TypeBoisson.COFFEE.getCodeBoisson());
		assertEquals(3, nbCafe);
	
	}
	
	@Test
	public void totalVente(){
		 Boisson boisson1 = new Boisson(TypeBoisson.TEA, "0", "2",true);
	     Boisson boisson2 = new Boisson(TypeBoisson.COFFEE, "", "",true);
	     Boisson boisson3 = new Boisson(TypeBoisson.TEA, "1", "0",true);
	     Boisson boisson4 = new Boisson(TypeBoisson.ORANGE, "", "",false);
	     Boisson boisson5 = new Boisson(TypeBoisson.COFFEE, "", "",true);
	     Boisson boisson6 = new Boisson(TypeBoisson.COFFEE, "", "",true);
		
	    
		commandeRepo.ajouterBoisson(boisson1.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson2.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson3.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson4.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson5.getTypeBoisson());
		commandeRepo.ajouterBoisson(boisson6.getTypeBoisson());
		
		assertEquals(3.2, commandeRepo.totalPrixVente());
	}
	

	
}
