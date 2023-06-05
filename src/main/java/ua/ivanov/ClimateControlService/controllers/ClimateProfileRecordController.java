package ua.ivanov.ClimateControlService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.ivanov.ClimateControlService.dto.ClimateProfileRecordDTO;
import ua.ivanov.ClimateControlService.dto.ClimateProfileRecordIDDTO;
import ua.ivanov.ClimateControlService.models.ClimateProfile;
import ua.ivanov.ClimateControlService.models.ClimateProfileRecord;
import ua.ivanov.ClimateControlService.services.ClimateProfileRecordService;
import ua.ivanov.ClimateControlService.services.ClimateProfileService;

@Controller
@RequestMapping("/record")
public class ClimateProfileRecordController {
    ClimateProfileRecordService climateProfileRecordService;
    ClimateProfileService climateProfileService;
    
    @Autowired
    public ClimateProfileRecordController(ClimateProfileRecordService climateProfileRecordService,
            ClimateProfileService climateProfileService) {
        this.climateProfileRecordService = climateProfileRecordService;
        this.climateProfileService = climateProfileService;
    }
    @GetMapping("/new/{id}")
    public String getFormToCreateRecord(@PathVariable("id") int id,Model model){
        var record = new ClimateProfileRecordDTO();
        model.addAttribute("newRecord", record);
        ClimateProfile profile = climateProfileService.getById(id);
        model.addAttribute("profileToAddRecord", profile);
        return "record/new";
    }
    @PostMapping("/add/{id}")
    public String CreateRecord(@PathVariable("id") int id,@ModelAttribute ClimateProfileRecordDTO recordDTO){
        ClimateProfile profile = climateProfileService.getById(id);
        ClimateProfileRecord record = new ClimateProfileRecord(recordDTO);
        record.setProfile(profile);
        climateProfileRecordService.addRecord(profile.records,record);
        climateProfileService.save(profile);
        return "redirect:/profile/view/"+profile.climateProfileId;
    }
    @GetMapping("/edit/{id}")
    public String editRecord(@PathVariable("id") int id , Model model){
        ClimateProfileRecord record = climateProfileRecordService.getById(id);
        model.addAttribute("editRecord", record);
        model.addAttribute("profileId", record.getProfile().getClimateProfileId());
        return "record/edit";
    }
    @PatchMapping("/edit/{profileId}")
    public String applyChanges(@PathVariable("profileId") int profileId,@ModelAttribute ClimateProfileRecordIDDTO recordDTO){
        var profile = climateProfileService.getById(profileId);
        
        var record = new ClimateProfileRecord(recordDTO);
        climateProfileRecordService.setRecordById(profile.getRecords(),record.getClimateProfileRecordId(), record);
        record.setProfile(profile);
        climateProfileService.save(profile);
        climateProfileRecordService.save(record);
        return "redirect:/profile/view/"+profileId;
    }

    @DeleteMapping("/delete/{profileId}/{recordId}")
    public String deleteRecord(@PathVariable("profileId") int profileId,@PathVariable("recordId") int recordId){
        climateProfileRecordService.deleteById(recordId);
        return "redirect:/profile/view/"+profileId;
    }
}
