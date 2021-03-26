package api.gateway;

import api.gateway.jpa.entity.User;
import api.gateway.jpa.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

//    private final User newUser;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User newUser = new User();
        newUser.setUsername("hwang");
        newUser.setPassword(passwordEncoder.encode("gm"));
        newUser.setUserType(0);
        newUser.setDate(new Date());
        userRepo.save(newUser);

    }
}