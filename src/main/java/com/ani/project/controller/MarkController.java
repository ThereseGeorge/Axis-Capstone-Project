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
import com.ani.project.dto.MarkDto;
import com.ani.project.service.MarkService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/mark")
@RestController
public class MarkController {
    
    private final MarkService service;

    @CrossOrigin
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewMark(@Valid @RequestBody MarkDto dto){
        final Integer sts = service.createNewMark(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Mark Added Successfully").bd(sts).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<MarkDto>>> allMarks(){
        List<MarkDto> marks = service.all();
        AppResponse<List<MarkDto>> response = AppResponse.<List<MarkDto>>builder().sts("success").msg("All mark").bd(marks).build();
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteMark(@PathVariable Long id){
        final Integer sts = service.deleteMark(id);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Mark deleted successfully").bd(sts).build();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<MarkDto>> getMarkById(@PathVariable Long id){

        final MarkDto dto = service.fetchMarkDetails(id);

        final AppResponse<MarkDto> response = AppResponse.<MarkDto>builder().sts("success").msg("Marks details").bd(dto).build();
        return ResponseEntity.ok().body(response);

    }

    @CrossOrigin
    @PutMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewMark(@Valid @RequestBody MarkDto dto){
        final Integer sts = service.updateMark(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Marks Updated Successfully").bd(sts).build();
        return ResponseEntity.ok().body(response);

    }

}
