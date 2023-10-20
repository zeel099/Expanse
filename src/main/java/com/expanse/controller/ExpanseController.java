package com.expanse.controller;

import com.expanse.payload.ExpanseDto;
import com.expanse.service.ExpanseService;
import com.expanse.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ExpanseController {

    @Autowired
    private ExpanseService expanseService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/expanse")
    public ResponseEntity<ExpanseDto> createPost(@RequestBody ExpanseDto expanseDto){
        ExpanseDto createExpanse = this.expanseService.createExpanse(expanseDto);
        return new ResponseEntity<ExpanseDto>(createExpanse, HttpStatus.CREATED);
    }

    @PostMapping("/expanse/{expanseId}")
    public ResponseEntity<ExpanseDto>uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable Integer expanseId) throws IOException {

        ExpanseDto expanseDto = this.expanseService.getExpanseById(expanseId);
        String fileName = this.fileService.uploadImage(path, file);

        expanseDto.setFileName(fileName);
        ExpanseDto updateExpnase = this.expanseService.updateExpanse(expanseDto, expanseId);
        return new ResponseEntity<ExpanseDto>(updateExpnase,HttpStatus.OK);
    }
}
