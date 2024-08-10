package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.Login_StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_StoreSteps {
      private WebDriver driver;
      public Login_StoreSteps(WebDriver driver) {
          this.driver = driver;
      }
      public void ingresarUsuario(){
          this.driver.findElement(Login_StorePage.ingresarButton).click();
      }

      public void typeEmail(String email){
          WebElement emailInputElement = driver.findElement(Login_StorePage.emailInput);
          emailInputElement.sendKeys(email);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
          wait.until(ExpectedConditions.visibilityOfElementLocated(Login_StorePage.submitButton));

      }
      public void typePassw(String passw){
          this.driver.findElement(Login_StorePage.passwInput).sendKeys(passw);
      }
      public void ingresar(){
          this.driver.findElement(Login_StorePage.submitButton).click();
      }
}
