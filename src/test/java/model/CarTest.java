package model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static final int STANDARD_VALUE = 4;
    private static final int RANDOM_NUMBER = 5;

    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "lisalisa", "jinyjiny"})
    @DisplayName("5글자 이상 이름 입력시 Car객체 생성 예외 발생 테스트")
    void Car_객체_이름_입력_예외_테스트(String input) {
        //given
        String name = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 미만");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("공백 혹은 빈 문자열 이름 입력시 Car객체 생성 예외 발생 테스트")
    void Car_객체_이름_입력_예외_테스트_공백_빈문자열(String input) {
        //given
        String name = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 혹은 빈");
    }

    @Test
    @DisplayName("임의의 수가 기준 값보다 크면 movingCount 증가하는지 테스트")
    void 기준_값_보다_큰_임의의_수_증가_테스트() {
        //given
        Car car = new Car("pobi");
        int movingCount = car.getMovingCount();

        //when
        car.increaseMovingCountIfGreater(STANDARD_VALUE, RANDOM_NUMBER);
        int expectedMovingCount = movingCount + 1;
        int currentMovingCount = car.getMovingCount();

        //then
        Assertions.assertThat(currentMovingCount).isEqualTo(expectedMovingCount);

    }

    @Test
    @DisplayName("서로 다른 Car객체 movingCount가 같으면 true 테스트")
    void 서로_다른_Car_객체_비교_테스트() {
        //given
        Car pobiCar = new Car("pobi");
        Car lisaCar = new Car("lisa");

        //when
        boolean isSame = pobiCar.isSameMovingCount(lisaCar);

        //then
        Assertions.assertThat(isSame).isTrue();
    }

    @Test
    @DisplayName("현재 경주상태 반환 테스트")
    void 현재_경주_상태_테스트() {
        //given
        Car car = new Car("pobi");
        car.increaseMovingCountIfGreater(STANDARD_VALUE, RANDOM_NUMBER);
        car.increaseMovingCountIfGreater(STANDARD_VALUE, RANDOM_NUMBER);
        car.increaseMovingCountIfGreater(STANDARD_VALUE, RANDOM_NUMBER);

        //when
        String currentStatus = car.currentRacingStatus();

        //then
        Assertions.assertThat(currentStatus).isEqualTo("pobi : ---");
    }

    @Test
    @DisplayName("내림차순 정렬 테스트")
    void 내림차순_정렬_테스트() {
        //given
        Car pobiCar = new Car("pobi");
        Car lisaCar = new Car("lisa");
        Car jinyCar = new Car("jiny");
        List<Car> cars = new ArrayList<>();
        String expectedCarName = "lisa";

        lisaCar.increaseMovingCountIfGreater(STANDARD_VALUE, RANDOM_NUMBER);

        cars.add(pobiCar);
        cars.add(lisaCar);
        cars.add(jinyCar);
        //when
        cars.sort(Car::compareTo);
        String currentWinner = cars.get(0).toString();

        //then
        Assertions.assertThat(currentWinner).isEqualTo(expectedCarName);
    }

}
