package com.expanse.service.impl;

import com.expanse.entity.Expanse;
import com.expanse.exception.ResourceNotFoundException;
import com.expanse.payload.ExpanseDto;
import com.expanse.repository.ExpanseRepo;
import com.expanse.service.ExpanseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpanseServiceImpl implements ExpanseService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ExpanseRepo expanseRepo;
    @Override
    public ExpanseDto createExpanse(ExpanseDto expanseDto) {
        Expanse expanse = this.modelMapper.map(expanseDto,Expanse.class);

        Expanse newExpanse = this.expanseRepo.save(expanse);
        return this.modelMapper.map(newExpanse,ExpanseDto.class);

    }

    @Override
    public ExpanseDto getExpanseById(Integer expanseId) {
        Expanse post = this.expanseRepo.findById(expanseId)
                .orElseThrow(()->new ResourceNotFoundException("Post","post id",expanseId));
        return this.modelMapper.map(post,ExpanseDto.class);
    }

    @Override
    public ExpanseDto updateExpanse(ExpanseDto expanseDto, Integer expanseId) {
        Expanse expanse = this.expanseRepo.findById(expanseId).orElseThrow(()->new ResourceNotFoundException("Post","post id",expanseId));

        expanse.setFoodExpanse(expanseDto.getFoodExpanse());
        expanse.setOtherExpanse(expanseDto.getOtherExpanse());
        expanse.setTravelExpanse(expanseDto.getTravelExpanse());
        expanse.setFileName(expanseDto.getFileName());

        Expanse updatedExpanse = this.expanseRepo.save(expanse);
        return this.modelMapper.map(updatedExpanse, ExpanseDto.class);
    }
}
