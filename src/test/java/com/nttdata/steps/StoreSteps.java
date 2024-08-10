package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v107.runtime.model.WebDriverValue;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.jws.WebParam;
import java.time.Duration;

public class StoreSteps {
    private WebDriver driver;
    public StoreSteps(WebDriver driver) {
        this.driver = driver;
    }

   public  void IngresarCategoria(){
        this.driver.findElement(StorePage.Categoria).click();
        Assertions.assertEquals("CLOTHES",this.driver.findElement(StorePage.Categoria).getText());
   }
   public  void IngresarSubCategoria(){
        this.driver.findElement(StorePage.SubCategoria).click();

   }

    public String getSubcategoria(){
       return this.driver.findElement(StorePage.tituloSubCategoria).getText();

    }
//    public int getProductos(){
    //    List<WebElement> elementos = this.driver.findElements(StorePage.productos);
     //   return elementos.size();
  //  }

    public void SeleccionarProducto(){
        this.driver.findElement(StorePage.producto1).click();
    }
    public void IngresarProducto(int cant){
        //si se quisieran más productos se puede agregar un for (según mi lógica)

     // String c=Integer.toString(cant);
     //WebElement CantidadElementos = this.driver.findElement(StorePage.cantidad);
     //CantidadElementos.sendKeys(c);
       this.driver.findElement(StorePage.cantidad).click();
    }
    public void AgregarCantidad(){
        this.driver.findElement(StorePage.agregar).click();


    }
    public String getpopUp(){
        return this.driver.findElement(StorePage.popUp).getText();
    }
    public String CostoTotal(){
       // this.driver.findElement(StorePage.precioUnitario).getText();
       // this.driver.findElement(StorePage.cantidad).getText();
        return this.driver.findElement(StorePage.costo).getText();

    }
    public void FinalizarCompra(){
        this.driver.findElement(StorePage.finalizarCompra).click();
    }
    public String getTituloCarrito(){
        return this.driver.findElement(StorePage.tituloCarrito).getText();
    }
    public String TotalCarrito(){
        //this.driver.findElement(StorePage.totalCarritoSinImp).getText();
      return
              this.driver.findElement(StorePage.totalCarritoConImp).getText();
    }



}
