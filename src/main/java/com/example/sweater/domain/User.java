package com.example.sweater.domain;

import javax.persistence.*;
//import jakarta.persistence.*;
import javax.validation.constraints.*;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "usr")
public class User {
    @Id
    private String id;
    public User () {
        this.id=String.valueOf(GetUUID.generateType1UUID());
    }
    @NotEmpty(message = "The first name cannot be empty")
    @Size(min = 3, message = "The first name field must greater the 3 characters")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "The last name cannot be empty")
    @Size(min = 3, message = "The first name field must greater the 3 characters")
    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotEmpty(message = "The email cannot be empty")
    @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})",
            message = "Please Insert a Valid Email")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Please provide a gender")
    @Column(name = "gender")
    @Size(min = 1, message = "The gender must be greater than 1 character")
    private String gender;

    @NotNull(message = "Date of birth cannot be empty")
    @Column(name = "data_of_birth")
//    @Pattern(regexp = "^\\\\d{4}-\\\\d{2}-\\\\d{2}$", message = "The date must have this format yyyy-mm-dd")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "The password cannot be empty")
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$" , message = "Password must contain " +
            "1 Uppercase letter, 1 lowercase letter, 1 special character, 1 number and must be at least 8 characters")
    @Column(name = "password")
    private String password;
    private boolean active;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
