package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
    void parsingCarNames_자동차_이름_파싱(){
        Cars cars = new Cars();
        String carNames = "abc,de";
        List<String> carList = cars.parsingCarNames(carNames);

        assertThat(carList).contains("abc","de");
    }

    @Test
    void storeCars_5_글자_초과_하는_이름_존재할_때_예외_발생(){
        Cars cars = new Cars();
        String carNames = "abcdef,ab";
        List<String> carList = cars.parsingCarNames(carNames);

        assertThatThrownBy(() -> cars.storeCars(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void storeCars_1_글자_미만인_이름_존재할_때_예외_발생(){
        Cars cars = new Cars();
        String carNames = ",ab";
        List<String> carList = cars.parsingCarNames(carNames);

        assertThatThrownBy(() -> cars.storeCars(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void storeCars_유효한_이름들일_때_예외_발생_안함(){
        Cars cars = new Cars();
        String carNames = "abc,de";
        List<String> carList = cars.parsingCarNames(carNames);

        assertDoesNotThrow(() ->cars.storeCars(carList));
    }

    @Test
    void checkIfNumeric_숫자가_아닌_입력_시_예외_발생(){
        Game game = new Game();
        String roundCountInput = "abc2";

        assertThatThrownBy(() -> Input.checkIfNumeric(roundCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkIfNumeric_숫자_입력_시_정상_동작(){
        Game game = new Game();
        String roundCountInput = "0";

        assertDoesNotThrow(() -> Input.checkIfNumeric(roundCountInput));
    }

    @Test
    void 경기_진행_수_저장(){
        Game game = new Game();
        Integer roundCountInput = 1;
        game.setRoundCount(roundCountInput);

        assertThat(game.getRoundCount()).isEqualTo(1);
    }

    @Test
    void 한_칸_전진(){
        Car car = new Car("pobi",0);
        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지(){
        Car car = new Car("pobi",0);
        car.move(2);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 현재_경기_상황_출력(){
        Cars cars = new Cars();
        cars.set("pobi,woni");
        cars.getCars().get(0).move(5);
        cars.printCarPositions();

        assertThat(output()).contains("pobi : -", "woni :");
    }

    @Test
    void 단일_우승(){
        Cars cars = new Cars();
        cars.set("pobi,woni");
        cars.getCars().get(0).move(5);
        cars.printCarPositions();
        Winner winner = new Winner(cars.getCars());
        winner.printWinner();

        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
    }

    @Test
    void 공동_우승(){
        Cars cars = new Cars();
        cars.set("pobi,woni");
        cars.getCars().get(0).move(5);
        cars.getCars().get(1).move(5);
        cars.printCarPositions();
        Winner winner = new Winner(cars.getCars());
        winner.printWinner();

        assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
