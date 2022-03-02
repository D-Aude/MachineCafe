package entitie;

public enum TypeBoisson {

	COFFEE("C", 0.6),
	CHOCOLATE("H", 0.5),
	TEA("T", 0.4),
	ORANGE("O",0.6);

	private final double prix;
	private final String codeBoisson;

	public double getPrix() {
		return prix;
	}

	private TypeBoisson(String codeBoisson, double prix) {
		this.prix = prix;
		this.codeBoisson = codeBoisson;
	}

	public String getCodeBoisson() {
		return codeBoisson;
	}

}
