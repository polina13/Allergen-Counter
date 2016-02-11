import java.util.Map;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import org.apache.commons.lang.StringUtils;

public class AllergenCounter {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/main.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");
      String number = request.queryParams("number");
      if(number.length() == 0) {
        number = "0";
      }
      Object results = AllergenCounter.countsAllergens(number);
      model.put("results", results);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static Object countsAllergens(String number) {
    ArrayList<String> allergies = new ArrayList<String>();

    if (number.equals("0")) {
      return "Please enter a number";
    }

    Integer integerNumber = Integer.parseInt(number);

    if(integerNumber >= 256) {
      return "You're Dead.";
    }
    while (integerNumber >= 128) {
      allergies.add("cats");
      integerNumber -= 128;
    }
    while (integerNumber >= 64) {
      allergies.add("pollen");
      integerNumber -= 64;
    }
    while (integerNumber >= 32) {
      allergies.add("chocolate");
      integerNumber -= 32;
    }
    while (integerNumber >= 16) {
      allergies.add("tomatoes");
      integerNumber -= 16;
    }
    while (integerNumber >= 8) {
      allergies.add("strawberries");
      integerNumber -= 8;
    }
    while (integerNumber >= 4) {
      allergies.add("shellfish");
      integerNumber -= 4;
    }
    while (integerNumber >= 2) {
      allergies.add("peanuts");
      integerNumber -= 2;
    }
    while (integerNumber >= 1) {
      allergies.add("eggs");
      integerNumber --;
    }
    return "Your allergies are: " + StringUtils.join(allergies, ", ");
  }
}
