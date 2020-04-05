package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,25);

    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

    public String getPageLogoText(){
        return pageLogo.getText();
    }



    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    /**
     * Specify component name as a parameter, like View all products or Orders
     * @param component
     */
    public void navigateTo(String component){
        String locator = "//a[text()='"+component+"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }




}
