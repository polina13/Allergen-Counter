import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class AllergenCounterTest {

  @Test
  public void countsAllergies() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("You're Dead.", testAllergenCounter.countsAllergens(256));
  }

  @Test
  public void countscats() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: cats", testAllergenCounter.countsAllergens(128));
  }

  @Test
  public void countspollen() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: pollen", testAllergenCounter.countsAllergens(64));
  }

  @Test
  public void countschocolate() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: chocolate", testAllergenCounter.countsAllergens(32));
  }
  @Test
  public void countstomatoes() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: tomatoes", testAllergenCounter.countsAllergens(16));
  }
  @Test
  public void countstrawberries() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: strawberries", testAllergenCounter.countsAllergens(8));
  }
  @Test
  public void countsshellfish() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: shellfish", testAllergenCounter.countsAllergens(4));
  }
  @Test
  public void countspeanuts() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: peanuts", testAllergenCounter.countsAllergens(2));
  }
  @Test
  public void countseggs() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: eggs", testAllergenCounter.countsAllergens(1));
  }
  @Test
  public void countseverything() {
    AllergenCounter testAllergenCounter = new AllergenCounter();
    assertEquals("Your allergies are: cats, pollen, chocolate, tomatoes, strawberries, shellfish, peanuts, eggs", testAllergenCounter.countsAllergens(255));
  }
}
