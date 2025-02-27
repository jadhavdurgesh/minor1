package com.durgesh.minor1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.minor1.exception.TxnException;
import com.durgesh.minor1.request.TxnCreateRequest;
import com.durgesh.minor1.service.TxnService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/txn")
public class TxnController {

    final private TxnService txnService;

    @PostMapping("/create")
    public String createTxn(@RequestBody TxnCreateRequest txnCreateRequest) throws TxnException {
        return txnService.createTxn(txnCreateRequest);
    }
}
