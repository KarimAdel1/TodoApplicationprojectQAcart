package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login With Email and Password")
    @Description ("it will Logging by filling email and password")
    @Test(description = "Test the Login Functionality using email and password")
     public void shouldBeAbleToLoginWithEmailAndPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        boolean IsDisPlayedWelcome =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMassageDisplayed();


        Assert.assertTrue(IsDisPlayedWelcome);

    }
}
