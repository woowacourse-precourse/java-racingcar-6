package mytest;
import static org.assertj.core.api.Assertions. *;
import java.util.LinkedHashMap;
import java.util.StringJoiner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingmodel.CarRacingGame;

public class CarRacingGameTest {
    static LinkedHashMap<String, StringBuilder> testmap = null;
    @BeforeEach
    void init()
    {
        testmap = new LinkedHashMap<>();
        testmap.put("pobi", new StringBuilder("-"));
    }
   @Test
   void changeStatusTest()
   {
       CarRacingGame testCar = new MockCarRacingGame(testmap);
       testCar.changeGame();
       testmap = testCar.getCarName();
       assertThat(testCar.getCarName().get("pobi").toString()).isEqualTo("--");
   }
   @Test
   void getWinnerTest()
   {
       testmap.put("woni", new StringBuilder("--"));
       CarRacingGame testCar = new MockCarRacingGame(testmap);
       assertThat(testCar.getWinner().get(0)).isEqualTo("woni");
   }

}
