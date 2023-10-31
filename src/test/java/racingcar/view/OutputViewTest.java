package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    @DisplayName("차 이동 성공 횟수만큼 레이싱 게임의 결과를 출력하는 기능을 테스트한다.")
    void printGameResult_successful() {
        /**
         * given : 이름과 이동 횟수를 담은 Car 객체를 생성하여 List에 담는다.
         * when : StringBuilder에 Car의 이름과 이동횟수('-')를 삽입한다.
         * then : StringBuilder에 저장된 문자열과 예상값을 비교하여 같은지 확인한다.
         */
        List<Car> carNames = List.of(
                new Car("rome", 3),
                new Car("seoul", 2),
                new Car("tokyo", 1)
        );

        StringBuilder sb = new StringBuilder();
        for (Car car : carNames) {
            String movingDistance = "-".repeat(car.getMovingCount());
            sb.append(car.getName() + " : " + movingDistance + "\n");
        }
        String result = sb.toString();
        String expected = """
            rome : ---
            seoul : --
            tokyo : -
            """;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("최종 우승자를 한 명을 출력하는 기능을 테스트한다.")
    void printGameWinner_successful_oneWinner() {
        /**
         * given : 최종 우승자를 담은 List를 생성한다.
         * when : String.join()을 이용하여 최종 우승자를 String에 담는다.
         * then : 우승자가 담긴 String과 예상값을 비교하여 같은지 확인한다.
         */
        List<String> gameWinner = List.of("rome");

        String winnerNames = String.join(", ", gameWinner);
        String result = "최종 우승자 : " + winnerNames;
        String expected = "최종 우승자 : rome";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("공동 우승자를 두 명을 출력하는 기능을 테스트한다.")
    void printGameWinner_successful_twoWinner() {
        /**
         * given : 최종 우승자를 담은 List를 생성한다.
         * when : String.join()을 이용하여 최종 우승자를 String에 담는다.
         * then : 우승자가 담긴 String과 예상값을 비교하여 같은지 확인한다.
         */
        List<String> gameWinner = List.of("rome", "seoul");

        String winnerNames = String.join(", ", gameWinner);
        String result = "최종 우승자 : " + winnerNames;
        String expected = "최종 우승자 : rome, seoul";

        assertThat(result).isEqualTo(expected);
    }
}