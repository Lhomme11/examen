package services;

import java.util.List;

import entities.Cours;
import repositories.CoursRepository;

public class CoursService {
    CoursRepository coursRepository= new CoursRepository();
    public void creerCours(Cours cours) {
        coursRepository.insertCours(cours);
    }
    
    public List<Cours> listerTousLesCours() {
        return coursRepository.selectAllCours();
    }
}
