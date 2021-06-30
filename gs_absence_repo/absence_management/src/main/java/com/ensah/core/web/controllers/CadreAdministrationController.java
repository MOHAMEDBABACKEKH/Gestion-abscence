package com.ensah.core.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Matiere;
import com.ensah.core.bo.Module;
import com.ensah.core.bo.Niveau;
import com.ensah.core.services.IFiliereServices;
import com.ensah.core.services.IMatiereServices;
import com.ensah.core.services.IModuleServices;
import com.ensah.core.services.INiveauServices;
import com.ensah.core.web.models.FiliereModel;
import com.ensah.core.web.models.MatiereModel;
import com.ensah.core.web.models.ModuleModel;
import com.ensah.core.web.models.NiveauModel;

@Controller
@RequestMapping("/cadreadmin")
public class CadreAdministrationController {
	
	
	@Autowired
	private INiveauServices niveauservice;
		
	@Autowired
	private IFiliereServices filiereservices;
	
	@Autowired
	private IMatiereServices matiereservice;
	
	
	
	@Autowired
	private IModuleServices moduleservice;
	
	
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	  public CadreAdministrationController() {	  	
	}

	 
	@RequestMapping(value = "showAllFilieres",method=RequestMethod.GET)
	public String showAllFilieres(Model model) {

		FiliereModel filieremodel = new FiliereModel();
		model.addAttribute("FiliereModel",filieremodel );

		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par PersonModel pour une meilleur flexibilité

		List<Filiere> filieres = filiereservices.getAllFiliere();
		List<FiliereModel> filieremodels = new ArrayList<FiliereModel>();
		// On copie les données des personnes vers le modèle
		for (int i = 0; i < filieres.size(); i++) {
			FiliereModel fm = new FiliereModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
				BeanUtils.copyProperties(filieres.get(i), fm);
				filieremodels.add(fm);
			}
		
		
		model.addAttribute("FiliereList", filieremodels);

		return "cadreadmin/CaForm";
		}
	
	@RequestMapping(value = "showFilieresNiveau/{idFiliere}",method=RequestMethod.GET)
	public String showFilieresNiveau(@PathVariable int idFiliere,Model model) {

		
		  NiveauModel niveaumodel = new NiveauModel();
		  model.addAttribute("NiveauModel",niveaumodel );
		 
         
		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par PersonModel pour une meilleur flexibilité
		
		//Filiere filiere=filiereservices.getFiliereById(Long.valueOf(idFiliere));
	 
		List<Niveau> niveaux = filiereservices.getNiveauxByIdFiliere(Long.valueOf(idFiliere));
		List<NiveauModel> niveaumodels = new ArrayList<NiveauModel>();
		
		// On copie les données des personnes vers le modèle
		
			for (int i = 0; i < niveaux.size(); i++) {
			NiveauModel nm = new NiveauModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
			    
			    	BeanUtils.copyProperties(niveaux.get(i),nm);
				    niveaumodels.add(nm);}
		
		
		model.addAttribute("NiveauList", niveaumodels);

		return "cadreadmin/NiveauForm";
		}
	   

	 
	@RequestMapping(value = "showNiveauModules/{idNiveau}",method=RequestMethod.GET)
	public String showNiveauModule(@PathVariable int idNiveau,Model model) {

		ModuleModel modulemodel = new ModuleModel();
		model.addAttribute("ModuleModel",modulemodel );
         
		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par PersonModel pour une meilleur flexibilité
		
		//Filiere filiere=filiereservices.getFiliereById(Long.valueOf(idFiliere));
	   //s Niveau niveau=niveauservice.getNiveauById(Long.valueOf(idNiveau));
		List<Module> modules = moduleservice.getModulesByNiveauId(Long.valueOf(idNiveau));
		List<ModuleModel> modulemodels = new ArrayList<ModuleModel>();
		
		// On copie les données des personnes vers le modèle
		
			for (int i = 0; i < modules.size(); i++) {
				ModuleModel nm = new ModuleModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
			    
			    	BeanUtils.copyProperties(modules.get(i),nm);
			    	modulemodels.add(nm);}
		
		
		model.addAttribute("ModuleList", modulemodels);

		return "cadreadmin/ModuleForm"; }
	
	
	@RequestMapping(value = "showModuleMatiere/{idModule}",method=RequestMethod.GET)
	public String showModuleMatiere(@PathVariable int idModule,Model model) {

		MatiereModel matieremodel = new MatiereModel();
		model.addAttribute("MatiereModel",matieremodel);
         
		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par PersonModel pour une meilleur flexibilité
		
		List<Matiere> matieres = matiereservice.getMatiereByIdModule(Long.valueOf(idModule));
		List<MatiereModel> matieremodels = new ArrayList<MatiereModel>();
		
		// On copie les données des personnes vers le modèle
		
			for (int i = 0; i < matieres.size(); i++) {
				MatiereModel nm = new MatiereModel();
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
			    
			    	BeanUtils.copyProperties(matieres.get(i),nm);
			    	matieremodels.add(nm);}
		
		
		model.addAttribute("MatiereList", matieremodels);

		return "cadreadmin/MatiereForm"; }
	
	@RequestMapping(value = "addFiliere",method=RequestMethod.POST)
	public String process(@Valid @ModelAttribute("FiliereModel") FiliereModel filieremodel, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			// rq.setAttribute("typePerson", +person.getTypePerson());
			return "cadreadmin/CaForm"; 
		}

		// Copier les données de l'objet FiliereModel vers l'objet Filiere 
			Filiere filiere = new Filiere();
			
			
			BeanUtils.copyProperties(filieremodel, filiere);
			
           System.out.println(filiere.toString());
		   filiereservices.addFiliere(filiere);
		   		

			model.addAttribute("FiliereList",filiereservices.getAllFiliere());


		// rediriger vers l'action showForm avec l'objet Filiere
		return "redirect:/cadreadmin/showAllFilieres"; 
	}
	 
	@RequestMapping(value = "addNiveau/{idFiliere}",method=RequestMethod.POST)
	public String addNiveau(@Valid @ModelAttribute("NiveauModel") NiveauModel niveauModel,@PathVariable int idFiliere,BindingResult bindingResult,
			Model model) {

		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			// rq.setAttribute("typePerson", +person.getTypePerson());
			return "cadreadmin/CaForm"; 
		}

		// Copier les données de l'objet FiliereModel vers l'objet Filiere 
			Niveau niveau = new Niveau();
			
			Filiere filiere=filiereservices.getFiliereById(Long.valueOf(idFiliere));
			
						
			BeanUtils.copyProperties(niveauModel, niveau);
			
			niveauservice.addNiveau(niveau,Long.valueOf(idFiliere));
			
			//niveauservice.addNiveau(niveau);
			System.out.println(filiere);
	        //model.addAttribute("NiveauModel", niveauModel);
			model.addAttribute("NiveauList",filiereservices.getNiveauxByIdFiliere(Long.valueOf(idFiliere)));


		// rediriger vers l'action showForm avec l'objet Filiere
		return "redirect:/cadreadmin/showFilieresNiveau/{idFiliere}";
		//+filiere.getIdFiliere(); 
	}
	
	
//ajout de Module	
	@RequestMapping(value = "addModule/{idNiveau}",method=RequestMethod.POST)
	public String addModule(@Valid @ModelAttribute("ModuleModel") NiveauModel moduleModel,@PathVariable int idNiveau,BindingResult bindingResult,
			Model model) {

		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			// rq.setAttribute("typePerson", +person.getTypePerson());
			return "cadreadmin/CaForm"; 
		}

		// Copier les données de l'objet FiliereModel vers l'objet Module 
			Module module = new Module();
			
			//Niveau niveau=niveauservice.getNiveauById(Long.valueOf(idNiveau));
			
						
			BeanUtils.copyProperties(moduleModel, module);
			
			moduleservice.addModule(module,Long.valueOf(idNiveau));
			
			
			model.addAttribute("ModuleList",moduleservice.getModulesByNiveauId(Long.valueOf(idNiveau)));

            
		// rediriger vers l'action showForm avec l'objet Filiere
		return "redirect:/cadreadmin/showNiveauModules/{idNiveau}";
		//+filiere.getIdFiliere(); 
	}
	
	@RequestMapping(value = "addMatiere/{idModule}",method=RequestMethod.POST)
	public String addMatiere(@Valid @ModelAttribute("MatiereModel") MatiereModel matiereModel,@PathVariable int idModule,BindingResult bindingResult,
			Model model) {

		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			// rq.setAttribute("typePerson", +person.getTypePerson());
			return "cadreadmin/CaForm"; 
		}

		// Copier les données de l'objet FiliereModel vers l'objet Module 
			Matiere matiere = new Matiere();
			
			//Niveau niveau=niveauservice.getNiveauById(Long.valueOf(idNiveau));
			
						
			BeanUtils.copyProperties(matiereModel, matiere);
			
			matiereservice.addMatiere(matiere,Long.valueOf(idModule));
			
			
			model.addAttribute("MatiereList",matiereservice.getMatiereByIdModule(Long.valueOf(idModule)));

            
		// rediriger vers l'action showForm avec l'objet Filiere
		return "redirect:/cadreadmin/showModuleMatiere/{idModule}";
		//+filiere.getIdFiliere(); 
	}
	
	
	
	  @RequestMapping("updateFilieres") 
	  public String updateFiliere(@Valid @ModelAttribute("FiliereModel") Filiere filiere,BindingResult bindingResult, Model model) {
		  
		  
		if (bindingResult.hasErrors()) {

				return "cadreadmin/updateForm";
			}
	  filiereservices.updateFiliere(filiere); 
	  
	  model.addAttribute("FiliereList", filiereservices.getAllFiliere());
	  //model.addAttribute("NiveauList",niveauservice.getAllNiveaux());
	  
	  return "redirect:/cadreadmin/ManageFilieres"; 
	  }
	 
	  
	@RequestMapping("ManageFilieres")
	public String manageFiliere(Model model) {

		List<Filiere> filiere = filiereservices.getAllFiliere();
		List<FiliereModel> filieremodel = new ArrayList<FiliereModel>();

		// Copier les objets metier vers FiliereModel plus flexible
		for (int i = 0; i < filiere.size(); i++) {
			FiliereModel fm = new FiliereModel();
				BeanUtils.copyProperties(filiere.get(i), fm);
				filieremodel.add(fm);

		}
		model.addAttribute("FiliereList", filieremodel);
		return "cadreadmin/ListFiliere";
	}
	   
	
	
	@RequestMapping("updateFiliere") 
	public String updateFiliere(@Valid @ModelAttribute("FiliereModel") FiliereModel filieremodel, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "cadreadmin/updateFiliere";
		}

		// On copie les données du modèle vers l'objet métier puis on appel le service
		// pour faire la mise à jour
		
			Filiere filiere = new Filiere();
			BeanUtils.copyProperties(filieremodel, filiere);

			filiereservices.updateFiliere(filiere);
			
           //model.addAttribute("FiliereModel", filieremodel);
		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		return "cadreadmin/updateFiliere";
	}
	
	
	
	@RequestMapping(value = "updateFiliereForm/{idFiliere}", method = RequestMethod.GET)
	public String updateFiliereForm(@PathVariable int idFiliere, Model model) {

		// On reoit comme paramètre l'id de la filiere à mettre à jour
		Filiere filiere = filiereservices.getFiliereById(Long.valueOf(idFiliere));

		// On construit le modèle
		FiliereModel fm = new FiliereModel();

		
		// Ceci va nous pemettre d'afficher un formulaire adapté
		// slon le type de la personne
		
			BeanUtils.copyProperties(filiere, fm);
	

		// Initialiser le modele avec la personne
		model.addAttribute("FiliereModel", fm);

		return "cadreadmin/updateFiliere";
	}
	
	
	
	
	@RequestMapping(value="updateNiveau/{idNiveau}",method = RequestMethod.POST) 
	public String updateFiliere(@Valid @ModelAttribute("NiveauModel") NiveauModel niveaumodel,@PathVariable int idNiveau, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "cadreadmin/updateNiveau";
		}

		// On copie les données du modèle vers l'objet métier puis on appel le service
		// pour faire la mise à jour
		
			Niveau niveau = niveauservice.getNiveauById(Long.valueOf(idNiveau));
			System.out.println(niveau.toString());
			BeanUtils.copyProperties(niveaumodel, niveau);

			niveauservice.updateNiveau(niveau);
			
           //model.addAttribute("NiveauList", niveauservice.getNiveauById(Long.valueOf(idFiliere)));
		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		//return "cadreadmin/updateNiveau";
		return "redirect:/cadreadmin/showFilieresNiveau/"+niveau.getFiliere().getIdFiliere();
	}
	
	
	
	@RequestMapping(value = "updateNiveauForm/{idNiveau}/{idFiliere}", method = RequestMethod.GET)
	public String updateNiveauForm(@PathVariable int idNiveau,@PathVariable int idFiliere, Model model) {

		// On reoit comme paramètre l'id de la filiere à mettre à jour
		Niveau niveau = niveauservice.getNiveauByFiliereId(Long.valueOf(idNiveau), Long.valueOf(idFiliere));
		
//		idFiliere=(niveau.getFiliere().getIdFiliere();     

		// On construit le modèle
		NiveauModel nm = new NiveauModel();

		// Ceci va nous pemettre d'afficher un formulaire adapté
		// slon le type de la personne
		 System.out.println(niveau);
			BeanUtils.copyProperties(niveau, nm);
	

		// Initialiser le modele avec la personne
		model.addAttribute("NiveauModel", nm);

		return "cadreadmin/updateNiveau";
		//+niveau.getFiliere().getIdFiliere();
				//+"/"+ niveau.getIdNiveau();
	}
	
	
	
	
	//===================================================================================
	
	
	@RequestMapping(value = "updateModuleForm/{idModule}/{idNiveau}", method = RequestMethod.GET)
	public String updateModuleForm(@PathVariable int idNiveau,@PathVariable int idModule, Model model) {

		// On reoit comme paramètre l'id de la filiere à mettre à jour
		Module module = moduleservice.getModuleByNiveauId(Long.valueOf(idNiveau),Long.valueOf(idModule));
		
//		idFiliere=(niveau.getFiliere().getIdFiliere();     

		// On construit le modèle
		ModuleModel nm = new ModuleModel();

		// Ceci va nous pemettre d'afficher un formulaire adapté
		// slon le type de la personne
		 //System.out.println(niveau);
			BeanUtils.copyProperties(module, nm);
	

		// Initialiser le modele avec la personne
		model.addAttribute("ModuleModel", nm);

		return "cadreadmin/updateModule";
		//+niveau.getFiliere().getIdFiliere();
				//+"/"+ niveau.getIdNiveau();
	}
	
	
	@RequestMapping(value="updateModule/{idModule}",method = RequestMethod.POST) 
	public String updateModule(@Valid @ModelAttribute("ModuleModel") ModuleModel modulemodel,@PathVariable int idModule, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "cadreadmin/updateNiveau";
		}

		// On copie les données du modèle vers l'objet métier puis on appel le service
		// pour faire la mise à jour
		
			Module module = moduleservice.getModuleById(Long.valueOf(idModule));
			//System.out.println(niveau.toString());
			BeanUtils.copyProperties(modulemodel, module);

			moduleservice.update(module);
			
           //model.addAttribute("NiveauList", niveauservice.getNiveauById(Long.valueOf(idFiliere)));
		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		//return "cadreadmin/updateNiveau";
		return "redirect:/cadreadmin/showNiveauModules/"+module.getNiveau().getIdNiveau();
	}
	//==============================================================================================================
	
	
	
	
	@RequestMapping(value = "updateMatiereForm/{idMatiere}/{idModule}", method = RequestMethod.GET)
	public String updateMatiereForm(@PathVariable int idMatiere,@PathVariable int idModule, Model model) {

		// On reoit comme paramètre l'id de la filiere à mettre à jour
		Matiere matiere = matiereservice.getMatiereByModuleId(Long.valueOf(idMatiere),Long.valueOf(idModule));
		
//		idFiliere=(niveau.getFiliere().getIdFiliere();     

		// On construit le modèle
		MatiereModel nm = new MatiereModel();

		// Ceci va nous pemettre d'afficher un formulaire adapté
		// slon le type de la personne
		 //System.out.println(niveau);
			BeanUtils.copyProperties(matiere, nm);
	

		// Initialiser le modele avec la personne
		model.addAttribute("MatiereModel", nm);

		return "cadreadmin/updateMatiere";
		//+niveau.getFiliere().getIdFiliere();
				//+"/"+ niveau.getIdNiveau();
	}
	
	
	@RequestMapping(value="updateMatiere/{idMatiere}",method = RequestMethod.POST) 
	public String updateMatiere(@Valid @ModelAttribute("MatiereModel") MatiereModel modulemodel,@PathVariable int idMatiere, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "cadreadmin/updateNiveau";
		}

		// On copie les données du modèle vers l'objet métier puis on appel le service
		// pour faire la mise à jour
		
			Matiere matiere = matiereservice.getMatiereById(Long.valueOf(idMatiere));
			//System.out.println(niveau.toString());
			BeanUtils.copyProperties(modulemodel, matiere);

			matiereservice.updateMatiere(matiere);
			
         
		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		//return "cadreadmin/updateNiveau";
		return "redirect:/cadreadmin/showModuleMatiere/"+matiere.getModule().getIdModule();
	}
	
	
	
	
	//================================================================================================================
	
	
	@RequestMapping(value = "deleteMatiere/{idMatiere}", method = RequestMethod.GET)
	public String deleteMatiere(@PathVariable int idMatiere) {
		
		matiereservice.deleteMatiere(Long.valueOf(idMatiere));
		

		return "redirect:/cadreadmin/ManageFilieres";
	}
	
	
	
	
	@RequestMapping(value = "deleteModule/{idModule}", method = RequestMethod.GET)
	public String deleteModule(@PathVariable int idModule) {
		
		moduleservice.deleteModule(Long.valueOf(idModule));
		

		return "redirect:/cadreadmin/ManageFilieres";
	}
	
	
	
	@RequestMapping(value = "deleteFiliere/{idFiliere}", method = RequestMethod.GET)
	public String removeFiliere(@PathVariable int idFiliere) {
		
		filiereservices.deleteFiliere(Long.valueOf(idFiliere));
		
		return "redirect:/cadreadmin/ManageFilieres";
	}
	
	
	@RequestMapping(value = "deleteNiveau/{idNiveau}", method = RequestMethod.GET)
	public String removeNiveau(@PathVariable int idNiveau) {
		
		niveauservice.deleteNiveau(Long.valueOf(idNiveau));
		
		return "redirect:/cadreadmin/ManageFilieres";
	}
	
}
