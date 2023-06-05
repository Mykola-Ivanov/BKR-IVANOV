package ua.ivanov.ClimateControlService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ivanov.ClimateControlService.models.ClimateProfile;
import ua.ivanov.ClimateControlService.repositories.ClimateProfileRepository;

@Service
@Transactional(readOnly = true)
public class ClimateProfileService {
    ClimateProfileRepository profileRepository;
    public ClimateProfileService() {
    }
    @Autowired
    public ClimateProfileService(ClimateProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    public List<ClimateProfile> getAll(){
        var all = profileRepository.findAll();
        System.out.println("climate profile count: "+all.size());
        return all;
    }

    public ClimateProfile getById(int id){
        return profileRepository.findById(id).get();
    }
    @Transactional
    public void save(ClimateProfile profile){
        profileRepository.save(profile);
    }
    @Transactional
    public void delete(int id) {
        profileRepository.deleteById(id);
    }
    @Transactional
    public void select(int id) {
        var currentSelectedProfile = profileRepository.findAllBySelectedTrue();
        for (int index = 0; index < currentSelectedProfile.size(); index++) {
            currentSelectedProfile.get(index).setSelected(false);
            profileRepository.save(currentSelectedProfile.get(index));
        }
        var newSelectedProfile = profileRepository.findById(id).get();
        newSelectedProfile.setSelected(true);
        profileRepository.save(newSelectedProfile);
        
    }
}
