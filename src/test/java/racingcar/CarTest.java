package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    @DisplayName("생성자를 통해서 변수 초기화가 되는가?")
    void testCarConstructor(){
        Car car1 = new Car("페라리");
        Car car2 = new Car("우테코");

        String result1_Name = car1.toString();
        int result1_TotalDistance = car1.getTotalDistance();
        String result2_Name = car2.toString();
        int result2_TotalDistance = car2.getTotalDistance();

        assertThat(result1_Name).isEqualTo("페라리");
        assertThat(result1_TotalDistance).isEqualTo(0);
        assertThat(result2_Name).isEqualTo("우테코");
        assertThat(result2_TotalDistance).isEqualTo(0);
    }
}
