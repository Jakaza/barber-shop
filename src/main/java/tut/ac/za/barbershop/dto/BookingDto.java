package tut.ac.za.barbershop.dto;

import jakarta.validation.constraints.*;

import java.sql.Time;
import java.util.Date;

public class BookingDto {
    private String name;

    @NotBlank(message = "Contacts cannot be blank")
    private String contacts;

    @NotNull(message = "Time cannot be null")
    private Time time;

    @NotNull(message = "Date cannot be null")
    private Date date;

    @Min(value = 1, message = "Number of people must be at least 1")
    private Integer numPeople;

    @NotBlank(message = "Branch cannot be blank")
    private String branch;

    @NotBlank(message = "Style cannot be blank")
    private String style;

    @NotBlank(message = "Style cannot be blank")
    private String status;

    // Getters and setters

}
