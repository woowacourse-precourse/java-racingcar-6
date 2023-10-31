package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.domain.Cars;


class RacingCarGameControllerTest extends NsTest {

    RacingCarGameController racingCarGameController = new RacingCarGameController();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 공동_우승자_안내_문구_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,joon", "2");
                    assertThat(output()).contains("최종 우승자 : pobi, joon");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 한줄로_입력_받은_자동차_이름_리스트_구분_기능() {
        List<String> carNameList = racingCarGameController.convertStringToCarList("벤츠,제네시스,소나타");
        assertThat(carNameList).contains("벤츠", "제네시스", "소나타");
    }

    @Test
    void 자동차들_전진_숫자_중_최댓값_찾는_기능() {
        Cars cars = new Cars();
        Map<String, Car> carMap = cars.getCars();
        Car car1 = new Car("벤츠");
        car1.setAdvanceCount(3);
        Car car2 = new Car("제네시스");
        car2.setAdvanceCount(5);

        carMap.put("벤츠", car1);
        carMap.put("제네시스", car2);
        int maxAdvanceCount = racingCarGameController.getMaxAdvanceCount(carMap);

        assertThat(maxAdvanceCount).isEqualTo(5);
    }

    @Test
    void 자동차들_중_우승자_리스트_반환하는_기능() {
        Cars cars = new Cars();
        Map<String, Car> carMap = cars.getCars();
        Car car1 = new Car("벤츠");
        car1.setAdvanceCount(3);
        Car car2 = new Car("제네시스");
        car2.setAdvanceCount(5);
        Car car3 = new Car("소나타");
        car3.setAdvanceCount(5);

        carMap.put("벤츠", car1);
        carMap.put("제네시스", car2);
        carMap.put("소나타", car3);

        List<String> winnerList = racingCarGameController.getWinnerList(carMap, 5);

        assertThat(winnerList).contains("제네시스", "소나타");
        assertThat(winnerList).doesNotContain("벤츠");
    }

    @Test
    void 랜덤_숫자가_최소_전진_숫자_보다_큰_지_판단_하는_기능() {
        int randomNumber = 5;
        boolean biggerFlag = racingCarGameController.isBiggerThanMinAdvanceCount(randomNumber);
        assertThat(biggerFlag).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}