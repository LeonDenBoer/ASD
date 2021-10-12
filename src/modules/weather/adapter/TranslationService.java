package modules.weather.adapter;

import modules.users.adapter.UserRESTController;

public class TranslationService {

    UserRESTController userRESTController = new UserRESTController();

    public TranslationService() {

    }

    public boolean validateUserMaySubmitReport(String userId) {
        return userRESTController.validateUserMaySubmitReport(userId);
    }

}
