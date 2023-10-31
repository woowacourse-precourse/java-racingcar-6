package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;

public class CarsTest {

    private Cars cars;
    private List<Car> carList;

    @BeforeEach
    void setup() {
        cars = new Cars("pobi,woni,jun");
        carList = cars.getCars();

        carList.get(0).run(4);
        carList.get(2).run(4);
    }

    @Test
    void 중복_자동차_이름_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Cars("pobi,woni,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 입력하셨습니다."));
    }

    @Test
    void 현재_자동차들_위치_정보_테스트() {
        String carsInfo = carList.stream()
                .map(car -> car.getName()
                        + " : "
                        + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"));

        List<CarStatus> carStatusList = carList.stream()
                .map(CarStatus::new)
                .toList();

        String actualResult = carStatusList.stream()
                .map(carStatus -> carStatus.getName()
                        + " : "
                        + "-".repeat(carStatus.getPosition()))
                .collect(Collectors.joining("\n"));

        assertThat(actualResult).isEqualTo(carsInfo);
    }
}