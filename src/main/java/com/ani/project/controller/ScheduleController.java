package com.ani.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.project.dto.AppResponse;
import com.ani.project.dto.ScheduleDto;
import com.ani.project.service.ScheduleService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/schedule")
@RestController
public class ScheduleController {
    
    private final ScheduleService service;

    @CrossOrigin
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewSchedule(@Valid @RequestBody ScheduleDto dto){
        final Integer sts = service.createNewSchedule(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Class Schedule Added Successfully").bd(sts).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<ScheduleDto>>> allSchedules(){
        List<ScheduleDto> schedules = service.all();
        AppResponse<List<ScheduleDto>> response = AppResponse.<List<ScheduleDto>>builder().sts("success").msg("All Schedules").bd(schedules).build();
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteSchedule(@PathVariable Long id){
        final Integer sts = service.deleteSchedule(id);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Class schedule deleted successfully").bd(sts).build();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<ScheduleDto>> getScheduleById(@PathVariable Long id){

        final ScheduleDto dto = service.fetchScheduleDetails(id);

        final AppResponse<ScheduleDto> response = AppResponse.<ScheduleDto>builder().sts("success").msg("Class schedule details").bd(dto).build();
        return ResponseEntity.ok().body(response);

    }

    @CrossOrigin
    @PutMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewSchedule(@Valid @RequestBody ScheduleDto dto){
        final Integer sts = service.updateSchedule(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Class Schedule Updated Successfully").bd(sts).build();
        return ResponseEntity.ok().body(response);

    }
}