package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    void inputCarNameSplit() {
      String inputCarName = "테스트1,테스트2";
      String[] cars = inputCarName.split(",");

      if(cars.length<2){
        throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분합니다.");

      }

      assertThat(cars.length).isEqualTo(2);
      assertThat(cars).contains("테스트2", "테스트1");
      assertThat(cars).containsExactly("테스트1", "테스트2");
    }


    @Test
    void inputCarNameValidation() {

      String input = "테스트1,테스트2,테스트3";
      String[] result = input.split(",");
      Map<String,Integer> cars = new HashMap<>();

      for (String car: result) {
        if (car.length()>5){
          throw new IllegalArgumentException("자동차이름은 5자 이하만 가능합니다.");
        }
        cars.put(car,0);
      }
      assertThat(cars).hasSize(3);
    }

    @Test
    void inputAttemptsValidation() {
      String inputAttempts = "5";
      int attempts = Integer.parseInt(inputAttempts);
      assertThat(attempts).isEqualTo(5);
    }

    @Test
    void movementCount() {
      Map<String,Integer> cars = new HashMap<>();
      cars.put("테스트1",0);
      cars.put("테스트2",0);
      cars.put("테스트3",0);

      cars.forEach((carName, movement) -> {
        int number = 4;

        if(number>=4){
          movement = movement.intValue();
          movement++;
          cars.replace(carName,movement);
        }
      });
      assertThat(cars.get("테스트1")).isEqualTo(1);
    }

    @Test
    void progressDisplay() {
      Map<String,Integer> cars = new HashMap<>();
      cars.put("테스트1",1);
      cars.put("테스트2",0);
      cars.put("테스트3",3);

      cars.forEach((carName, movement) -> {
        String result = "";
        for(int i = 1 ; i<=movement ; i++){
          result+="-";
        }
        System.out.println(carName + " : " + result);
      });
    }
    @Test
    void winnerDisplay() {
      Map<String,Integer> cars = new HashMap<>();
      String winner = "";
      cars.put("테스트1",3);
      cars.put("테스트2",0);
      cars.put("테스트3",1);
      Integer maxValue = Collections.max(cars.values());
      Set<Map.Entry<String, Integer>> entrySet = cars.entrySet();
      for(Map.Entry<String,Integer> entry: entrySet){
        if(entry.getValue() == maxValue){
          winner+=",";
          winner+=entry.getKey();
        }
      }
      winner = winner.replaceFirst(",","");
      System.out.println("최종 우승자 : " + winner);

      assertThat(maxValue).isEqualTo(3);
    }

}
