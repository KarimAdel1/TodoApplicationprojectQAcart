package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TasksApi {

    public void addTask (String token){
        Task task = new Task("Learn Selenium", false);
       Response response =
       given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token)
       .when()
                .post(EndPoint.API_TASK_ENDPOINT)
       .then()
                .log().all().extract().response();


            if (response.statusCode() != 201 ){
                throw  new RuntimeException( "SomeThing Went wrong While Adding Todo");
            }

    }
}
