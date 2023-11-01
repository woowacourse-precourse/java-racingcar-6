package racingcar.domain.car;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Car;

class CarInfoTest {
    CarInfo carInfo;

    @BeforeEach
    void clear() {
        carInfo = CarInfo.getInstance(); // CarInfo의 새 인스턴스를 생성하는 메서드
        carInfo.reset();
    }

    @DisplayName("자동차에 대한 정보를 저장할 수 있습니다.")
    @Test
    void saveCarInfo() {
        // given
        String name = "soddong";
        int position = 7777777;
        Car car = new Car(name, position);

        // when
        carInfo.saveCarInfo(car);

        // then
        Car savedCar = carInfo.getCarInfo(name);
        assertThat(savedCar.name()).isEqualTo(name);
        assertThat(savedCar.position()).isEqualTo(position);
    }

    @DisplayName("중복된 자동차의 이름은 입력할 수 없습니다.")
    @Test
    void saveCarInfo_exception_duplicatedName() {
        // given
        Car car1 = new Car("soddong", 1);
        carInfo.saveCarInfo(car1);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carInfo.saveCarInfo(car1);
        });
    }

    @DisplayName("자동차에 대한 정보를 한꺼번에 저장 할 수 있습니다.")
    @Test
    void saveAllCarInfo() {
        // given
        String name1 = "s";
        String name2 = "o";
        String name3 = "d";
        List<String> stringList = Arrays.asList(name1, name2, name3);

        // when
        carInfo.saveAllCarInfo(stringList);

        // then
        Car savedCar1 = carInfo.getCarInfo(name1);
        Car savedCar2 = carInfo.getCarInfo(name2);
        Car savedCar3 = carInfo.getCarInfo(name3);

        assertThat(savedCar1.name()).isEqualTo(name1);
        assertThat(savedCar2.name()).isEqualTo(name2);
        assertThat(savedCar3.name()).isEqualTo(name3);
    }

    @DisplayName("자동차의 정보를 업데이트할 수 있습니다.")
    @Test
    void updateCarInfo() {
        // given
        String name = "s";
        int position = 7777777;
        Car car = new Car(name, position);
        carInfo.saveCarInfo(car);

        // when
        int position2 = 1004;
        carInfo.updateCarInfo(new Car(name, position2));

        // then
        Car updatedCar = carInfo.getCarInfo(name);
        assertThat(updatedCar.position()).isEqualTo(position2);
    }

    @DisplayName("존재하지 않는 자동차의 이름은 업데이트할 수 없습니다.")
    @Test
    void updateCarInfo_exception_notExistName() {
        // given
        String name = "s";
        int position = 7777777;
        Car car = new Car(name, position);
        carInfo.saveCarInfo(car);

        // when & then
        String name2 = "ss";
        int position2 = 1004;

//        1.
        assertThrows(IllegalArgumentException.class, () -> {
            carInfo.updateCarInfo(new Car(name2, position2));
        }).getMessage().contains("업데이트 하려는 이름이 없습니다.");

//        2.
        assertThatThrownBy(() -> carInfo.updateCarInfo(new Car(name2, position2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("업데이트 하려는 이름이 없습니다.");

//        3.
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carInfo.updateCarInfo(new Car(name2, position2)))
                .withMessageContaining("업데이트 하려는 이름이 없습니다.");
    }

    @DisplayName("자동차의 정보를 얻을 수 있다.")
    @Test
    void getCarInfo() {
        // given
        Car car = new Car("soddong", 1);
        carInfo.saveCarInfo(car);

        // when
        Car savedCar = carInfo.getCarInfo("soddong");

        // then
        assertThat(savedCar).isEqualTo(car);
    }

    @DisplayName("자동차의 정보를 한꺼번에 얻을 수 있다.")
    @Test
    void getAllCarInfo() {
        // given
        List<String> stringList = Arrays.asList("name1", "name2", "name3");
        carInfo.saveAllCarInfo(stringList);

        // when
        List<Car> getCarList = carInfo.getAllCarInfo();

        // then
        assertThat(getCarList).hasSameSizeAs(stringList);
    }
}