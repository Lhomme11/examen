package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Module;

public class ModuleRepository extends Database{
    private final  String SQL_INSERT="INSERT INTO `Module` (`idModule`,`nomModule`) VALUES (?,?)";
    private final  String SQL_SELECT_ALL="select * from Module" ;
    // private final  String SQL_SELECT_BY_ID="select * from Module where idModule like ?" ;
    
    public  void insertModule(Module module){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
            statement.setString(1, module.getNomModule());;
            int nbreLigne=executeUpdate();
           closeConnexion();
         } catch (SQLException e) {
          e.printStackTrace();
         }
         }
         public  List<Module> selectAllModule(){
            List<Module> modules=new ArrayList<>();
          try {
              openConnexion();
              initPreparedStatement(SQL_SELECT_ALL);
              ResultSet rs= executeSelect();
                while (rs.next()) {
                    Module module= new Module();
                    module.setIdModule(rs.getInt("idModule"));
                    module.setNomModule("nomModule");
                    modules.add(module);
                }
                rs.close();
              closeConnexion();
           }
          catch (SQLException e) {
           System.out.println("Erreur de Connexion a la BD");
         }
           return  modules;
       }
}
