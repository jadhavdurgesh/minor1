package com.durgesh.minor1.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.durgesh.minor1.exception.TxnException;
import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.model.FilterType;
import com.durgesh.minor1.model.Operator;
import com.durgesh.minor1.model.Student;
import com.durgesh.minor1.model.StudentFilterType;
import com.durgesh.minor1.model.Txn;
import com.durgesh.minor1.model.TxnStatus;
import com.durgesh.minor1.repository.TxnRepository;
import com.durgesh.minor1.request.TxnCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TxnService {

    private final TxnRepository txnRepository;
    private final BookService bookService;
    private final StudentService studentService;

    public String createTxn(TxnCreateRequest txnCreateRequest) throws TxnException {
        List<Student> studentList = studentService.filter(StudentFilterType.CONTACT, Operator.EQUALS,
                txnCreateRequest.getStudentContact());

        if (studentList == null || studentList.isEmpty()) {
            throw new TxnException("Student not found");
        }

        List<Book> bookList = bookService.filter(FilterType.BOOK_NO, Operator.EQUALS,
                txnCreateRequest.getBookNo());

        if (bookList == null || bookList.isEmpty()) {
            throw new TxnException("Book not found");
        }

        Book bookFromLib = bookList.get(0);

        if (bookFromLib.getStudent() != null) {
            throw new TxnException("Book already issued to someone");
        }

        String txnID = UUID.randomUUID().toString();
        Txn txn = Txn.builder().book(bookFromLib).student(studentList.get(0))
                .txnid(txnID).status(TxnStatus.ISSUED)
                .build();
        return txnRepository.save(txn).getTxnid();
    }

}
