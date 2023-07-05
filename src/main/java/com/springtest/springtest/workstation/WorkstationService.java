package com.springtest.springtest.workstation;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkstationService {
    private final WorkstationRepository workstationRepository;

    public WorkstationService(WorkstationRepository workstationRepository) {
        this.workstationRepository = workstationRepository;
    }

    public List<Workstation> getAllWorkstation() {
        return workstationRepository.findAll();
    }

    public void addWorkStation(Workstation workstation) {
        workstationRepository.save(workstation);
        workstationRepository.flush();
    }
}
