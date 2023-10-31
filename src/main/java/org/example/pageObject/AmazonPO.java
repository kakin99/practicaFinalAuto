package org.example.pageObject;

import org.example.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AmazonPO {

    private Driver driver;
    private int elementosPagina = 16;
    By aceptarCookies = By.xpath("//span[text()='Aceptar cookies']/../input");
    By inputAmazon = By.xpath("//input[@placeholder='Buscar Amazon.es']");
    By botonBusqueda = By.xpath("//input[@id='nav-search-submit-button']");
    By spanPrecio = By.xpath("(//span[@id='taxInclusiveMessage']/../span/descendant::span[@class='a-offscreen'])[1]");
    By spanFecha = By.xpath("//div[contains(@id,'PRIMARY_DELIVERY')]/descendant::*[contains(@class,'bold')]");
    By inputEnvioGratis = By.xpath("//*[contains(@id,'free_shipping_eligible')]/descendant::i");
    By ordenarPor = By.xpath("//select[@name='s']");

    /**
     * Contructor de la clase Amazon Page Object
     * @param driver -> elemento de la clase propia Driver con el driver del navegador
     */
    public AmazonPO(Driver driver){
        this.driver = driver;
    }

    /**
     * Metodo para hacer click en Aceptar las cookies
     */
    public void clickCookies(){
        driver.encuentraXpath(aceptarCookies).click();
    }

    /**
     * Metodo para realizar una busqueda dentro de Amazon
     * @param texto -> elemento String a buscar
     * @throws InterruptedException -> excepción para la espera
     */
    public void buscador(String texto) throws InterruptedException {
        driver.encuentraXpath(inputAmazon).sendKeys(texto);
        driver.encuentraXpath(botonBusqueda).submit();
        driver.espera(2000);
    }

    /**
     * Metodo para motrar los datos del producto en la pagina actual
     * @throws InterruptedException -> excepción para la espera
     */
    public void mostrarDatosAmazon() throws InterruptedException {
        driver.espera(1000);
        System.out.println("Precio: "+driver.encuentraXpath(spanPrecio).getText() + ", Fecha de entrega: " + driver.encuentraXpath(spanFecha).getText());
    }

    /**
     * Metodo para marcar el envio gratis en la busqueda de Amazon
     * @throws InterruptedException -> excepción para la espera
     */
    public void envioGratis() throws InterruptedException {
        driver.encuentraXpath(inputEnvioGratis).click();
        driver.espera(1000);
    }

    /**
     * Metodo para clickar en ordenar los elementos de la busqueda de menor a mayor
     * @throws InterruptedException -> excepción para la espera
     */
    public void ordenarDatos() throws InterruptedException {
        Select orden = new Select(driver.encuentraXpath(ordenarPor));
        orden.selectByValue("price-asc-rank");
        driver.espera(2000);
    }

    /**
     * Metodo para mostrar los elementos de la busqueda por pantalla
     */
    public void mostrarDatosBusqueda(){
        String nodo = "(//div[contains(@data-asin,'B0')])";
        String nombre = "/descendant::h2/a/span";
        String precio = "/descendant::div[contains(@class,'puis-price-instructions')]/descendant::span[contains(@class,'a-price')]/span[contains(@class,'a-offscreen')";
        for(int i=1;i<=elementosPagina;i++){
            System.out.println("Nombre: "+ driver.encuentraXpath(By.xpath(nodo + "[" + i + "]" + nombre)).getText() + ", Precio: " + driver.encuentraXpath(By.xpath(nodo + "[" + i + "]" + precio)).getText());
        }
    }

}
