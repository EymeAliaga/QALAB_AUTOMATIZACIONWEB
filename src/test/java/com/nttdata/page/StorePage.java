package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {

    public static By Categoria =By.xpath("//li[@id='category-3']");
    public static By SubCategoria =By.xpath("//li[@data-depth='0']");
    public static By tituloSubCategoria = By.cssSelector("h1.h1");
    public static By productos =By.cssSelector("div.products row");
    public static By producto1= By.xpath("//div[@class='js-product product col-xs-12 col-sm-6 col-xl-4']");
    public static By agregarcantidad= By.xpath("//i[@class='material-icons touchspin-up']");
    public static By agregar =By.xpath("//button[@type='submit']");
    public static By popUp = By.xpath("//h4[@class='modal-title h6 text-sm-center']");
    public static By precioUnitario =By.xpath("//p[@class='product-price']");
    public static By cantidad=By.xpath("//span[@class='product-quantity']");
    public static By costo =By.xpath("//span[@class='value']");
    public static By finalizarCompra =By.xpath("//a[@class='btn btn-primary']");
    public static By tituloCarrito=By.cssSelector("h1.h1");
    public static By totalCarritoSinImp=By.xpath("//div[@class='cart-summary-line']");
    public static By totalCarritoConImp=By.xpath("//div[@class='cart-summary-line-total']");

}
