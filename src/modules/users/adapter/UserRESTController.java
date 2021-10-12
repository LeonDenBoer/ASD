package modules.users.adapter;

public class UserRESTController {

    public boolean validateUserMaySubmitReport(String userId) {
        return !userId.isBlank();   // Validates every userId as valid if it contains some value.
    }

}
