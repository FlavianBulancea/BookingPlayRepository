package com.example.app.service;

import com.example.app.dto.CustomerDto;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.customer.InvalidEmailException;
import com.example.app.exception.customer.NoCustomerFoundException;
import com.example.app.exception.customer.InvalidPhoneNumberException;
import com.example.app.mapper.CustomerMapper;
import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepository;
import com.example.app.util.EmailValidation;
import com.example.app.util.PhoneNumberValidation;
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

    public CustomerDto saveOrUpdate(CustomerDto customerDto) throws InvalidNameException,
            InvalidEmailException, InvalidPhoneNumberException {

        if (!EmailValidation.isTrue(customerDto.getEmail()))
            throw new InvalidEmailException();

        if (customerDto.getFullName().length() == 0)
            throw new InvalidNameException();

        if (!PhoneNumberValidation.isTrue(customerDto.getPhoneNumber()))
            throw new InvalidPhoneNumberException();

        Customer customer = customerRepository.findOneByEmail(customerDto.getEmail());

        if (customer == null)
            customer = customerMapper.dtoToModel(customerDto);
        else {
            customer.setFullName(customerDto.getFullName());
            customer.setPhoneNumber(customerDto.getPhoneNumber());
        }

        customerRepository.save(customer);

        return customerMapper.modelToDto(customer);
    }
}