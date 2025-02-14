package com.Proyecto.ApiBasica.dto;

import lombok.*;

import java.sql.Date;

public class TaskDto {

    private String name;
    private String description;
    private Date dueDate;

    public String getName() {return name;    }

    public String getDescription() {        return description;    }

    public Date getDueDate() {
        return dueDate;
    }
}
