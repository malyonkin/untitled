package mainPage

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Allure
import org.junit.jupiter.api.*
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.remote.RemoteWebDriver
import setUp
import java.io.ByteArrayInputStream
import java.util.logging.Level

class WebPageTest: setUp() {
    @BeforeEach
    fun setUp() {
        setUpBrowser(isMobile = false, isRemote = false)
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
        Selenide.closeWebDriver() //данная команда запускает каждый тест в отдельном браузере
    }
}