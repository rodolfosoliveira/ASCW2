package br.com.chronosacademy.automacaoWeb;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.pages.CursosPage;
import br.com.chronosacademy.pages.PrincipalPage;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class TesteWeb {

    WebDriver driver;
    Driver driverWeb;
    PrincipalPage principalPage;
    CursosPage cursosPage;

    @Before
    public void inicializaTeste(){
        driverWeb = new Driver("chrome");

        driver = driverWeb.getDriver();

        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);

    }


    @Test
    public void primeiroTeste(){


        String titulo = principalPage.getTitulo();

        Assertions.assertEquals("Porque Tempo É Conhecimento", titulo);


    }

    @Test
    public void segundoTeste(){
        cursosPage = new CursosPage(driver);
        principalPage.clickBotao();

        String titulo = cursosPage.getTitulo2();

        Assert.assertEquals("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", titulo);

    }


    @After
    public void finalizaTeste(){
        driver.quit();
    }
}
