package services;

import java.util.List;

import entities.Professeurs;
import repositories.ProfesseursRepository;

public class ProfesseursService {
    ProfesseursRepository professeurRepository=new ProfesseursRepository();

public List<Professeurs> listeProfesseurs(){
    return professeurRepository.selectAllProfesseur();
}
// public Professeur selectProfesseurById(int id) {
//     return professeurRepository.selectProfesseurById(id);
// }
}
