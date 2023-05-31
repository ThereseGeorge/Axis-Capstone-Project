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
import com.ani.project.dto.StudyPlanDto;
import com.ani.project.service.StudyPlanService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/plan")
@RestController
public class StudyPlanController {
    
    private final StudyPlanService service;

    @CrossOrigin
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewPlan(@Valid @RequestBody StudyPlanDto dto){
        final Integer sts = service.createNewPlan(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Study Plan Added Successfully").bd(sts).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<StudyPlanDto>>> allPlans(){
        List<StudyPlanDto> plans = service.all();
        AppResponse<List<StudyPlanDto>> response = AppResponse.<List<StudyPlanDto>>builder().sts("success").msg("All Study Plans").bd(plans).build();
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deletePlan(@PathVariable Long id){
        final Integer sts = service.deletePlan(id);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Study plan deleted successfully").bd(sts).build();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<StudyPlanDto>> getPlanById(@PathVariable Long id){

        final StudyPlanDto dto = service.fetchPlanDetails(id);

        final AppResponse<StudyPlanDto> response = AppResponse.<StudyPlanDto>builder().sts("success").msg("Study plan details").bd(dto).build();
        return ResponseEntity.ok().body(response);

    }

    @CrossOrigin
    @PutMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewPlan(@Valid @RequestBody StudyPlanDto dto){
        final Integer sts = service.updatePlan(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Study Plan Updated Successfully").bd(sts).build();
        return ResponseEntity.ok().body(response);

    }
}
