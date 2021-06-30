package com.ensah.core.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensah.core.bo.Coordination;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Niveau;
import com.ensah.core.services.ICoordinationServices;
import com.ensah.core.services.IEnseignantServices;
import com.ensah.core.services.IFiliereServices;
import com.ensah.core.services.INiveauServices;
import com.ensah.core.web.models.CoordinationModel;
import com.ensah.core.web.models.EnseignantModel;
import com.ensah.core.web.models.FiliereModel;
import com.ensah.core.web.models.NiveauModel;



@Controller
@RequestMapping("/cadreadmin")
public class CoordinationController {
	
	@Autowired
	private ICoordinationServices coordinationservice;
	@Autowired
	 private IEnseignantServices enseignantservice;
	
	@Autowired
	 private INiveauServices niveauServices;
	
	
	@Autowired
	private IFiliereServices filiereservices;
	public CoordinationController(){}

	
	
	@RequestMapping(value = "addCoordonateur/{idFiliere}/{idUtilisateur}",method=RequestMethod.POST)
	public String addCoordonateur(@Valid @ModelAttribute("CoordinationModel") CoordinationModel coordinationModel,@PathVariable int idFiliere,@PathVariable int idUtilisateur,BindingResult bindingResult,
			Model model) {

		
		  
		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			
			return "cadreadmin/CaForm"; 
		}

		// Copier les données de l'objet CoordinationModel vers l'objet Coordination 
			Coordination coordination = new Coordination();
			

			
						
			BeanUtils.copyProperties(coordinationModel, coordination);
			System.out.println(idFiliere);
			
			
			coordinationservice.affecterCoordonateur(coordination,Long.valueOf(idUtilisateur),Long.valueOf(idFiliere));
			
			//model.addAttribute("CoordinationModel",coordinationModel);
            
		// rediriger vers l'action showForm avec l'objet Filiere
		return "redirect:cadreadmin/showAllCoordinateur";
		//+filiere.getIdFiliere(); 
	}
	
	
	 
	@RequestMapping(value = "showAllCoordinateur",method=RequestMethod.GET)
	public String showAllFilieres(Model model) {

		
		  CoordinationModel coordinateurModel = new CoordinationModel();
		  model.addAttribute("CoordinationModel",coordinateurModel );
		 

		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par CoordinationModel pour une meilleur flexibilité

		List<Enseignant> enseignants = enseignantservice.getAll();
		List<EnseignantModel> EnseignantModels = new ArrayList<EnseignantModel>();
		// On copie les données des personnes vers le modèle
		for (int i = 0; i < enseignants.size(); i++) {
			EnseignantModel em = new EnseignantModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
				BeanUtils.copyProperties(enseignants.get(i), em);
				EnseignantModels.add(em);
				
			}
		    
		List<Filiere> filiere=filiereservices.getAllFiliere();
		//System.out.println("Filiere" + filiere.get(0).getTitreFiliere());
		List<FiliereModel> filieremodels=new ArrayList<FiliereModel>();
		
		for (int i = 0; i < filiere.size(); i++) {
			FiliereModel em = new FiliereModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
			
				BeanUtils.copyProperties(filiere.get(i), em);
				filieremodels.add(em);
				
			}
		
		model.addAttribute("FiliereList", filieremodels);
		
		
		model.addAttribute("EnseignantList", EnseignantModels);

		/* model.addAttribute("CoordinationModel",coordinateurModel); */
		
		return "cadreadmin/EnseignantList";
		}
	
	@RequestMapping(value = "showAll",method=RequestMethod.GET)
	public String showAll(Model model) {

		
		/*
		 * CoordinationModel coordinateurModel = new CoordinationModel();
		 * model.addAttribute("CoordinationModel",coordinateurModel );
		 */
		 

		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par CoordinationModel pour une meilleur flexibilité

		List<Niveau> niveaux = niveauServices.getAllNiveaux();
		List<NiveauModel> niveauModels = new ArrayList<NiveauModel>();
		// On copie les données des personnes vers le modèle
		for (int i = 0; i < niveaux.size(); i++) {
			NiveauModel em = new NiveauModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
				BeanUtils.copyProperties(niveaux.get(i), em);
				niveauModels.add(em);
				
			}
		    
		List<Filiere> filiere=filiereservices.getAllFiliere();
		//System.out.println("Filiere" + filiere.get(0).getTitreFiliere());
		List<FiliereModel> filieremodels=new ArrayList<FiliereModel>();
		
		for (int i = 0; i < filiere.size(); i++) {
			FiliereModel em = new FiliereModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
			
				BeanUtils.copyProperties(filiere.get(i), em);
				filieremodels.add(em);
				
			}
		
		model.addAttribute("FiliereList", filieremodels);
		
		
		model.addAttribute("NiveauList", niveauModels);

		/* model.addAttribute("CoordinationModel",coordinateurModel); */
		
		return "cadreadmin/showAll";
		}
	
	
	
	
}
