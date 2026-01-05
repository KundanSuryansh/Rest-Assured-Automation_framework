package data;

import org.example.modals.request.UserLogin;
import org.example.utility.TestDataUtils;
import org.testng.annotations.DataProvider;

import java.util.List;

public class userServiceDataProvider {


    @DataProvider(name="loginUsers")
    public Object[][] getLoginUserData(){
        List<UserLogin> userLoginList = TestDataUtils.getTestDataAsList("validUsers.json", UserLogin.class);
        Object[][] object = new Object[userLoginList.size()][1];

        for(int i=0;i<userLoginList.size();i++){
            object[i][0] = userLoginList.get(i);
        }

        return object;
    }
}
