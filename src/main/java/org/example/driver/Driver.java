package org.example.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private String rutaDriver = "D:/Documentos/WebDrivers/chromedriver.exe";
    private WebDriver driver;

    /**
     * Contructor de la clase, se podria implementar una carga dinamica del navegador, pero no lo he contemplado para este ejercicio.
     * Se carga el driver del navegador.
     */
    public Driver (){
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();
    }

    /**
     * Metodo para maximizar la pagina de la ejecucion
     */
    public void maximizar(){
        driver.manage().window().maximize();
    }

    /**
     * Metodo para ir a una url
     * @param url -> elemento String que llevara la url a cargar
     */
    public void visitarUrl(String url){
        driver.get(url);
    }

    /**
     * Metodo para hacer una espera dentro de la ejecución
     * @param tiempo -> tiempo (en ms) que se detendra la ejecución
     * @throws InterruptedException -> excepción para la espera
     */
    public void espera(int tiempo) throws InterruptedException {
        Thread.sleep(tiempo);
    }

    /**
     * Metodo para buscar un elemento usando xpath
     * @param objeto -> elemento By con el xpath del WebElement que se quiere localizar
     * @return -> devuelve un objeto WebElement con el resultado de la busqueda.
     */
    public WebElement encuentraXpath(By objeto){
        return driver.findElement(objeto);
    }

    /**
     * Metodo para moverse entre los frames de contenido
     * (No se necesita para este caso, pero lo tengo para otros ejemplos y lo he dejado en la clase)
     */
    public void switchFrames(String [] frame){
        switchDefault();
        for (int i=0;i<frame.length;i++){
            driver.switchTo().frame(driver.findElement(By.xpath("//*/iframe[@name = '" + frame[i] + "']")));
        }
    }

    /**
     * Metodo para volver al frame principal
     * (No se necesita para este caso, pero lo tengo para otros ejemplos y lo he dejado en la clase)
     */
    public void switchDefault(){
        driver.switchTo().defaultContent();
    }

    /**
     * Metodo para finalizar la ejecución de la automatizacion
     */
    public void finalizar(){
        driver.close();
    }

}
