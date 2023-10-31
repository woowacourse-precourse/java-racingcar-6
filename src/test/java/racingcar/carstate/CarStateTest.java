package racingcar.carstate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validator.CarNameValidator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStateTest {

    private Cars cars;
    private Car car;


    @BeforeEach
    void setup() {
        cars = new Cars("Hyun,Doo,Boo");
        car = new Car("Hyun");
    }
    @Test
    void 차_이름_입력_테스트() {
        CarNameValidator validator = new CarNameValidator("1,2");
        assertThat(validator.NAMES).contains("2", "1");
        assertThat(validator.NAMES).containsExactly("1", "2");
    }

    @Test
    void 차_직진_X_테스트(){
        for (int i = 0; i <= 3; i++) {
            car.move(i);
            assertThat(car.getCarPosition()).isEqualTo(0);
        }
    }

    @Test
    void 차_직진_O_테스트(){
        for (int i = 4; i <= 9; i++) {
            car = new Car("Doo");
            car.move(i);
            assertThat(car.getCarPosition()).isEqualTo(1);
        }
    }

    @Test
    void 차_위치_반환_테스트(){
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @Test
    void 차_이름_반환_테스트(){
        assertThat(car.getCarName()).isEqualTo("Hyun");
    }

    @Test
    void 최고_위치_반환_테스트() {

        int position = cars.getMaxPosition();
        assertThat(position).isEqualTo(0);

        cars.getCars().stream()
                .filter(car -> car.getCarName().equals("Hyun"))
                .findFirst()
                .ifPresent(hyun -> hyun.setPosition(3));

        position = cars.getMaxPosition();
        assertThat(position).isEqualTo(3);

    }

    @Test
    void 승리_차_반환_테스트() {

        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactly("Hyun", "Doo", "Boo");

        cars.getCars().stream()
                .filter(car -> car.getCarName().equals("Hyun"))
                .findFirst()
                .ifPresent(hyun -> hyun.setPosition(3));

        winners = cars.getWinners();
        assertThat(winners).containsExactly("Hyun");

    }

    @Test
    void 전체_차_상태_반환_테스트() {

        cars.getCars().stream()
                .filter(car -> car.getCarName().equals("Hyun"))
                .findFirst()
                .ifPresent(hyun -> hyun.setPosition(3));

        HashMap<String, Integer> carStates = cars.carsStates();

        LinkedHashMap<String, Integer> expectedStates = new LinkedHashMap<>();
        expectedStates.put("Hyun", 3);
        expectedStates.put("Doo", 0);
        expectedStates.put("Boo", 0);

        assertThat(carStates).isEqualTo(expectedStates);
    }

}