package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_StorePage {
    //Localizadores de elementos
    public static By ingresarButton = By.xpath("//div[@class='user-info']");
    public static By emailInput = By.id("field-email");
    public static By passwInput = By.id("field-password");
    public static By submitButton = By.id("submit-login");

}
