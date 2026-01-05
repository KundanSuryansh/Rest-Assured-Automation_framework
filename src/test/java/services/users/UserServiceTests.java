package services.users;

import base.BaseTests;
import data.userServiceDataProvider;
import org.example.modals.request.UserLogin;
import org.example.services.AuthService;
import org.example.utility.TokenManager;
import org.testng.annotations.Test;

public class UserServiceTests extends BaseTests {


    @Test(dataProvider = "loginUsers", dataProviderClass = userServiceDataProvider.class)
    public void testUserLogin(UserLogin userLogin){
        new AuthService().loginAndGetToken(userLogin.getEmail(), userLogin.getPassword());
        System.out.println(TokenManager.getToken(userLogin.getEmail()));
    }
}
