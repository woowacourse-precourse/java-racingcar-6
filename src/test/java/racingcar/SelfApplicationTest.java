package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.Model.Car;
import racingcar.Model.Cars;

public class SelfApplicationTest {

    @Test
    void 이름_5글자_이상_예외처리() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("unifolio"));
        carList.add(new Car("osh"));
        assertThatThrownBy(() -> {
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하여야 합니다");
    }

    @Test
    void 이름_중복_예외처리() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("folio"));
        carList.add(new Car("pobi"));
        assertThatThrownBy(() -> {
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 이름의 자동차가 있습니다.");
    }

    @Test
    void 시도횟수_문자_예외처리() {
        Validator validator = new Validator();
        String input = "f";
        assertThatThrownBy(() -> {
            validator.validatePlayCount(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력할 수 있습니다.");
    }

    @Test
    void 이름_공백_포함_예외처리() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("uni "));
        carList.add(new Car("osh"));
        assertThatThrownBy(() -> {
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 공백이 포함된 자동차가 있습니다.");
    }

    @Test
    void 이름_빈칸_오류처리() {
        Validator validator = new Validator();
        String input = "";
        assertThatThrownBy(() -> {
            validator.validateEmptyCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 없는 자동차가 있습니다.");
    }
}
