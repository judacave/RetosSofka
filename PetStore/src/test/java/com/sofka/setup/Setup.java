package com.sofka.setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofka.utils.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {
    private static final String SWITCHES = "--remote-allow-origins=*";
    private static final String INCOGNITO = "--incognito";
    private static final String POPUP = "--disable-popup-blocking";
    private static final String ACTOR = "Juan David";
    private static final int DIEZ_SEGUNDOS = 10;

    @Managed()
    protected WebDriver webDriver;


    private void setupUser(WebDriver webDriver) {
        configurarDriver();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR).can(BrowseTheWeb.with(webDriver));
        maximizar(webDriver);
    }

    private void configurarDriver() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments(SWITCHES);
//        co.addArguments(INCOGNITO);
        co.addArguments(POPUP);
        co.addArguments("--disable-notifications");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, co);
        co.merge(cap);
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(co);
    }

    private static void maximizar(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    protected void quitarDriver() {
        webDriver.quit();
    }

    protected void configurarNavegador() {
        setupUser(webDriver);
        setUplog4j();
    }

    private void setUplog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

}
