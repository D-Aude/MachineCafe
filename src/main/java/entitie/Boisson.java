package entitie;

import java.util.Objects;

public class Boisson {


	private TypeBoisson typeBoisson;
	private String nbSucre;
	private String touillete;
	private boolean estUneBoissonChaude;


	public TypeBoisson getTypeBoisson() {
		return typeBoisson;
	}



	public String getNbSucre() {
		return nbSucre;
	}


	public String getTouillete() {
		return touillete;
	}



	public Boisson(TypeBoisson typeBoisson, String nbSucre, String touillete, boolean estUneBoissonChaude) {
		super();
		this.typeBoisson = typeBoisson;
		this.nbSucre = nbSucre;
		this.touillete = touillete;
		this.estUneBoissonChaude = estUneBoissonChaude;
	}



	public boolean estUneBoissonChaude() {
		return estUneBoissonChaude;
	}



	@Override
	public int hashCode() {
		return Objects.hash(estUneBoissonChaude, nbSucre, touillete, typeBoisson);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boisson other = (Boisson) obj;
		return estUneBoissonChaude == other.estUneBoissonChaude && Objects.equals(nbSucre, other.nbSucre)
				&& Objects.equals(touillete, other.touillete) && typeBoisson == other.typeBoisson;
	}



	


}
