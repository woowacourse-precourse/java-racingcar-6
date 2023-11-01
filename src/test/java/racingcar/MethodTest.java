package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.GameModel;
import racingcar.model.Validator;

public class MethodTest {

    @Test
    void 자동차_이름목록_생성기능_테스트() {
        String carNames = "one,two,three";
        GameModel gameModel = new GameModel();
        List<String> carNameList = gameModel.generateCarName(carNames);

        assertThat(carNameList).containsExactly("one", "two", "three");
    }

    @Test
    void 자동차_객체_생성기능_테스트() {
        List<String> carNameList = Arrays.asList("one", "two", "three");
        GameModel gameModel = new GameModel();
        List<Car> carList = gameModel.generateCar(carNameList);

        assertThat(carList.size()).isEqualTo(3);
    }

    @Test
    void 게임_우승자_탐색기능_테스트() {
        List<String> carNameList = Arrays.asList("one", "two", "three");
        GameModel gameModel = new GameModel();
        List<Car> carList = gameModel.generateCar(carNameList);

        for (int i = 0; i < 10; i++) {
            carList.get(0).controlMovement();
            carList.get(1).controlMovement();
            carList.get(2).controlMovement();
        }

        List<String> result = gameModel.findWinner(carList);

        assertThat(result.get(0)).containsAnyOf("one", "two", "three");
    }

    @Test
    void 자동차_객체_이동기능_테스트() {
        Car car = new Car("one");

        for (int i = 0; i < 10; i++) {
            car.controlMovement();
        }

        assertThat(car.getDistance()).isGreaterThan(0);
    }

    @Test
    void 자동차_객체_이동거리_출력기능_테스트() {
        Car car = new Car("one");

        for (int i = 0; i < 10; i++) {
            car.controlMovement();
        }

        assertThat(car.reportMovement()).isGreaterThan("");
    }

    @Test
    void 입력값의_유효성을_체크하는_기능_테스트() {
        Validator validator = new Validator();

        List<String> nullName = Arrays.asList("");
        List<String> blankContainName = Arrays.asList("a ");
        List<String> longName = Arrays.asList("123456");

        assertThatThrownBy(() -> validator.validateCarName(nullName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 한글자 이상이어야 합니다");

        assertThatThrownBy(() -> validator.validateCarName(blankContainName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름에는 공백을 포함할 수 없습니다.");

        assertThatThrownBy(() -> validator.validateCarName(longName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 중복된_자동차_이름을_체크하는_기능_테스트() {
        Validator validator = new Validator();

        List<String> duplicateName = Arrays.asList("a", "a");

        assertThatThrownBy(() -> validator.isCarNameUnique(duplicateName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 게임시도_횟수의_입력값_유효성을_체크하는_기능_테스트() {
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.validateAttemptInput(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도할 횟수는 1회 이상이여야 합니다.");

        assertThatThrownBy(() -> validator.validateAttemptInput(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도할 횟수는 1회 이상이여야 합니다.");
    }
}
