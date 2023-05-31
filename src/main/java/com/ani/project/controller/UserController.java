package com.ani.project.controller;



import javax.validation.Valid;

import com.ani.project.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ani.project.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserController {
    
    private final UserService service;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<Integer>> signup(@Valid @RequestBody CreateUserDto dto) {
        final Integer sts = service.signup(dto);

        AppResponse<Integer> res = AppResponse.<Integer>builder()
                                                .sts("success")
                                                .msg("User Created")
                                                .bd(sts)
                                                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<UserDto>> login(@Valid @RequestBody LoginDto dto) {
        final UserDto resDto = service.login(dto);

        AppResponse<UserDto> res = AppResponse.<UserDto>builder()
                                                .sts("success")
                                                .msg("Login Success")
                                                .bd(resDto)
                                                .build();

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    @PostMapping(value = "/loginv2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<LoginResponseDto>> loginResponseDetails(@Valid @RequestBody LoginDto dto) {
        LoginResponseDto loginUser = service.loginUserForResponse(dto);
        AppResponse<LoginResponseDto> response = AppResponse.<LoginResponseDto>builder()
                .sts("success")
                .msg("user login as...")
                .bd(loginUser)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping(value = "/{userId}/userEnrollments/{courseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> enrollCourse(@Valid @PathVariable Long userId, @PathVariable Long courseId) {
        Integer enrollCourse = service.enrollCourse(userId, courseId);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("new course enrolled successfully.")
                .bd(enrollCourse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping(value = "/getuserEnrollments/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AppResponse<List<UserCoursesDto>>> findAll(@PathVariable Long userId) {
       List<UserCoursesDto> sts=  service.getAllEnrollments(userId);
        AppResponse<List<UserCoursesDto>> response=AppResponse.<List<UserCoursesDto>>builder()
                .sts("success")
                .msg("All current enrollments")
                .bd(sts)
                .build();
        return ResponseEntity.ok().body(response);
    }


//    @GetMapping(value = "/getcurrentEnrollments/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<AppResponse<List<UserCoursesDto>>> getCurrentBookings(@PathVariable Long userId) {
//        List<UserCoursesDto> sts=service.getCurrentEnrollments(userId);
//        AppResponse<List<UserCoursesDto>> response=AppResponse.<List<UserCoursesDto>>builder()
//                .sts("success")
//                .msg("All current enrollments")
//                .bd(sts)
//                .build();
//        return ResponseEntity.ok().body(response);
//    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<UserDto>>> findAllUsers() {
        List<UserDto> users = service.getAllUser();
        AppResponse<List<UserDto>> response = AppResponse.<List<UserDto>>builder()
                .sts("success")
                .msg("All users")
                .bd(users)
                .build();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping(value = "/allStudentEnrolled", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<StudentEnrolledDto>>> getAllUserBookings() {
        List<StudentEnrolledDto> sts = service.getAllStudentEnrolled();
        AppResponse<List<StudentEnrolledDto>> response = AppResponse.<List<StudentEnrolledDto>>builder()
                .sts("success")
                .msg("All User Bookings")
                .bd(sts)
                .build();
        return ResponseEntity.ok().body(response);
    }
    @PutMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateCourse(@RequestBody CreateUserDto dto) {

        final Integer sts = service.updateUser(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("User Updated Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.ok().body(response);
    }
//    @CrossOrigin
//    @PutMapping(value="/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<AppResponse<Integer>> updateUser(@Valid @RequestBody CreateUserDto dto){
//        final Integer sts = service.updateUser(dto);
//        final AppResponse<Integer> response = AppResponse.<Integer>builder()
//                .sts("User Updated Successfully")
//                .bd(sts).build();
//        return ResponseEntity.ok().body(response);
//
//    }


    @DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteCourse(@PathVariable Long userId) {

        final Integer sts = service.deleteUser(userId);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("User Deleted Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(200).body(response);
    }
    @GetMapping(value = "/getUserById/{userId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<UserUpdateDto>> getUserById(@PathVariable Long userId) {

        final UserUpdateDto dto = service.fetchUserDetails(userId);

        final AppResponse<UserUpdateDto> response = AppResponse.<UserUpdateDto>builder()
                .sts("success")
                .msg("Course Details")
                .bd(dto)
                .build();
        return ResponseEntity.ok().body(response);
    }

}