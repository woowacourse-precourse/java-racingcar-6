package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @Test
    public void 자동차_이름_길이제한_성공() {
        // 5자 이하의 이름으로 Car 객체 생성
        String name = "pobi";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    public void 자동차_이름_길이제한_실패() {
        // 6자의 이름으로 Car 객체 생성 시도
        String longName = "pobibibi";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(longName))
                .withMessage("자동차 이름이 적합하지 않습니다.");
    }

    @Test
    public void 자동차_이름_쉼표구분_성공() {
        String carNames = "pobi,woni,jun";
        Game game = new Game(carNames, "5");

        List<Car> cars = game.getCars();
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    public void 자동차_이름_쉼표구분_실패() {
        String wrongCarNames = "pobi woni,jun";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Game(wrongCarNames, "5"))
                .withMessage("자동차 이름이 적합하지 않습니다.");
    }

    @Test
    public void 전진_확인_4이상() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1); // 4 이상이므로 1 전진
    }

    @Test
    public void 전진_확인_3이하() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0); // 3 이하이므로 0 전진
    }


}