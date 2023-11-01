package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingService;
import racingcar.domain.dto.CarDTO;

import java.util.ArrayList;
import java.util.List;

public class SneakPeekTest {
  private static RacingService rs = new RacingService();
  private static List<CarDTO> racingCarList = new ArrayList<>();
  private static int tryCycleChoice;

  @BeforeAll
  public static void setup() {
    // junit4.12 버전에서 @Before 만 있었는데
    // 한번만 설정해주려면 @BeforeAll 을 사용하고
    // @Before 의 기능을 사용하려면 @BeforeEach가 적합하다고 함
    tryCycleChoice = 1;
    CarDTO car1 = new CarDTO();
    car1.setCar("pobi");
    CarDTO car2 = new CarDTO();
    car2.setCar("jeson");

    racingCarList.add(car1);
    racingCarList.add(car2);
  }
  @Test
  public void gamePlayTest() {
    rs.gamePlay(tryCycleChoice, racingCarList);
    /* 테스트 통과 완료
    pobi : -
    jeson : -
    > Task :test
    BUILD SUCCESSFUL in 1s
    */
    // assert 사용이 안됨. NsTest를 상속받아서 3회차에
    // assertSimpleTest를 활용하는 방법을 해보자. + junit5버전의 어노테이션도 재 확인
  }
}
