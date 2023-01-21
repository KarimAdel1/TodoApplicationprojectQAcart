package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoPage extends BasePage {

    public ToDoPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMassage ;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton ;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement TodoItem ;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement DeleteItem ;


    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement NoToDoItem ;

    @Step
     public ToDoPage load(){

        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.TODO_ENDPOINT);
        return this;
    }
    @Step
    public boolean isWelcomeMassageDisplayed(){
         return  welcomeMassage.isDisplayed();
    }
    public NewTodoPage clickOnPlusButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String getTodoItemText(){
       return TodoItem.getText();
    }
    @Step
    public ToDoPage clickOnDeleteButton()
    {
         DeleteItem.click();
         return this;
    }
    @Step
    public boolean NoToDoItemIsDisplayed(){
       return  NoToDoItem.isDisplayed();
    }

}

