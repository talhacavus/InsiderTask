package com.insider.page;

import com.insider.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.concurrent.TimeUnit;


import static com.insider.driver.DriverBase.driver;
public class TaskPage {


    Methods methods;
    Logger logger = LogManager.getLogger(TaskPage.class);
    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(10, TimeUnit.SECONDS)
            .pollingEvery(250, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .ignoring(TimeoutException.class);


    public TaskPage() {
        methods = new Methods();
    }

    public void taskTest(){
        //Coockies are denied
        methods.cookies();
        //Opening Page Check
        methods.isElementVisible(By.xpath("(//img[@src='https://useinsider.com/assets/img/logo-old.png'])[1]"));

        //These codes execute the operations shown in step 2 and logging to logger.
        methods.click(By.xpath("//a[@id='wt-cli-accept-all-btn']"));
        methods.click(By.xpath("//span[text()='More']"));
        methods.isElementVisible(By.xpath("//a[@href='https://useinsider.com/careers/']"));
        methods.click(By.xpath("//h5[text()='Careers']"));
        methods.scrollWithAction(By.xpath("//h3[@class='category-title-media ml-0' and contains(text(),'Our Locations')]"));
        methods.isElementVisible(By.xpath("//h3[@class='category-title-media ml-0' and contains(text(),'Our Locations')]"));
        String ourLocations = methods.getText(By.xpath("//h3[@class='category-title-media ml-0' and contains(text(),'Our Locations')]"));
        Assert.assertEquals(ourLocations,"Our Locations");
        logger.info("Locations Checked"+ ourLocations);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='elementor-heading-title elementor-size-default' and text()='Life at Insider']")));
        methods.scrollWithAction(By.xpath("//h2[@class='elementor-heading-title elementor-size-default' and text()='Life at Insider']"));
        methods.isElementVisible(By.xpath("//h2[@class='elementor-heading-title elementor-size-default' and text()='Life at Insider']"));
        String lifeAtInsider = methods.getText(By.xpath("//h2[@class='elementor-heading-title elementor-size-default' and text()='Life at Insider']"));
        Assert.assertEquals(lifeAtInsider,"Life at Insider");
        logger.info("Teams and Life at Insider block Checked"+ lifeAtInsider);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore' and text()='See all teams']")));
        methods.scrollWithAction(By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore' and text()='See all teams']"));
        String seeAllTeams = methods.getText(By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore' and text()='See all teams']"));
        Assert.assertEquals(seeAllTeams,"See all teams");
        logger.info("Teams Block Checked" + seeAllTeams);
        methods.waitBySeconds(3);
        methods.scrollLittleBitUp();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore' and text()='See all teams']")));
        methods.isElementVisible(By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore' and text()='See all teams']"));
        methods.click(By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore' and text()='See all teams']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='text-center mb-4 mb-xl-5' and text()='Quality Assurance']")));
        methods.scrollWithAction(By.xpath("//h3[@class='text-center mb-4 mb-xl-5' and text()='Quality Assurance']"));
        methods.waitBySeconds(2);
        methods.scrollLittleBitUp();

        //These codes perform the operations related to the click shown in step 3.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='text-center mb-4 mb-xl-5' and text()='Quality Assurance']")));
        methods.click(By.xpath("//h3[@class='text-center mb-4 mb-xl-5' and text()='Quality Assurance']"));
        methods.click(By.xpath("//a[@href='https://useinsider.com/careers/open-positions/?department=qualityassurance' and text()='See all QA jobs']"));

        methods.scrollWithAction(By.xpath("//h3[@class='mb-0' and text()]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='mb-0' and text()]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-selection__rendered' and @title='All']")));
        methods.click(By.xpath("//span[@class='select2-selection__rendered' and @title='All']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='select2-results__option' and text()='Istanbul, Turkey']")));
        methods.click(By.xpath("//li[@class='select2-results__option' and text()='Istanbul, Turkey']"));

        //These codes check the operations shown in step 4 and logging to logger.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='position-department text-large font-weight-600 text-primary' and text()='Quality Assurance']")));
        String text = methods.getText(By.xpath("//span[@class='position-department text-large font-weight-600 text-primary' and text()='Quality Assurance']"));
        Assert.assertEquals("Quality Assurance", text);
        logger.info("'Quality Assurance' text checked" + text);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='position-location text-large' and contains(.,'Istanbul, Turkey')])[1]")));
        String text2 = methods.getText(By.xpath("(//div[@class='position-location text-large' and contains(.,'Istanbul, Turkey')])[1]"));
        Assert.assertEquals("Istanbul, Turkey", text2);
        logger.info("'Istanbul, Turkey' text checked" + text2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5' and contains(.,'Apply Now')])[1]")));
        String text3 = methods.getText(By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5' and contains(.,'Apply Now')])[1]"));
        Assert.assertEquals("Apply Now", text3);
        String attiribute = driver.findElement(By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5' and contains(.,'Apply Now')])[1]")).getAttribute("href");
        logger.info("Apply now button checked" + text3);

        //These codes check the operations shown in step 5.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5' and contains(.,'Apply Now')])[1]")));
        methods.click(By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5' and contains(.,'Apply Now')])[1]"));


        methods.switchTab();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(attiribute, URL);
        logger.info("Checked that the opened page is the Lever Application form page");












    }

}
