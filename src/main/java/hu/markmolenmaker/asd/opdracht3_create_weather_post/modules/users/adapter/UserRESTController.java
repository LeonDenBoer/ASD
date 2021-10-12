package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.users.adapter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {

    public boolean validateUserMaySubmitReport(String userId) {
        return !userId.isBlank();   // Validates every userId as valid if it contains some value.
    }

}
