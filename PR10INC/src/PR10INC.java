
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author DJKIK
 */
public class PR10INC {

    /**
     * @param args the command line arguments
     * @throws org.semanticweb.owlapi.model.OWLOntologyCreationException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws OWLOntologyCreationException,FileNotFoundException{
        // load ontology
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology=manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\DJKIK\\Documents\\Practica6inco\\co_357.owl"));
        OWLDataFactory owlDF = manager.getOWLDataFactory();
        showClasses(ontology);
        propertyVal(ontology);
        
    }

	private static void propertyVal(OWLOntology ontology) {
		Set<OWLDataPropertyDomainAxiom> set=ontology.getAxioms(AxiomType.DATA_PROPERTY_DOMAIN);
		for(OWLDataPropertyDomainAxiom d :set) {
			   d.getDomain();
                             System.out.println("\n Datos-propiedades");
                             System.out.println(d);
			}
		
	}

	private static void showClasses(OWLOntology ontology) {
		Set<OWLClass> classes = ontology.getClassesInSignature();
                System.out.println(classes);
		
	}
   
    
}
