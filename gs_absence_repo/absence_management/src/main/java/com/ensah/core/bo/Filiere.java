package com.ensah.core.bo;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFiliere;

	private String titreFiliere;

	private String codeFiliere;

	private int anneeaccreditation;

	private int anneeFinaccreditation;

	@OneToMany(mappedBy = "filiere" , fetch = FetchType.LAZY,cascade = CascadeType.ALL, targetEntity = Niveau.class)
	private List<Niveau> niveaux;
	
	@OneToMany(  cascade = CascadeType.ALL, targetEntity = Coordination.class)
	public List<Coordination> periodeCoordination;

	public Long getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getTitreFiliere() {
		return titreFiliere;
	}

	public void setTitreFiliere(String titreFiliere) {
		this.titreFiliere = titreFiliere;
	}

	public String getCodeFiliere() {
		return codeFiliere;
	}

	public void setCodeFiliere(String codeFiliere) {
		this.codeFiliere = codeFiliere;
	}

	public int getAnneeaccreditation() {
		return anneeaccreditation;
	}

	public void setAnneeaccreditation(int anneeaccreditation) {
		this.anneeaccreditation = anneeaccreditation;
	}

	public int getAnneeFinaccreditation() {
		return anneeFinaccreditation;
	}

	public void setAnneeFinaccreditation(int anneeFinaccreditation) {
		this.anneeFinaccreditation = anneeFinaccreditation;
	}

	public List<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(List<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public List<Coordination> getPeriodeCoordination() {
		return periodeCoordination;
	}

	public void setPeriodeCoordination(List<Coordination> periodeCoordination) {
		this.periodeCoordination = periodeCoordination;
	}

	
	
	
}