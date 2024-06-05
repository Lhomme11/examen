package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.Cours;
import entities.Professeurs;
import entities.Module;

public class CoursRepository extends Database{
    private final  String SQL_INSERT="INSERT INTO `Cours` (`idCours`,`idModule`,`date`,`heureDebut`,`heureFin`,`idProfesseur`) VALUES (?, ?, ?, ?, ?, ?)";
    private final  String SQL_SELECT_ALL="select * from Cours" ;
    
    public void insertCours(Cours cours) {
        try {
            openConnexion();
            initPreparedStatement(SQL_INSERT);
            statement.setInt(1, cours.getIdCours());
            statement.setDate(2, Date.valueOf(cours.getDate()));
            statement.setTime(3, Time.valueOf(cours.getHeureDebut()));
            statement.setTime(4, Time.valueOf(cours.getHeureFin()));
            statement.setInt(5, cours.getModule().getIdModule());
            statement.setInt(6, cours.getProfesseur().getIdProf());
            executeUpdate();
            closeConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
    }
}    

         public  List<Cours> selectAllCours(){
            List<Cours> coursList = new ArrayList<>();
        try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Professeurs professeur = new Professeurs();
                professeur.setIdProf(rs.getInt("idProfesseur"));
                professeur.setNomProf(rs.getString("nomProf"));

                Module module = new Module();
                module.setIdModule(rs.getInt("idModule"));
                module.setNomModule(rs.getString("nomModule"));

                Cours cours = new Cours();
                cours.setIdCours(rs.getInt("idCours"));
                cours.setDate(rs.getDate("date").toLocalDate());
                cours.setHeureDebut(rs.getTime("heureDebut").toLocalTime());
                cours.setHeureFin(rs.getTime("heureFin").toLocalTime());
                cours.setProfesseur(professeur);
                cours.setModule(module);

                coursList.add(cours);
            }
            rs.close();
            closeConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursList;
    }
}
