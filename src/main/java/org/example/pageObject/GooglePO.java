package org.example.pageObject;

import org.example.driver.Driver;
import org.openqa.selenium.By;

public class GooglePO {

    private String url = "https://www.google.es/";
    private Driver driver;
    private String busqueda;
    By boton = By.xpath("//div[text()='Aceptar todo']");
    By buscarGoogle = By.xpath("//textarea[@title='Buscar']");
    By clickBuscarGoogle = By.xpath("//input[@value='Buscar con Google']");

    /**
     * Contructor clase Google Page Object
     * @param driver -> elemento de la clase propia Driver con el driver del navegador
     */
    public GooglePO(Driver driver){
        this.driver = driver;
    }

    /**
     * Metodo para ir a la url de Google y maximizar la ventana de la ejecución
     */
    public void irGoogle(){
        driver.visitarUrl(url);
        driver.maximizar();
    }

    /**
     * Metodo para hacer click en Aceptar las Cookies de Google
     */
    public void clickAceptarCookies(){
        driver.encuentraXpath(boton).click();
    }

    /**
     * Metodo para realizar busquedas en Google
     * @param bus -> elemento String con el valor a buscar
     */
    public void buscar(String bus) throws InterruptedException {
        busqueda = bus;
        driver.encuentraXpath(buscarGoogle).sendKeys(bus);
        driver.encuentraXpath(clickBuscarGoogle).submit();
        driver.espera(2000);
    }

    /**
     * Metodo para hacer click en el enlace hacia la pagina de Amazon sobre el producto en concreto
     */
    public void clickAmazon(){
        String xpath = "//span[contains(text(),'Amazon']/ancestor::div/../h3[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+ busqueda +"')]";
        driver.encuentraXpath(By.xpath(xpath)).click();
    }

}
