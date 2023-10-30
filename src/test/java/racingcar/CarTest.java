package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static racingcar.Car.createCarByName;

class CarTest {

    @Test
    void createCarByName_메서드에서_유효한_이름으로_Car_오브젝트_생성() {
        String validName = "abcd";
        Car car = createCarByName(validName);
        assertThat(car.getName()).isEqualTo(validName);
    }

    @Test
    void createCarByName_메서드에서_긴_이름에_대한_예외_처리() {
        String longName = "abcdef";
        assertThatThrownBy(() -> createCarByName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 이름만 입력해주세요");
    }

    @Test
    void createCarByName_메서드에서_공백_이름에_대한_예외_처리() {
        String emptyName = "";
        assertThatThrownBy(() -> createCarByName(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상의 이름만 입력해주세요");
    }

    @Test
    void createCarByName_메서드에서_null_이름에_대한_예외_처리() {
        String nameWithNull = null;
        assertThatThrownBy(() -> createCarByName(nameWithNull))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null은 이름이 될 수 없습니다");
    }

    @Test
    void moveForwardOrStop_메서드에서_4가_나왔을때_앞으로_이동() {
        try (MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(4);

            Car car = Car.createCarByName("abc");
            car.moveForwardOrStop();

            assertThat(car.getMileageInt()).isEqualTo(1);
        }
    }

    @Test
    void moveForwardOrStop_메서드_에서_3이_나왔을때_멈춤() {
        try (MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(3);

            Car car = Car.createCarByName("abc");
            car.moveForwardOrStop();

            assertThat(car.getMileageInt()).isEqualTo(0);
        }
    }


    @Test
    void toString_메서드로_1번_전진_했을때를_반영한_String_값을_반환() {
        try (MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(4);

            Car car = Car.createCarByName("abc");
            car.moveForwardOrStop();

            assertThat(car.getStatus()).isEqualTo("abc : -");
        }
    }

    @Test
    void toString_메서드로_0번_전진_했을때를_반영한_String_값을_반환() {
        try (MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(3);

            Car car = Car.createCarByName("abc");
            car.moveForwardOrStop();

            assertThat(car.getStatus()).isEqualTo("abc : ");
        }
    }

}