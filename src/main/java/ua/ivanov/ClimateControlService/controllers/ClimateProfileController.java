package ua.ivanov.ClimateControlService.controllers;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ivanov.ClimateControlService.models.ClimateProfile;
import ua.ivanov.ClimateControlService.services.ClimateProfileService;
//import ua.ivanov.ClimateControlService.services.TaskSchedulerService;

@Controller
@RequestMapping("/profile")
public class ClimateProfileController {
    ClimateProfileService profileService;

    

    public ClimateProfileController(ClimateProfileService profileService) {
        this.profileService = profileService;
    }
    
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("profiles", profileService.getAll());
        return "profile/index";
    }
    /*
     * read
     */
    @GetMapping("view/{id}")
    public String viewProfile(@PathVariable("id") int id, Model model){
        var profile = profileService.getById(id);
        var records = profile.getRecords();
        model.addAttribute("profile", profile);
        model.addAttribute("records", records);
        return "profile/profileview";
    }
    /*
     * create
     */
    @GetMapping("/new")
    public String newProfile(Model model){
        model.addAttribute("newprofile", new ClimateProfile());
        return "profile/new";
    }

    @PostMapping("/add")
    public String postProfile(@ModelAttribute ClimateProfile profile,Model model){
        profileService.save(profile);
        return "redirect:/profile";
    }
    @DeleteMapping("/deleteprofile/{id}")
    public String deleteProfile(@PathVariable("id") int id){
        profileService.delete(id);
        return "redirect:/profile";
    }
    /*
     * update
     */
    @GetMapping("/rename/{id}")
    public String getProfileToRename(@PathVariable("id") int id, Model model){
        model.addAttribute("profileToRename", profileService.getById(id));
        return "profile/rename";
    }
    @PatchMapping("/rename")
    public String rename(ClimateProfile profile,Model model){
        profileService.save(profile);
        return "redirect:/profile";
    }
    /*
     * delete
     */
    @DeleteMapping("/delete/{id}")
    public String deleteById(){
        return "profile/index";
    }

    @PatchMapping("/setup/{id}")
    public String selectProfile(@PathVariable("id")int id){
        var profile = profileService.getById(id);
        profileService.select(id);
        return "redirect:/profile";
    }
    
}
