package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import service.CarService;

import exception.GameInputException;

import message.GameMessage;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 우승자_목록_반환() {
        String[] carNames = {"a","b","c","d"};
        int[] distanceArr = {2,4,1,0};

        CarService carService = CarService.getInstance();
        carService.fill(carNames,distanceArr);
        String winner = carService.getWinners();

        assertThat(winner).isEqualTo("b");
        carService.close();
    }

    @Test
    void 숫자_정규식_확인() {
        GameInputException gameException = GameInputException.getInstance();
        String input = "123456789!";
        assertThatThrownBy(() -> gameException.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.countError.getMessage());
    }

    @Test
    void 이름_길이_확인() {
        GameInputException gameException = GameInputException.getInstance();
        String[] names = {"a","a23","abc123"};
        assertThatThrownBy(() -> gameException.validateNameLength(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.nameError.getMessage());
    }

    @Test
    void 회수_첫숫자_0_체크() {
        GameInputException gameException = GameInputException.getInstance();
        String input = "01";
        assertThatThrownBy(() -> gameException.validateNumberZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.countError.getMessage());
    }
}
