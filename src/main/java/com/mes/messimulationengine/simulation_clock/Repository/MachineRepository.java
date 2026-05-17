package com.mes.messimulationengine.simulation_clock.Repository;

import com.mes.messimulationengine.simulation_clock.data.Machine;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MachineRepository {

    private JdbcTemplate jdbc;

    public MachineRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Machine> getAllMachines(){
        String sql = "SELECT * FROM machine";
        RowMapper<Machine> machineRowMapper = (r,i) -> {
            Machine machineRow = new Machine();
            machineRow.setMachineID(r.getObject("machineId", UUID.class));
            machineRow.setMachineName(r.getString("machine_name"));
            machineRow.setMachineState(r.getString("machine_state"));
            return machineRow;
        };
        return jdbc.query(sql, machineRowMapper);
    }

    public void addMachine(Machine machine){
        String sql = "INSERT INTO machine(machineId,machine_name,machine_state) values( ?,?, ?)";
        UUID machineId = UUID.randomUUID();
        jdbc.update(sql,11,machine.getMachineName(),machine.getMachineState());
    }

}
