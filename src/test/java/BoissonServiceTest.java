import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;

import entitie.Boisson;
import entitie.TypeBoisson;
import service.BoissonService;

public class BoissonServiceTest {

	@Mock
	private BoissonService boissonService;



	@Test
	public  void argentSuffisantChocolat() {
		Boisson boisson = new Boisson (TypeBoisson.CHOCOLATE,"1","1");
		assertEquals("H:1:1", BoissonService.getBoisson(boisson, 4.00));
	}
	@Test
	public  void argentSuffisantThe() {
		Boisson boisson = new Boisson (TypeBoisson.TEA,"2","1");
		assertEquals("T:2:1", BoissonService.getBoisson(boisson, 4.00));
	}
	@Test
	public  void argentSuffisantCafe() {
		Boisson boisson = new Boisson (TypeBoisson.COFFEE,"0","0");
		assertEquals("C:0:0", BoissonService.getBoisson(boisson, 4.00));
	}
	
	@Test
	public  void argentInsuffisantCafe() {
		Boisson boisson = new Boisson (TypeBoisson.COFFEE,"2","1");
		assertEquals("M: prix manquant 0,1", BoissonService.getBoisson(boisson,0.50 ));
	}
	@Test
	public  void argentInsuffisantThe() {
		Boisson boisson = new Boisson (TypeBoisson.TEA,"2","1");
		assertEquals("M: prix manquant 0,1", BoissonService.getBoisson(boisson,0.30 ));
	}
	@Test
	public  void argentInsuffisantChocolat() {
		Boisson boisson = new Boisson (TypeBoisson.CHOCOLATE,"2","1");
		assertEquals("M: prix manquant 0,1", BoissonService.getBoisson(boisson,0.40 ));
	}
	
	
}
