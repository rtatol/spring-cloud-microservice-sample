package com.accountservice;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}

@Data
@Entity(name = "_account")
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 64, nullable = false)
    private String firstName;

    @Column(length = 64, nullable = false)
    private String lastName;
}

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findByLastName(@Param("lastName") String lastName);
}
