package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingService;
import racingcar.domain.vo.CarVO;

import java.util.ArrayList;
import java.util.List;

public class SneakPeekTest {
  private static RacingService rs = new RacingService();
  private static List<CarVO> racingCarList = new ArrayList<>();
  private static int tryCycleChoice;

  @BeforeAll
  public static void setup() {
    // junit4.12 버전에서 @Before 만 있었는데
    // 한번만 설정해주려면 @BeforeAll 을 사용하고
    // @Before 의 기능을 사용하려면 @BeforeEach가 적합하다고 함
    tryCycleChoice = 1;
    CarVO car1 = new CarVO();
    car1.setCar("pobi");
    CarVO car2 = new CarVO();
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
  }
}
