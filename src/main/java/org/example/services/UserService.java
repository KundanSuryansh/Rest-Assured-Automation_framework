package org.example.services;

import io.restassured.response.Response;
import org.example.base.BaseService;
import org.example.constants.Urls;
import org.example.modals.request.UserLogin;
import org.example.modals.request.UserRegister;
import org.example.modals.response.common.ErrorResponse;
import org.example.modals.response.userloginresponse.UserLoginResponse;
import org.example.modals.response.userregisterreponse.UserRegisterResponse;

public class UserService extends BaseService {

    public Object createUser(UserRegister userRegister){

        Response response = post(userRegister, Urls.User.USERS_REGISTER);

        return handleResponse(response, UserRegisterResponse.class, ErrorResponse.class);

    }

    public Object login(UserLogin userLogin){

        Response response = post(userLogin,Urls.User.USERS_LOGIN);

        return handleResponse(response, UserLoginResponse.class,ErrorResponse.class);
    }

}
