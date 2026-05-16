package com.mes.messimulationengine.simulation_clock.controller;

import com.mes.messimulationengine.simulation_clock.Repository.MachineRepository;
import com.mes.messimulationengine.simulation_clock.data.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MachineController {

    @Autowired
    private MachineRepository machineRepository;

    @GetMapping("/index")
    public String indexPage(){
        return new String("Shreyas");
    }

    @GetMapping("/machineList")
    public List<Machine> findMachines(){
        return machineRepository.getAllMachines();
    }

    @PostMapping("/addMachine")
    public void storeMachine(@RequestBody Machine machine){

        System.out.println(machine.getMachineName());
        System.out.println(machine.getMachineState());

        machineRepository.addMachine(machine);
    }
}
