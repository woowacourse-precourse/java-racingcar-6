package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void inputCarNameSplit_정상케이스() {
      assertThatCode(() -> inputCarNameSplit("테스트1,테스트2,테스트3"))
          .doesNotThrowAnyException();
    }
    @Test
    void inputCarNameSplit_예외케이스() {
      assertThatThrownBy(() -> inputCarNameSplit("테스트1"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("이름은 쉼표(,) 기준으로 구분합니다.");;
    }
    private void inputCarNameSplit(String inputCarName){
      String[] cars = inputCarName.split(",");
      if(cars.length<2){
        throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분합니다.");
      }
    }

    @Test
    void inputCarNameValidation_정상케이스() {
      assertThatCode(() -> inputCarNameValidation("테스트1,테스트2,테스트3"))
          .doesNotThrowAnyException();
    }

    @Test
    void inputCarNameValidation_예외케이스() {
      assertThatThrownBy(() -> inputCarNameValidation("123456,테스트2,테스트3"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    private void inputCarNameValidation(String input){
      String[] result = input.split(",");
      for (String car : result){
        if(car.length()>5){
          throw  new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
      }
    }

    @Test
    void createCars() {
      String input = "테스트1,테스트2,테스트3";
      String[] inputCarNameSplit = input.split(",");
      Map<String,Integer> cars = new HashMap<>();

      for (String car : inputCarNameSplit){
        cars.put(car,0);
      }

      assertThat(cars).hasSize(3)
          .contains(entry("테스트1", 0), entry("테스트2", 0), entry("테스트3", 0))
          .doesNotContainEntry("테스트4", 0);
    }

    @Test
    void inputAttemptsValidation_정상케이스() {
      assertThatCode(() -> inputAttemptsValidation("5"))
          .doesNotThrowAnyException();
    }
    @Test
    void inputAttemptsValidation_예외케이스() {
      assertThatThrownBy(() -> inputAttemptsValidation("시도횟수"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("숫자만 입력해 주세요.");
    }

    private int inputAttemptsValidation(String inputAttempts){
      try {
        int attempts = Integer.parseInt(inputAttempts);
        return attempts;
      } catch (NumberFormatException e){
        throw new IllegalArgumentException("숫자만 입력해 주세요.");
      }
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
      assertThat(cars.get("테스트2")).isEqualTo(1);
      assertThat(cars.get("테스트3")).isEqualTo(1);
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
        assertThat(result.length()).isEqualTo(movement);
      });
    }

    @Test
    void winnerDisplay() {
      Map<String,Integer> cars = new HashMap<>();
      StringJoiner winner = new StringJoiner(",");
      cars.put("테스트1",3);
      cars.put("테스트2",3);
      cars.put("테스트3",1);
      Integer maxValue = Collections.max(cars.values());
      Set<Map.Entry<String, Integer>> entrySet = cars.entrySet();
      for(Map.Entry<String,Integer> entry: entrySet){
        if(entry.getValue() == maxValue){
          winner.add(entry.getKey());
        }
      }

      System.out.println("최종 우승자 : " + winner);
      assertThat(winner.toString()).contains("테스트1","테스트2");
    }

}
