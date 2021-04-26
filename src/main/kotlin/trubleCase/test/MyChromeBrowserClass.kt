package trubleCase.test

import com.codeborne.selenide.WebDriverProvider
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

class MyChromeBrowserClass : WebDriverProvider {

    @SuppressWarnings("deprecation")
    override fun createDriver(capabilities: DesiredCapabilities): WebDriver {
        WebDriverManager.chromedriver().setup()
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions)
        return ChromeDriver(capabilities)
    }

    companion object {
        val chromeOptions: ChromeOptions
            get() {
                val chromeOptions = ChromeOptions()

                if(Settings.isMobile == true) {
                    //todo оптимизировать размер кода на System.setProperty("chromeoptions.mobileEmulation", "deviceName=iPhone X");
                    val mobileEmulation: MutableMap<String, Any> = HashMap()
                    mobileEmulation["deviceName"] = "iPhone X"
                    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation)
                }

                //chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("disable-infobars")
                chromeOptions.setExperimentalOption("excludeSwitches", listOf("enable-automation"))
                chromeOptions.setExperimentalOption("useAutomationExtension", false)

                //chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-gpu")
                chromeOptions.addArguments("--disable-extensions")
                chromeOptions.addArguments("--no-sandbox")
                chromeOptions.addArguments("--disable-dev-shm-usage")
                //chromeOptions.addArguments("disable-popup-blocking", "true");
                //chromeOptions.addArguments("--enable-logging=stderr --v=1");

                val prefs: MutableMap<String, Any> = HashMap()
                prefs["credentials_enable_service"] = false
                prefs["profile.password_manager_enabled"] = false
                chromeOptions.setExperimentalOption("prefs", prefs)
                return chromeOptions
            }
    }
}