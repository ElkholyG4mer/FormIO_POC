package org.example;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class FormPage {
    private SHAFT.GUI.WebDriver driver ;

    //Constructor
    public FormPage (SHAFT.GUI.WebDriver driver){this.driver = driver ;}

    //Variables
    private String loginPageURL = "https://portal.form.io/#/auth";
    private String formLink = "https://portal.form.io/#/project/6642150eae25b7d59e91a6d7/form/6642150fae25b7d59e91a6fe/edit";

    //Elements
    private By email = By.xpath("//input[@placeholder=\"Email\"]");
    private By password = By.xpath("//input[@placeholder=\"Password\"]");
    private By loginButton = By.xpath("//button[@type=\"submit\"]");
    private By formContainer = By.xpath("//div[@ref=\"-container\"]");
    private By formElementLabel = By.xpath("//input[@name=\"data[label]\"]");
    private By formElementSaveButton = By.xpath("//button[@ref=\"saveButton\"]");

    //Actions
    public FormPage navigateLoginPage(){
        driver.browser().navigateToURL(loginPageURL);
        return this;
    }

    public FormPage navigateFormPage(){
        By pageHeader = By.xpath("//span[contains(text(),'Projects')]");
        driver.element().waitToBeReady(pageHeader);
        //driver.browser().refreshCurrentPage();
        driver.browser().navigateToURL(formLink);
        return this;
    }

    public FormPage login(){
        driver.element().type(email,"mostafa.elkholy.se@gmail.com");
        driver.element().type(password,"Abcd123456@");
        driver.element().click(loginButton);
        return this;
    }

    public FormPage dragAndDropFormElements(String elementName){
        By formElement = By.xpath("//span[@data-type=\""+elementName+"\"]");
        driver.element().dragAndDrop(formElement,formContainer);
        return this;
    }

    public FormPage enterFormElementAttributes(){
        driver.element().type(formElementLabel,"Name");
        driver.element().click(formElementSaveButton);
        return this;
    }
}
