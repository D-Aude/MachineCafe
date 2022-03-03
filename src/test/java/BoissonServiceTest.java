import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import entitie.Boisson;
import entitie.TypeBoisson;
import repositories.BeverageQuantityChecker;
import repositories.BeverageQuantityCheckerRepository;
import repositories.CommandeRepositoryI;
import repositories.EmailNotifier;
import repositories.EmailNotifierRepository;
import repositories.ReportCommandeRepository;
import service.BoissonService;

@ExtendWith(MockitoExtension.class)
public class BoissonServiceTest {

	@Mock
	private BoissonService boissonService;
	
	@Mock
	private CommandeRepositoryI commandeRepo;
	
	@Mock
	private BeverageQuantityChecker bevCheck;

	@Mock
	private EmailNotifier notif;
	@Mock
	private EmailNotifier notifvv;


	  @Before
	  public void init() {
		  commandeRepo = new ReportCommandeRepository();
		  notif = new EmailNotifierRepository();
		  bevCheck = new BeverageQuantityCheckerRepository();
		  boissonService = new BoissonService(this.commandeRepo, this.notif, this.bevCheck);
	
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
	
	//Quantite suffisante
	@Test
	public void quantiteSuffisante() {
		
		
		assertFalse(bevCheck.isEmpty(TypeBoisson.ORANGE.getCodeBoisson()));
		assertFalse(bevCheck.isEmpty(TypeBoisson.COFFEE.getCodeBoisson()));
		assertFalse(bevCheck.isEmpty(TypeBoisson.CHOCOLATE.getCodeBoisson()));
		assertFalse(bevCheck.isEmpty(TypeBoisson.TEA.getCodeBoisson()));
		
	}


	
}
