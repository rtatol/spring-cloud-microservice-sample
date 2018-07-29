package com.reportservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
class AccountsResource {
    @JsonProperty("_embedded")
    private final EmbeddedAccounts embedded;
}

@Value
class EmbeddedAccounts {
    private final List<Account> accounts;
}

@Value
class Account {
    private final String firstName;
    private final String lastName;
}