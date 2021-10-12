package hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.weather.adapter;

import hu.markmolenmaker.asd.opdracht3_create_weather_post.modules.users.adapter.UserRESTController;

public class TranslationService {

    UserRESTController userRESTController = new UserRESTController();

    public TranslationService() {

    }

    public boolean validateUserMaySubmitReport(String userId) {
        return userRESTController.validateUserMaySubmitReport(userId);
    }

}
