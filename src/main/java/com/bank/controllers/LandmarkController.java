package com.bank.controllers;

import com.bank.dto.LandmarkDTO;
import com.bank.models.Landmark;
import com.bank.service.LandmarkService;
import com.bank.utils.mappers.impl.LandmarkMapper;
import com.bank.validators.LandmarkDTOValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/landmarks")
@RequiredArgsConstructor
public class LandmarkController extends MainController{

    private final LandmarkService landmarkService;
    private final LandmarkMapper landmarkMapper;
    private final LandmarkDTOValidator landmarkDTOValidator;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(landmarkMapper.toDTOs(landmarkService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{landmark_id}")
    public ResponseEntity<Object> getById(
            @PathVariable("landmark_id") Long id){
        return new ResponseEntity<>(landmarkMapper.toDTO(landmarkService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createNewLandmark(@RequestBody LandmarkDTO landmarkDTO, BindingResult bindingResult){
        landmarkDTOValidator.validate(landmarkDTO, bindingResult);
        checkBindingResult(bindingResult);
        Landmark landmark = landmarkMapper.fromDTO(landmarkDTO);
        //landmarkService.save() TODO
        return null;
    }
}
