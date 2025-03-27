package com.example.Traini8.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Traini8.Entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,String>{

}
