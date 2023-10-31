package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {
    User user = new User();

    @Order(1)
    @Test
    void N대의_자동차_만들기_테스트() {
        // 리스트 cars에 Car 인스턴스가 3개 있는지 확인
        String inputStr = "pobi,woni,jun";
        user.makeCars(inputStr);
        assertThat(user.getCarList()).hasSize(3);
        // 5 글자를 초과하는 자동차 이름이 있으면 예외 발생이 되는지 확인
        String inputStrForException = "pobipobi,woni,jun";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> user.makeCars(inputStrForException));

    }

    @Order(2)
    @Test
    void 입력_횟수만큼_주행_테스트() {
        int attemptNumber = 5;
        user.tryDriving(attemptNumber);
        // 리스트 cars에 있는 각각의 Car 인스턴스가 길이가 5 이하인 주행거리를 가지고 있는지 확인
        for (Car car : user.getCarList()) {
            assertThat(car.getDistanceDriven()).as("운이 나빠서 '-'가 포함되지 않았어요!").contains("-");
            assertThat(car.getDistanceDriven()).hasSizeLessThanOrEqualTo(5);
        }
    }
}
