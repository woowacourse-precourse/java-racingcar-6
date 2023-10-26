package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Cars;

import exception.GameInputException;

import message.GameMessage;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 우승자_목록_반환() {
        String[] carNames = {"a","b","c","d"};
        int[] distanceArr = {2,4,1,0};

        Cars cars = new Cars();
        cars.fill(carNames,distanceArr);
        String winner = cars.getWinners();

        assertThat(winner).isEqualTo("b");
    }

    @Test
    void 숫자_정규식_확인() {
        GameInputException gameException = new GameInputException();
        String input = "123456789!";
        assertThatThrownBy(() -> gameException.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.countError.getMessage());
    }

    @Test
    void 이름_길이_확인() {
        GameInputException gameException = new GameInputException();
        String[] names = {"a","a23","abc123"};
        assertThatThrownBy(() -> gameException.validateNameLength(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.nameError.getMessage());
    }
}
