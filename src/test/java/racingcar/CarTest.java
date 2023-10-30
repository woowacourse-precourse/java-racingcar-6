package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.utils.Random;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("전진 조건을 올바르게 판단하는가? - 멈춘다")
    void test(int number) {
        System.out.println(number);
        assertThat(Random.isConditionsAdvancementMet(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("전진 조건을 올바르게 판단하는가? - 전진한다")
    void test2(int number) {
        assertThat(Random.isConditionsAdvancementMet(number)).isTrue();
    }

    @Test
    @DisplayName("n대의 자동차는 전진 또는 멈출 수 있는가?")
    void car_자동차_전진_테스트() {
        List<String> names = List.of("pobi", "java");
        int attempt = 3;
        Car cars = new Car(names, attempt);
        List<Integer> randoms = List.of(4, 1);

        for(int i = 0 ; i < names.size(); i++) {
            cars.setMileage(randoms.get(i), i);
        }

        assertThat(cars.getMileage()).isEqualTo(List.of(1,0));
    }
}
