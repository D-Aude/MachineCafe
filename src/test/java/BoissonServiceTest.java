import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import entitie.Boisson;
import entitie.TypeBoisson;
import repositories.CommandeRepositoryI;
import repositories.ReportCommandeRepository;
import service.BoissonService;

@ExtendWith(MockitoExtension.class)

public class BoissonServiceTest {

	@Mock
	private BoissonService boissonService;
	
	@Mock
	private CommandeRepositoryI commandeRepo;

	  @Before
	  public void init() {
		  commandeRepo = new ReportCommandeRepository();
		  boissonService = new BoissonService(this.commandeRepo);
	  }
	
	
	//Boisson
	@Test
	public  void argentSuffisantPourUnChocolat() {
		Boisson boisson = new Boisson (TypeBoisson.CHOCOLATE,"","", false);
		assertEquals("H::", boissonService.getBoisson(boisson, 4.00));
	}
	
	@Test
	public  void argentSuffisantPourUnThe() {
		Boisson boisson = new Boisson (TypeBoisson.TEA,"2","0", false);
		assertEquals("T:2:0", boissonService.getBoisson(boisson, 4.00));
	}
	
	@Test
	public  void argentSuffisantPourUnCafe() {
		Boisson boisson = new Boisson (TypeBoisson.COFFEE,"1","0", false);
		assertEquals("C:1:0", boissonService.getBoisson(boisson, 4.00));
	}
	@Test
	public  void argentSuffisantPourUnJusOrange() {
		Boisson boisson = new Boisson (TypeBoisson.ORANGE,"","", false);
		assertEquals("O::", boissonService.getBoisson(boisson, 4.00));
	}
	//Boisson Extra Chaude
	@Test
	public  void argentSuffisantPourUnChocolatExtraChaud() {
		Boisson boisson = new Boisson (TypeBoisson.CHOCOLATE,"1","0", true);
		assertEquals("Hh:1:0", boissonService.getBoisson(boisson, 4.00));
	}
	
	@Test
	public  void argentSuffisantPourUnTheExtraChaud() {
		Boisson boisson = new Boisson (TypeBoisson.TEA,"2","0", true);
		assertEquals("Th:2:0", boissonService.getBoisson(boisson, 4.00));
	}
	
	@Test
	public  void argentSuffisantPourUnCafeExtraChaud() {
		Boisson boisson = new Boisson (TypeBoisson.COFFEE,"0","0", true);
		assertEquals("Ch:0:0", boissonService.getBoisson(boisson, 4.00));
	}
	
	// Argent insuffisant
	@Test
	public  void argentInsuffisantCafe() {
		Boisson boisson = new Boisson (TypeBoisson.COFFEE,"2","1", false);
		assertEquals("M: prix manquant 0,1", boissonService.getBoisson(boisson,0.50 ));
	}
	@Test
	public  void argentInsuffisantThe() {
		Boisson boisson = new Boisson (TypeBoisson.TEA,"2","1",false);
		assertEquals("M: prix manquant 0,1", boissonService.getBoisson(boisson,0.30 ));
	}
	@Test
	public  void argentInsuffisantChocolat() {
		Boisson boisson = new Boisson (TypeBoisson.CHOCOLATE,"2","1", false);
		assertEquals("M: prix manquant 0,1", boissonService.getBoisson(boisson,0.40 ));
	}
	
	@Test
	public  void argentInsuffisantOrange() {
		Boisson boisson = new Boisson (TypeBoisson.ORANGE,"","", false);
		assertEquals("M: prix manquant 0,1", boissonService.getBoisson(boisson,0.50 ));
	}
	
}
