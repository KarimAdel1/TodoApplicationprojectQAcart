package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.ToDoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test (description = "Should be able to add new TODO Correctly")
    public void ShouldBeAbleToAddNewTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        String actualResult = newTodoPage
                        .load()
                        .AddNewTodo("Learn Selenium")
                        .getTodoItemText();

        Assert.assertEquals(actualResult,"Learn Selenium");

    }

    @Story(" Delete Add Todo")
    @Test(description = "Should be able to delete a Todo Correctly")
    public void ShouldBeAbleToDeleteTodo() {
        RegisterApi registerApi =new RegisterApi();
        registerApi.register();

        TasksApi tasksApi =new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        ToDoPage toDoPage= new ToDoPage(getDriver());
        toDoPage.load();

        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        boolean NoToDoMassageIsDisplayed = toDoPage
                        .load()
                        .clickOnDeleteButton()
                        .clickOnDeleteButton()
                        .NoToDoItemIsDisplayed();

        Assert.assertTrue(NoToDoMassageIsDisplayed);

    }
}