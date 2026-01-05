package org.example.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.base.BaseService;
import org.example.constants.Urls;
import org.example.exceptions.TokenNotFoundException;
import org.example.modals.request.UserLogin;
import org.example.modals.response.common.ErrorResponse;
import org.example.modals.response.userloginresponse.UserLoginResponse;
import org.example.utility.TokenManager;

public class AuthService extends BaseService {

    public String loginAndGetToken(String username, String password) {

        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(username);
        userLogin.setPassword(password);

        Response response = post(userLogin, Urls.User.USERS_LOGIN);

        Object object = handleResponse(response, UserLoginResponse.class, ErrorResponse.class);
        String token = "";

        if(object instanceof UserLoginResponse userLoginResponse){
            token = userLoginResponse.getData().getToken();
            TokenManager.setToken(username,token);
        } else {
            ErrorResponse errorResponse = (ErrorResponse) object;
            throw new TokenNotFoundException(errorResponse,response.getStatusCode());
        }

        return token;
    }

}
