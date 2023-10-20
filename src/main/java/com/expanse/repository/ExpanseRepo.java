package com.expanse.repository;

import com.expanse.entity.Expanse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpanseRepo extends JpaRepository<Expanse,Integer> {

}
