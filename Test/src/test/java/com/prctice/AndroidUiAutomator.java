package com.prctice;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.rmi.Remote;
import java.util.ArrayList;

public class AndroidUiAutomator {

    static AppiumDriver driver;

    @AndroidFindBy(xpath = "//*[@text = \"Accessibility\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Search\"")
    public static WebElement MyEle1;

    @AndroidFindBy(accessibility = "Views")
    @iOSXCUITFindBy(accessibility = "Picker View")
    public static WebElement EleViews;

    @AndroidFindBy(accessibility = "Drag and Drop")
    public static WebElement EleDragAndDrop;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    public static WebElement EleDragDot1;

    @AndroidFindBy(accessibility = "1. Photos")
    public static WebElement ElePhotos;

    @AndroidFindBy(accessibility = "Views")
    public static WebElement ELeViews;

    @AndroidFindBy(accessibility = "Gallery")
    public static WebElement EleGallery;

    @AndroidFindBy(xpath = "//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]")
    public static WebElement swipeGallary;

    @AndroidFindBy(id = "android:id/list")
    public static WebElement ImageButton;

    @AndroidFindBy(accessibility = "WebView2")
    @iOSXCUITFindBy(accessibility = "Red color component value")
    public static WebElement WebView2;
    @AndroidFindBy(accessibility = "TextFields")
    @iOSXCUITFindBy(accessibility = "Red color component value")
    public static WebElement TextFields;

    @AndroidFindBy(id = "io.appium.android.apis:id/edit")
    @iOSXCUITFindBy(id = "io.appium.android.apis:id/edit")
    public static WebElement editBox;


    public AndroidUiAutomator(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static String executionPlatformName;


    public static void main(String[] args) throws InterruptedException {
        executionPlatformName = "Android";
        String ElementText = "TextFields";
        driver = createDriver.initializeDriver(executionPlatformName);
        AndroidUiAutomator au = new AndroidUiAutomator(driver);


    }

    public static void terminateApp(){



    }


    public static void longClick(WebElement ele){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", 2000
        ));
    }

    public static void longClick(int x, int y){

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y,
                "duration", 2000
        ));
    }

    public static ArrayList getCordinagtes(WebElement Ele){

        ArrayList<Integer> co_xy = new ArrayList<>();

        int x = Ele.getLocation().getX();
        co_xy.add(x + ((Ele.getSize().getWidth()) / 2));
        int y = Ele.getLocation().getY();
        co_xy.add(y + ((Ele.getSize().getHeight()) / 2));

        return co_xy;
    }

    public static void DragAndDrop(WebElement ele, ArrayList x_y){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX",x_y.get(0),
                "endY", x_y.get(1)
        ));
    }

    public static void swipeGesture(WebElement ele, String direction){
        if(executionPlatformName.equalsIgnoreCase("Android")){
            driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) ele).getId(),
                    "direction", direction,
                    "percent", 0.75
            ));
        }
        else if(executionPlatformName.equalsIgnoreCase("iOS")){
            driver.executeScript("mobile:swipe", ImmutableMap.of(
                    "element", ((RemoteWebElement) ele).getId(),
                    "direction", direction
            ));
        }

    }

    public static void scrollGesture(WebElement ele, String direction){
        if(executionPlatformName.equalsIgnoreCase("Android")){
            boolean canScrollMore = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) ele).getId(),
                    "direction", direction,
                    "percent", 1
            ));
        }
        else if(executionPlatformName.equalsIgnoreCase("iOS")){
            driver.executeScript("mobile:scroll", ImmutableMap.of(
//                    "element", ((RemoteWebElement) ele).getId(),
                    "direction", direction
            ));
        }
    }

}
