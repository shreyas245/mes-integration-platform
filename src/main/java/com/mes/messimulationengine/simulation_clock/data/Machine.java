package com.mes.messimulationengine.simulation_clock.data;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="machine")
@Table(name = "machine",schema = "test")
@NoArgsConstructor
@Getter
@Setter
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID machineID;
    private String machineName;
    private String machineState;

    @Nullable
    private Integer cycleTimeSeconds;

    @Nullable
    private Integer meanTimeBetweenFailures;

    @Nullable
    private LocalDateTime createdate;

}
