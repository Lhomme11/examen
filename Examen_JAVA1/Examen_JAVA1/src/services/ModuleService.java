package services;

import java.util.List;
import repositories.ModuleRepository;
import entities.Module;
public class ModuleService {
    ModuleRepository moduleRepository = new ModuleRepository();
        public void ajouterModule(Module Module){
        moduleRepository.insertModule(Module);
    }
    public List<Module> listerModule() {
        return moduleRepository.selectAllModule();
    }
    // public Module chercherModuleById(int id) {
    //     return ModuleRepository.chercherModuleById(id);
    // }
}
