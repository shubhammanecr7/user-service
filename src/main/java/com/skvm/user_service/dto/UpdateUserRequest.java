package com.skvm.user_service.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest {
    @Size(min = 1, message = "First name must not be empty")
    private String firstName;
    @Size(min = 1, message = "Last name must not be empty")
    private String lastName;
    @Min(value = 1, message = "Age must be greater than 0")
    private Integer age;

    public UpdateUserRequest(){
    }

    public UpdateUserRequest(String firstName,String lastName,Integer age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}