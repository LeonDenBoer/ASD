package modules.weather.domain.report;

import modules.users.adapter.UserRESTController;

public class WeatherReport {

    private UserRESTController userRESTController = new UserRESTController();

    public WeatherReport(String identity, String details, String picture, String userId) {
        boolean isValid = userRESTController.validateUserMaySubmitReport(userId);
        if (!isValid) return;

        WeatherData data = WeatherData.parseDetails(details);
    }

}
