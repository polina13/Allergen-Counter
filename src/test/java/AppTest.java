import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Allergy Counter");
  }

  @Test
  public void userAllergiesTest() {
    goTo("http://localhost:4567/");
    fill("#number").with("255");
    submit(".btn");
    assertThat(pageSource()).contains("Your allergies are: cats, pollen, chocolate, tomatoes, strawberries, shellfish, peanuts, eggs");
  }

  @Test
  public void failingAllergiesTest() {
    goTo("http://localhost:4567/");
    fill("#number").with("257");
    submit(".btn");
    assertThat(pageSource()).contains("You're Dead.");
  }
}
