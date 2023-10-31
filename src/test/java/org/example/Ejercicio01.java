package org.example;

import org.example.driver.Driver;
import org.example.pageObject.AmazonPO;
import org.example.pageObject.GooglePO;


public class Ejercicio01 {

    public static void main(String [] args) throws InterruptedException {

        Driver driver = new Driver();
        GooglePO googlePO = new GooglePO(driver);
        AmazonPO amazonPO = new AmazonPO(driver);

        String busqueda = "playstation 5";

        // 1. Accede a Google con el navegador Chrome
        googlePO.irGoogle();
        googlePO.clickAceptarCookies();
        // 2. Busca un producto (por ejemplo, compresor eléctrico)
        googlePO.buscar(busqueda);
        // 3. En los resultados accede al enlace de Amazon
        googlePO.clickAmazon();
        amazonPO.clickCookies();
        // 4. Imprime por pantalla el precio y la fecha de entrega
        amazonPO.mostrarDatosAmazon();
        // 5. En el buscador general vuelve a buscar el producto
        amazonPO.buscador(busqueda);
        // 6. Filtra por entregas prime
        amazonPO.envioGratis();
        // 7. Ordena por precio de mas bajo a más alto
        amazonPO.ordenarDatos();
        // 8. Imprime por pantalla el nombre de los productos de la primera pantalla y el precio, solo imprime los productos que se han encontrado no los sugeridos, ni las búsquedas antiguas.
        amazonPO.mostrarDatosBusqueda();


        driver.finalizar();


    }
}
