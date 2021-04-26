package mainPage

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selectors.by
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Allure
import org.junit.jupiter.api.*
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.remote.RemoteWebDriver
import setUp
import java.io.ByteArrayInputStream
import java.util.logging.Level

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MobPageTest : setUp() {

    @BeforeEach
    fun setUp() {
        setUpBrowser(isMobile = true, isRemote = false)
        open("https://autospot.ru/")
    }

    @RepeatedTest(3)
    @DisplayName("Переход на страницу расширенного поиска")
    fun openAdvancedSearchTest() {
        element(byText("Расширенный поиск")).scrollTo().should(visible).click()
        element("h1").shouldHave(text("Расширенный поиск"))
    }

    @AfterEach
    fun afterScenario() {
        //Selenide.closeWebDriver()
    }
}