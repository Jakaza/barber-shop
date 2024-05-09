package tut.ac.za.barbershop.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

public class BookingDto {


    @NotBlank(message = "Please provide your name")
    private String name;

    @NotBlank(message = "Please provide your contact information")
    @Pattern(regexp = "^0\\d{9}$", message = "Contacts must start with '0' and have exactly 10 numbers")
    private String contacts;

    @NotNull(message = "Time cannot be null , please select time")
    @DateTimeFormat(pattern = "HH:mm")
    private String time;

    @NotNull(message = "Date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotBlank(message = "Please select a branch")
    private String branch;

    @NotBlank(message = "Please select a hair style")
    private String style;

    private String status;



    // Getters and setters


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public @NotBlank(message = "Please provide your name") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Please provide your name") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Please provide your contact information") @Pattern(regexp = "^0\\d{9}$", message = "Contacts must start with '0' and have exactly 10 numbers") String getContacts() {
        return contacts;
    }

    public void setContacts(@NotBlank(message = "Please provide your contact information") @Pattern(regexp = "^0\\d{9}$", message = "Contacts must start with '0' and have exactly 10 numbers") String contacts) {
        this.contacts = contacts;
    }

    public @NotNull(message = "Time cannot be null , please select time") String getTime() {
        return time;
    }

    public void setTime(@NotNull(message = "Please select a time") String time) {
        this.time = time;
    }

    public @NotNull(message = "Please select a date") Date getDate() {
        return date;
    }

    public void setDate(@NotNull(message = "Please select a date") Date date) {
        this.date = date;
    }

    public @NotBlank(message = "Please select a branch") String getBranch() {
        return branch;
    }

    public void setBranch(@NotBlank(message = "Please select a branch") String branch) {
        this.branch = branch;
    }

    public @NotBlank(message = "Please select a hair style") String getStyle() {
        return style;
    }

    public void setStyle(@NotBlank(message = "Please select a hair style") String style) {
        this.style = style;
    }



    @Override
    public String toString() {
        return "BookingDto{" +
                "name='" + name + '\'' +
                ", contacts='" + contacts + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", branch='" + branch + '\'' +
                ", style='" + style + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
