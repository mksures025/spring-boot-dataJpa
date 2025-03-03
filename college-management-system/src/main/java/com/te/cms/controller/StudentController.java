package com.te.cms.controller;

import com.te.cms.dto.AddressDTO;
import com.te.cms.dto.DepartmentDTO;
import com.te.cms.dto.StudentRegisterDTO;
import com.te.cms.entity.AddressType;
import com.te.cms.response.SuccessResponse;
import com.te.cms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "getRegister")
    public StudentRegisterDTO getRegister() {

        return StudentRegisterDTO.builder().studentId("").studentName("").studentName("")
                .address(List.of(AddressDTO.builder().city("").state("").addressType(AddressType.PERMANENT)
                        .addressType(AddressType.TEMPORARY).build()))
                .department(DepartmentDTO.builder().DeptName("").build()).build();
    }

    @PostMapping(path = "save")
    public ResponseEntity<SuccessResponse> SaveStudent(@RequestBody StudentRegisterDTO studentRegisterDTO) {

        String studentId = studentService.saveData(studentRegisterDTO);
        return ResponseEntity.ok().body(SuccessResponse.builder().message("Data saved").data(studentId)
                .status(HttpStatus.OK).timestamp(LocalDateTime.now()).build());
    }

    //update operations

    @PutMapping(path = "updatename")
    public ResponseEntity<SuccessResponse> updateStudent(@RequestBody StudentRegisterDTO studentRegisterDTO) {

        String studentName = studentService.updateStudentName(studentRegisterDTO);
        return ResponseEntity.ok().body(SuccessResponse.builder().message("Data Updated successful").data(studentName)
                .status(HttpStatus.OK).timestamp(LocalDateTime.now()).build());
    }

    //update data using dto

    @PutMapping(path = "update")
    public ResponseEntity<SuccessResponse> update(@RequestBody StudentRegisterDTO studentRegisterDTO) {

        String studentName = studentService.updateStudenrt(studentRegisterDTO);
        return ResponseEntity.ok().body(SuccessResponse.builder().message("Data Updated successful").data(studentName)
                .status(HttpStatus.OK).timestamp(LocalDateTime.now()).build());
    }


    // fetch data using studentid
    @GetMapping(path = "{studentid}")
    public ResponseEntity<SuccessResponse> fetchById(@PathVariable String studentid) {

        StudentRegisterDTO studentRegisterDTO = studentService.fetchById(studentid);


        return ResponseEntity.ok().body(SuccessResponse.builder()
                .message("Student data by id")
                .data(studentRegisterDTO)
                .status(HttpStatus.OK)
                .build());

    }

    // to fetch all the student detail from the table

    @GetMapping(path = "fethcstudent")
    public ResponseEntity<SuccessResponse> fetchstudent() {

        List<StudentRegisterDTO> studentRegisterDTO = studentService.fetchStudent();


        return ResponseEntity.ok().body(SuccessResponse.builder()
                .message("Student data")
                .data(studentRegisterDTO)
                .status(HttpStatus.OK)
                .build());

    }

    // Using Query Methods
    // fetch the all student detail by name
    @GetMapping(path = "fetchname")
    public ResponseEntity<SuccessResponse> fetchByName() {

        List<StudentRegisterDTO> studentRegisterDTO = studentService.fetchByName();


        return ResponseEntity.ok().body(SuccessResponse.builder()
                .message("Student data")
                .data(studentRegisterDTO)
                .status(HttpStatus.OK)
                .build());

    }

    @GetMapping(path = "fetchaddress")
    public ResponseEntity<SuccessResponse> fetchaddress() {

        //List<StudentRegisterDTO> studentDto =studentService.fetchByAddress();
        List<AddressDTO> addressDTO = studentService.fetchByAddress();


        return ResponseEntity.ok().body(SuccessResponse.builder()
                .message("Student data based on address")
                .data(addressDTO)
                .status(HttpStatus.OK)
                .build());

    }


}
