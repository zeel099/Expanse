package com.expanse.service;

import com.expanse.ExpanseApplication;
import com.expanse.payload.ExpanseDto;

public interface ExpanseService {
    ExpanseDto createExpanse(ExpanseDto expanseDto);
    ExpanseDto getExpanseById(Integer expanseId);

    ExpanseDto updateExpanse(ExpanseDto expanseDto,Integer expanseId);

}
