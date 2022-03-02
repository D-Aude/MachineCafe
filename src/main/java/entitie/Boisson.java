package entitie;

import java.util.Objects;

public class Boisson {

	
	private TypeBoisson typeBoisson;
	private String nbSucre;
	private String touillete;
	
	
	
	public TypeBoisson getTypeBoisson() {
		return typeBoisson;
	}



	public String getNbSucre() {
		return nbSucre;
	}


	public String getTouillete() {
		return touillete;
	}

	

	public Boisson(TypeBoisson typeBoisson, String nbSucre, String touillete) {
		this.typeBoisson = typeBoisson;
		this.nbSucre = nbSucre;
		this.touillete = touillete;
	}



	@Override
	public int hashCode() {
		return Objects.hash(nbSucre, touillete, typeBoisson);
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
		return nbSucre == other.nbSucre && touillete == other.touillete
				&& Objects.equals(typeBoisson, other.typeBoisson);
	}
	
	
}
