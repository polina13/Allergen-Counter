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
    // String layout = "templates/layout.vtl";
    //
    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/main.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/detector", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/detector.vtl");
    //   String numberString = request.queryParams("number");
    //   Integer number = Integer.parseInt(numberString);
    //   Object results = CoinCombo.makesChange(number);
    //
    //   model.put("results", results);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }

  public static Object countsAllergens(Integer number) {
    ArrayList<String> allergies = new ArrayList<String>();

    if(number >= 256) {
      return "You're Dead.";
    }
    while (number >= 128) {
      allergies.add("cats");
      number -= 128;
    }
    while (number >= 64) {
      allergies.add("pollen");
      number -= 64;
    }
    while (number >= 32) {
      allergies.add("chocolate");
      number -= 32;
    }
    while (number >= 16) {
      allergies.add("tomatoes");
      number -= 16;
    }
    while (number >= 8) {
      allergies.add("strawberries");
      number -= 8;
    }
    while (number >= 4) {
      allergies.add("shellfish");
      number -= 4;
    }
    while (number >= 2) {
      allergies.add("peanuts");
      number -= 2;
    }
    while (number >= 1) {
      allergies.add("eggs");
      number --;
    }
    return "Your allergies are: " + StringUtils.join(allergies, ", ");
  }
}
