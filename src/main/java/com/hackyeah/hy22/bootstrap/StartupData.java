package com.hackyeah.hy22.bootstrap;

import com.hackyeah.hy22.repositories.DummyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupData implements CommandLineRunner {

    private final DummyRepo dummyRepo;

    @Override
    public void run(String... args) throws Exception {

    }
}
