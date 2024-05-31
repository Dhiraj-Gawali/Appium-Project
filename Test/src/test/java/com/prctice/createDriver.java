package com.prctice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

public class createDriver {

    static AppiumDriver driver = null;
    public static AppiumDriver initializeDriver(String executionPlatformName){

        executionPlatformName = executionPlatformName;
        try {
            URL url = new URL("http://0.0.0.0:4723/");

            if (executionPlatformName.equalsIgnoreCase("Android") ){
                String appPath = System.getProperty("user.dir")
                        + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                UiAutomator2Options options = new UiAutomator2Options()
                        .setUdid("emulator-5554")
                        .setAvd("Pixel_8_Pro")
                        .setAvdLaunchTimeout(Duration.ofSeconds(180))
                        .setApp(appPath);

                driver = new AndroidDriver(url, options);
            }
            else if (executionPlatformName.equalsIgnoreCase("iOS")){
                String appPath = System.getProperty("user.dir")
                        + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
                XCUITestOptions option = new XCUITestOptions()
                        .setUdid("D02E5539-9D85-4799-97BD-C437B894A8CF")
                        .setSimulatorStartupTimeout(Duration.ofSeconds(180))
                        .setApp(appPath);
                driver = new IOSDriver(url, option);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;

    }

    public static String androidBundleID(){
        return "io.appium.android.apis";
    }
}
