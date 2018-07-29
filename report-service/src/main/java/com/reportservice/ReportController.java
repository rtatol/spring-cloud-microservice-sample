package com.reportservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class ReportController {

    private final AccountServiceProxy accountServiceProxy;

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<byte[]> report() throws Exception {

        final AccountsResource accounts = accountServiceProxy.fetchAccounts(0, 100);

        final byte[] report = ReportFactory.from(accounts).create();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    }
}
