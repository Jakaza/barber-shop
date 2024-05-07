package tut.ac.za.barbershop.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerDto {
    @NotBlank(message = "Firstname cannot be blank")
    private String firstname;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    // Getters and setters

    public @NotBlank(message = "Firstname cannot be blank") String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank(message = "Firstname cannot be blank") String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank(message = "Surname cannot be blank") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Surname cannot be blank") String surname) {
        this.surname = surname;
    }

    public @Email(message = "Invalid email address") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email address") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Gender cannot be blank") String getGender() {
        return gender;
    }

    public void setGender(@NotBlank(message = "Gender cannot be blank") String gender) {
        this.gender = gender;
    }

    public @NotNull(message = "Age cannot be null") @Min(value = 18, message = "Age must be at least 18") Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "Age cannot be null") @Min(value = 18, message = "Age must be at least 18") Integer age) {
        this.age = age;
    }

    public @NotBlank(message = "Password cannot be blank") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be blank") String password) {
        this.password = password;
    }
}
