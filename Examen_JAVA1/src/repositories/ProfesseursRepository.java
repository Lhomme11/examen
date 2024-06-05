package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.List;
import java.util.List;

import entities.Professeurs;

public class ProfesseursRepository extends Database {
    private final String SQL_INSERT="INSERT INTO `professeurs` (`idProf`,`nomProf`, `prenomProf`, `tel`) VALUES (?,?,?,?)";
        private final  String SQL_SELECT_ALL="select * from professeurs" ;
        // private final  String SQL_SELECT_BY_ID="select * from professeur where idProfesseur like ?" ;
         public void insert(Professeurs  Professeur){
            try {
                 openConnexion();
                 initPreparedStatement(SQL_INSERT);
                 statement.setInt(1,Professeur.getIdProf());
                 statement.setString(2,Professeur.getNomProf());
                 statement.setString(3,Professeur.getPrenomProf());
                 statement.setString(4,Professeur.getTel());

                 executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    
    public List<Professeurs> selectAllProfesseur() {
        List<Professeurs> professeurs= new ArrayList<>();
        try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL);
            ResultSet rs= executeSelect();
                while (rs.next()) {
                    Professeurs professeur=new Professeurs();
                    professeur.setIdProf(rs.getInt("id"));
                    professeur.setNomProf(rs.getString("nomProf"));
                    professeur.setPrenomProf(rs.getString("prenomProf"));
                    professeur.setTel(rs.getString("tel"));
                    professeurs.add(professeur);
                }
                rs.close();
                closeConnexion();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur de Connexion à la BD");
        }
        return professeurs;
    }
//     public Professeur selectProfesseurById(int id){
//         Professeur professeur=null;
//          try {
//            openConnexion();
//            initPreparedStatement(SQL_SELECT_BY_ID);
//            statement.setInt(1, id);
//            ResultSet rs= executeSelect();
//            if (rs.next()) {
//             professeur=new Professeur();
//             professeur.setId(rs.getInt("idProfesseur"));
//             professeur.setNomComplet(rs.getString("nomComplet"));
//             professeur.setGrade(rs.getString("grade"));
//           }
//           rs.close();
//           closeConnexion();
//        }
//       catch (SQLException e) {
//        System.out.println("Erreur de Connexion a la BD");
//      }
//       return  professeur;
//      }
}
