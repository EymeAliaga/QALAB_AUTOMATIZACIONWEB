package com.nttdata.stepsdefinitions;

import com.nttdata.steps.Login_StoreSteps;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class Login_StoreStepsDef {
    private WebDriver driver;

    private StoreSteps storeSteps(WebDriver driver){
        return new StoreSteps(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver =getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi usuario: {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String passw) {
        Login_StoreSteps loginStoreSteps = new Login_StoreSteps(driver);
        loginStoreSteps.ingresarUsuario();
        loginStoreSteps.typeEmail(email);
        loginStoreSteps.typePassw(passw);
        loginStoreSteps.ingresar();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String CLOTHES, String MEN) {
        storeSteps(driver).IngresarCategoria();
        storeSteps(driver).IngresarSubCategoria();
        String Subcategoria =storeSteps(driver).getSubcategoria();
       Assertions.assertEquals("MEN",Subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cant) {
      // int ListaProductos = storeSteps(driver).getProductos();

        storeSteps(driver).SeleccionarProducto();
        storeSteps(driver).IngresarProducto(2);
        storeSteps(driver).AgregarCantidad();
        screenShot();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        String mensaje =storeSteps(driver).getpopUp();
       Assertions.assertEquals("Producto añadido correctamente a su carrito de compra",mensaje);
       screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
       //precio unitario por cantidad
        double Cant = 19.12 *2;

        Assertions.assertEquals(String.valueOf(Cant), storeSteps(driver).CostoTotal());
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        storeSteps(driver).FinalizarCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String Msj=storeSteps(driver).getTituloCarrito();
        Assertions.assertEquals("Carrito",Msj);
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        double Cant = 19.12 *2;
        Assertions.assertEquals(String.valueOf(Cant), storeSteps(driver).TotalCarrito());
        screenShot();
    }
}
