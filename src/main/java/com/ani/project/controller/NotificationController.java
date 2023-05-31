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
import com.ani.project.dto.NotificationDto;
import com.ani.project.service.NotificationService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/notification")
@RestController
public class NotificationController {
    
    private final NotificationService service;

    @CrossOrigin
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewNotification(@Valid @RequestBody NotificationDto dto){
        final Integer sts = service.createNewNotification(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Notification Added Successfully").bd(sts).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<NotificationDto>>> allNotifications(){
        List<NotificationDto> notifications = service.all();
        AppResponse<List<NotificationDto>> response = AppResponse.<List<NotificationDto>>builder().sts("success").msg("All Notifications").bd(notifications).build();
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteNotification(@PathVariable Long id){
        final Integer sts = service.deleteNotification(id);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Notification deleted successfully").bd(sts).build();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<NotificationDto>> getNotificationById(@PathVariable Long id){

        final NotificationDto dto = service.fetchNotificationDetails(id);

        final AppResponse<NotificationDto> response = AppResponse.<NotificationDto>builder().sts("success").msg("Notification details").bd(dto).build();
        return ResponseEntity.ok().body(response);

    }

    @CrossOrigin
    @PutMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewNotification(@Valid @RequestBody NotificationDto dto){
        final Integer sts = service.updateNotification(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Notification Updated Successfully").bd(sts).build();
        return ResponseEntity.ok().body(response);

    }


}