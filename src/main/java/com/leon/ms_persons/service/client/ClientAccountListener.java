package com.leon.ms_persons.service.client;

import com.leon.ms_persons.domain.dto.request.AccountMovementEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Service
public class ClientAccountListener {
    @Bean
    public Consumer<AccountMovementEvent> inputChannel() {
        return event -> {
            // Handle the event (e.g., update account balance)
            System.out.println("Received event: " + event.getAccountId() + " with new balance: " + event.getNewBalance());
        };
    }
}
