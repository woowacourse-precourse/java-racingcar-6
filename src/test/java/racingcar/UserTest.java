package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserTest {
    User user = new User();

    @Test
    void N대의_자동차_만들기_테스트() {
        // 리스트 cars에 Car 인스턴스가 3개 있는지 확인
        String inputStr = "pobi,woni,jun";
        user.makeCars(inputStr);
        assertThat(user.cars).hasSize(3);
        // 5 글자를 초과하는 자동차 이름이 있으면 예외 발생이 되는지 확인
        String inputStrForException = "pobipobi,woni,jun";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> user.makeCars(inputStrForException));

    }

    private class User {
        private List<Car> cars = new ArrayList<>();
        public void makeCars(String inputStr) {
            String[] carArrayBeforeFiltering = inputStr.split(",");
            for (int i = 0; i < carArrayBeforeFiltering.length; i++) {
                String carName = carArrayBeforeFiltering[i];
                if (carName.length() <= 5) {
                    cars.add(new Car(carName));
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
