package com.example.app.service;

import com.example.app.dto.CustomerDto;
import com.example.app.exception.customer.NoCustomerFoundException;
import com.example.app.mapper.CustomerMapper;
import com.example.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerDto> getAll() throws NoCustomerFoundException {

        List<CustomerDto> customerDtos = customerRepository.findAll().stream()
                .map(customer -> customerMapper.modelToDto(customer))
                .collect(Collectors.toList());

        if (customerDtos.size() == 0)
            throw new NoCustomerFoundException();

        return customerDtos;
    }
}