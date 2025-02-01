package com.durgesh.minor1.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Txn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String txnId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int paidAmount;

    @CreationTimestamp
    private Date createOn;

    @UpdateTimestamp
    private Date updateOn;

    @Enumerated(EnumType.STRING)
    private TxnStatus txnStatus;

}
