import com.codeborne.selenide.Configuration
import com.codeborne.selenide.SelectorMode
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Allure
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.Cookie
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.remote.RemoteWebDriver
import trubleCase.test.MyChromeBrowserClass
import trubleCase.test.Settings
import java.io.ByteArrayInputStream
import java.util.*
import java.util.logging.Level

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class setUp {
    @BeforeAll
    fun beforeAllInit(){
        Selenide.closeWebDriver()
    }

        fun setUpBrowser(isMobile: Boolean, isRemote: Boolean) {
            Settings.isMobile = isMobile
            if (isRemote) {
                println("RemoteWebDriver")
            } else {
                Configuration.browser = MyChromeBrowserClass::class.java.name
                println("LocalWebDriver")
            }

            Configuration.browserSize = "1440x900"
            Configuration.pageLoadStrategy = "normal"
            Configuration.timeout = 15000
            Configuration.pageLoadTimeout = 60000
            SelenideLogger.addListener("AllureSelenide", AllureSelenide()
                    .screenshots(false)
                    .savePageSource(false)
                    .enableLogs(io.qameta.allure.selenide.LogType.BROWSER, Level.ALL)
                    .enableLogs(io.qameta.allure.selenide.LogType.DRIVER, Level.ALL))
        }
    }