import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import entities.Cours;
import entities.Module;
import services.ModuleService;
import entities.Professeurs;
public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        //Dependances
        ModuleService moduleService=new ModuleService();
        do{ 
            System.out.println("1-Ajouter un Module");
            System.out.println("2-Lister les Modules"); 
            System.out.println("3-Créer un cours"); 
            System.out.println("4-Lister tous les cours");
            System.out.println("5-Lister les cours  d’un module et d’un professeur");
            System.out.println("6-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine(); 
             switch(choix){
                case 1:
                System.out.println( "Entrer le nom du module");
                String name=sc.nextLine();
                Module module = new Module();
                module.setNomModule(name);
                moduleService.ajouterModule(module);
                break;

                case 2:
                System.out.println("Les modules sont les suivantes:");
                    List<Module> modules=moduleService.listerModule();
                    for (Module m : modules ) {
                        System.out.println(m.getIdModule()+" "+m.getNomModule());
                    }
                    break;
                break;
                
                case 3:
                Cours cours = new Cours();

                    System.out.println("Entrez l'ID du cours:");
                    cours.setIdCours(sc.nextInt());
                    sc.nextLine(); // consume newline

                    System.out.println("Entrez la date du cours (AAAA-MM-JJ):");
                    cours.setDate(LocalDate.parse(sc.nextLine()));

                    System.out.println("Entrez l'heure de début du cours (HH:MM):");
                    cours.setHeureDebut(LocalTime.parse(sc.nextLine()));

                    System.out.println("Entrez l'heure de fin du cours (HH:MM):");
                    cours.setHeureFin(LocalTime.parse(sc.nextLine()));

                    System.out.println("Entrez le nom du professeur:");
                    Professeurs professeur = new Professeurs();
                    sc.nextLine();
                    cours.setProfesseur(professeur);

                    System.out.println("Entrez le nom du module:");
                    module = new Module();
                    sc.nextLine();
                    cours.setModule(module);

                    System.out.println("Cours créé avec succès:");
                    System.out.println(cours);
                   break;
                   
                   case 4:
                   break;

                   default:
                   break;
            }
        }
    }
}
