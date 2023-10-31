package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameTest {

    @Test
    public void 게임_횟수입력_성공() {
        String carNames = "pobi,woni,jun";
        String attempts = "5";

        // 생성자 호출 시 예외가 발생하지 않는다면 성공
        Game game = new Game(carNames, attempts);

        assertThat(game.getAttempts()).isEqualTo(5);
    }

    @Test
    public void 게임_횟수입력_실패() {
        String carNames = "pobi,woni,jun";
        String attemptsString = "five";  // 숫자가 아닌 문자열
        String attemptsNegative = "-3";  // 음수

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Game(carNames, attemptsString))
                .withMessage("시도 횟수는 숫자로 입력되어야 합니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Game(carNames, attemptsNegative))
                .withMessage("시도 횟수는 양수여야 합니다.");
    }

    @Test
    public void 우승자_출력() {
        Game game = new Game("pobi,woni,jun", "1");
        game.getCars().get(0).move(4);
        game.getCars().get(0).move(4);

        String winners = game.printWinner();

        assertThat(winners).isEqualTo("pobi");
    }

    @Test
    public void 우승자_여러명_출력() {
        Game game = new Game("pobi,woni,jun", "1");
        List<Car> cars = game.getCars();
        int i = 0;

        for (Car car : cars) {
            if (car.getPosition() != 0) {
                game.getCars().get(i).move(4);
                game.getCars().get(i).move(4);
            } else {
                game.getCars().get(i).move(4);
            }
            i++;
        }

        String winners = game.printWinner();

        assertThat(winners).isEqualTo("pobi, woni, jun");
    }

}