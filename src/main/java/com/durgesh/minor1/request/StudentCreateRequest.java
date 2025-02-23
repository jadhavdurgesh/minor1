package com.durgesh.minor1.request;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.durgesh.minor1.model.Student;
import com.durgesh.minor1.model.StudentType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {
    private String name;

    private String email;

    private String phoneNo;

    private String address;

    public Student toStudent() {
        return Student.builder().name(this.name).email(this.email).phoneNo(this.phoneNo).address(this.address)
                .status(StudentType.ACTIVE).build();
    }
}
