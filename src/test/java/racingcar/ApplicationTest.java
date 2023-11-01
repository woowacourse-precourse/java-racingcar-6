package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Util.Verification;
import racingcar.controller.RacingGame;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void 자동차_이름_null값_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Verification.verifyCarName("pobi,,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_글자수_초과_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Verification.verifyCarName("pobi,woni,aaaaaa"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름_공백_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Verification.verifyCarName("pobi,woni,j un"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름_중복_테스트(){
        String inputCarName = "pobi,woni,pobi";
        String[] inputArray = inputCarName.split(",");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Verification.verifyDuplication(inputArray))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_회수_숫자_제외_입력_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Verification.verifyTryNum("a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_회수_양수_제외_입력_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Verification.verifyTryNum("-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 최종_우승자_다수일_경우_테스트(){
        String[] array = {"pobi","woni","jun"};
        List<Car> cars = new ArrayList<>();
        for(String carName: array){
            cars.add(new Car(carName));
        }
        cars.get(0).move();
        cars.get(1).move();
        RacingGame racingGame = new RacingGame();
        assertThat(racingGame.getWinnerList(cars)).isEqualTo(Arrays.asList("pobi","woni"));
    }

    @Test
    void 최종_우승자_한_명일_경우_테스트(){
        String[] array = {"pobi","woni","jun"};
        List<Car> cars = new ArrayList<>();
        for(String carName: array){
            cars.add(new Car(carName));
        }
        cars.get(0).move();
        RacingGame racingGame = new RacingGame();
        assertThat(racingGame.getWinnerList(cars)).isEqualTo(List.of("pobi"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
