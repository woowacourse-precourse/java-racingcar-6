package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void 경주_할_자동차_이름_입력_기능_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,123", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_회수_입력_기능_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,lee", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 출력_기능() {
        String message = "output test";

        assertSimpleTest(() -> {
                    InputAndOutput.outputMessage(message);
                    assertThat(output()).contains("output test");
                }
        );
    }

    @Test
    void 경주_결과_출력_기능() {
        List<Car> carList = new ArrayList<>();

        List<String> goOrStopRecord = new ArrayList<>();
        goOrStopRecord.add("-");
        carList.add(new Car("apple", goOrStopRecord, 1));

        goOrStopRecord = new ArrayList<>();
        carList.add(new Car("lemon", goOrStopRecord, 0));

        assertSimpleTest(() -> {
            InputAndOutput.outputRaceResult(carList);
            assertThat(output()).contains("apple : -", "lemon :");
        });
    }

    @Test
    void 경주_우승자_출력_기능() {
        List<String> winnerList = new ArrayList<>();
        winnerList.add("cake");
        winnerList.add("pie");

        assertSimpleTest(() -> {
            InputAndOutput.outputRaceWinner(winnerList);
            assertThat(output()).contains("cake, pie");
        });
    }

    @Test
    void 자동차_객체_생성_기능() {
        List<String> carNameList = new ArrayList<>();
        carNameList.add("paul");
        carNameList.add("james");

        assertSimpleTest(() -> {
            List<Car> carList = Car.makeCarList(carNameList);
            assertThat(carList).isNotEmpty();
        });
    }

    @Test
    void 시도_회수_만큼_반복_기능() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("chip", new ArrayList<>(), 0));
        carList.add(new Car("dale", new ArrayList<>(), 0));

        assertSimpleTest(() -> {
            RacingLogic.repeatRaceAsTryTimes(carList, 2);
            assertThat(output()).contains("chip", "dale", "최종 우승자");
        });
    }

    @Test
    void 이동_또는_정지_구분_위한_무작위_값_생성_기능() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> randomNumberList = RacingLogic.decideGoOrStopByRandoms(2);
                    assertThat(randomNumberList).containsExactly(5, 1);
                },
                5, 1
        );
    }

    @Test
    void 이동_또는_정지_여부_구분_기능() {
        List<Integer> randomNumberList = new ArrayList<>();
        randomNumberList.add(2);
        randomNumberList.add(8);

        assertSimpleTest(() -> {
            List<Boolean> goOrStopList = RacingLogic.isGreaterThanOrEqualToFour(randomNumberList);
            assertThat(goOrStopList).containsExactly(false, true);
        });
    }

    @Test
    void 경주_결과_저장_기능() {
        List<Car> carList = new ArrayList<>();
        Car car = new Car("panda", new ArrayList<>(), 0);
        carList.add(car);

        List<Boolean> goOrStopList = new ArrayList<>();
        goOrStopList.add(true);

        assertSimpleTest(() -> {
            RacingLogic.saveRaceData(carList, goOrStopList);
            assertThat(car.getName()).isEqualTo("panda");
            assertThat(car.getGoOrStopRecord().toString()).isEqualTo("[-]");
            assertThat(car.getTotalGoTimes()).isEqualTo(1);
        });
    }

    @Test
    void 이동_회수로_우승자_확인_기능() {
        List<Car> carList = new ArrayList<>();

        List<String> goOrStopRecord = new ArrayList<>();
        goOrStopRecord.add("-");
        carList.add(new Car("puppy", goOrStopRecord, 1));

        goOrStopRecord = new ArrayList<>();
        goOrStopRecord.add("-");
        carList.add(new Car("kitty", goOrStopRecord, 1));

        assertSimpleTest(() -> {
            List<String> winnerList = RacingLogic.checkWinner(carList);
            assertThat(winnerList.toString()).isEqualTo("[puppy, kitty]");
        });
    }
}
