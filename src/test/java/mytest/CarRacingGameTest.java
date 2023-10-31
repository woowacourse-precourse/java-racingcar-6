package mytest;
import static org.assertj.core.api.Assertions. *;
import java.util.LinkedHashMap;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;
import racingmodel.CarRacingGame;

public class CarRacingGameTest {
   @Test
   void changeStatusTest()
   {
       LinkedHashMap<String, StringBuilder> testmap = new LinkedHashMap<>();
       testmap.put("pobi", new StringBuilder("-"));
       CarRacingGame testCar = new CarRacingGame(testmap);
       testCar.changeGame();
       testmap = testCar.getCarName();
       assertThat(testCar.getCarName().get("pobi").toString()).isEqualTo("--");
   }
}
