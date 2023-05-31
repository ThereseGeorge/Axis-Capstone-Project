package com.ani.project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ani.project.domain.Courses;
import com.ani.project.dto.*;
import com.ani.project.exception.*;
import com.ani.project.repository.CoursesRepository;
import com.ani.project.util.DynamicMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ani.project.domain.User;
import com.ani.project.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final DynamicMapper dynamicMapper;
    private final CoursesRepository courseRepo;


    @Override
    public Integer signup(CreateUserDto dto) {
        if (!"User".equals(dto.getRole()) && !"Admin".equals(dto.getRole()) && !"Teacher".equals(dto.getRole()))
            throw new InvalidRoleException("Invalid role! Enter admin/user/teacher");
        User user = dynamicMapper.convertor(dto, new User());
        if (repository.existsByUserName(user.getUserName())) {
            throw new DuplicateUserNameFoundException("User name  already used.");
        }
        user.setCreated(LocalDate.now());
        isValidPassword(dto.getPassword());
        repository.save(user);
        return 1;
    }
    private void isValidPassword(String password) {
        boolean isValid = true;
        if (password.length() > 15 || password.length() < 8) {
            throw new InvalidPasswordException("Password must be more than 8 characters and less than 20 characters in length.");
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            throw new InvalidPasswordException("Password must have atleast one uppercase character");
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            throw new InvalidPasswordException("Password must have atleast one lowercase character");
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            throw new InvalidPasswordException("Password must have atleast one number");
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars)) {
            throw new InvalidPasswordException("Password must have atleast one special character among @#$%");
        }
    }

    @Override
    public UserDto login(LoginDto dto) throws UserNotFoundException {
        Optional<User> op = repository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword());
        User user = op.orElseThrow(() -> new UserNotFoundException("User Not Found"));

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }
    @Override
    public LoginResponseDto loginUserForResponse(LoginDto dto) {
        User user = repository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword())
                .orElseThrow(() -> new UserNotFoundException("UseName/Password is not valid"));
        return dynamicMapper.convertor(user, new LoginResponseDto());
    }

//    @Override
//    public Integer enrollCourse(Long userId, Long coursesId) {
//        User user = repository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));
//
//        if (user.getRole().equals("admin"))
//            throw new InvalidRoleException("Admin can't enroll course");
//        Courses bookings = courseRepo.findById(coursesId)
//                .orElseThrow(() -> new CourseNotFoundException("Course not Found for " + coursesId + " id"));
//
//        if (user.getCourses().contains(bookings))
//            throw new DuplicateEventException("Course already enrolled...");
//        user.getCourses().add(bookings);
//        repository.save(user);
//        return 1;
//
//    }
    @Override
    public Integer enrollCourse(Long userId, Long courseID) {

        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));

        // if (user.getRole().equals("admin"))
        // throw new InvalidRoleException("Admin can't book Event");
        Courses courses = courseRepo.findById(courseID)
                .orElseThrow(() -> new CourseNotFoundException("Course not Found for " + courseID + " id"));

        if (courses.getUsers().contains(user))
            throw new UserNotFoundException("already enrolled");
        courses.getUsers().add(user);
        courseRepo.save(courses);
        return 1;
    }


    @Override
    public List<UserCoursesDto> getAllEnrollments(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));

        List<UserCoursesDto> collect = user.getCourses()
                .stream()
                .map(enrollement -> dynamicMapper.convertor(enrollement, new UserCoursesDto()))
                .collect(Collectors.toList());
        if (collect.isEmpty())
            throw new CourseNotFoundException("No enrollments found ");

        return collect;
    }

    @Override
    public List<StudentEnrolledDto> getAllStudentEnrolled() {
        List<StudentEnrolledDto> studentEnrolledDtos = new ArrayList<>();
        List<User> users = repository.findAll();
        for (User user : users) {
            for (Courses courses : user.getCourses()) {
                StudentEnrolledDto studentEnrolledDto = new StudentEnrolledDto();

                studentEnrolledDto.setUserName(user.getUserName());
                studentEnrolledDto.setFacultyName(courses.getFacultyName());
                studentEnrolledDto.setCourseName(courses.getCourseName());

                studentEnrolledDtos.add(studentEnrolledDto);
            }
        }
        return studentEnrolledDtos;
    }

    @Override
    public Integer deleteUser(Long userId) throws UserNotFoundException {
        repository.deleteById(userId);
        return 1;
    }

    @Override
    public Integer updateUser(CreateUserDto dto) {
        isUserPresent(dto.getId());
        Long id= dto.getId();
        User user=repository.findById(id).orElseThrow(() -> new CourseNotFoundException("No user found for " + id + " ID"));
        user.setUserName(dto.getUserName());
//        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        repository.save(user);
        return 1;
    }
    private void isUserPresent(Long id) {
        repository.findById(id).orElseThrow(() -> new CourseNotFoundException("No user found for " + id + " ID"));
    }

//    @Override
//    public Integer updateUser(CreateUserDto dto, Long userId) {
//        dto.setId(userId);
//        repository.save(dynamicMapper.convertor(dto, new User()));
//        return 1;
//    }



    //    @Override
//    public List<UserCoursesDto> getCurrentEnrollments(Long userId) {
//        User user = repository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));
//
//        if (user.getRole().equals("admin"))
//            throw new InvalidRoleException("No bookings for Admin");
//
//        LocalDate currentDate = LocalDate.now();
//
//        List<UserCoursesDto> collect = user.getCourses().stream()
//                .filter(enrollment -> enrollment.getEndDate().isAfter(currentDate))
//                .map(enrollment -> dynamicMapper.convertor(enrollment, new UserCoursesDto()))
//                .collect(Collectors.toList());
//
//        if (collect.isEmpty())
//            throw new CourseNotFoundException("No courses found enroll one.");
//
//        return collect;
//    }


    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> listusers = repository.findAll()
                .stream()
                .map(user -> dynamicMapper.convertor(user, new UserDto()))
                .collect(Collectors.toList());
        if (listusers.isEmpty()) {
            throw new UserNotFoundException("no Users present");
        }
        return listusers;
    }
    @Override
    public UserUpdateDto fetchUserDetails(Long userId) throws UserNotFoundException {
        isUserPresent(userId);
        Long id= userId;
        User user=repository.findById(id).orElseThrow(() -> new UserNotFoundException("No user found for " + id + " ID"));
        Optional<User> op = repository.findById(userId);
        return dynamicMapper.convertor(user, new UserUpdateDto());
    }
//    @Override
//    public CoursesDto fetchCourseDetails(Long courseID) throws CourseNotFoundException {
//        Optional<Courses> op = repository.findById(courseID);
//        return mapper.toDto(op.orElseThrow(() -> new CourseNotFoundException("Course " + courseID + " Not Found")));
//    }



}