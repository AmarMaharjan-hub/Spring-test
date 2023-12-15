package com.springtest.springtest.workstation;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/workstation")
public class WorkstationController {
    private final WorkstationService workstationService;

    public WorkstationController(WorkstationService workstationService) {
        this.workstationService = workstationService;
    }
    @GetMapping
    public List<Workstation> getAllWorkstation(){
        return workstationService.getAllWorkstation();
    }
    @PostMapping
    public void addWorkstation(@RequestBody Workstation workstation){
        workstationService.addWorkStation(workstation);
    }
    @PutMapping
    public void updateWorkstation(
            @RequestParam Integer id,
            @RequestParam String ram,
            @RequestParam String storage,
            @RequestParam String operatingSystem){
        //update workstation
    }
    @DeleteMapping
    public void deleteWorkstation(
            @RequestParam Integer id
    ){
        //delete workstation
    }

}
