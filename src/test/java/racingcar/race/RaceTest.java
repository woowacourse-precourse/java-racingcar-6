package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        this.race = new Race();
    }

    @Test
    void 차생성_5글자_이상() {
        String carName = "fiveOverLength";

        assertThatThrownBy(() -> race.carAdd(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 글자 수는 1이상 5이하여야 합니다.");
    }

    @Test
    void 차생성_빈이름_포함() {
        String carName = "";

        assertThatThrownBy(() -> race.carAdd(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 글자 수는 1이상 5이하여야 합니다.");
    }

    @Test
    void 차생성() {
        String[] carNames = {"1", "11", "111", "1111"};

        for (String carName : carNames) {
            assertThatCode(() -> race.carAdd(carName))
                    .doesNotThrowAnyException();
        }
    }

    @Test
    void 숫자생성_0입력() {
        String zero = "0";

        assertThatThrownBy(() -> race.setRound(zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수가 아닌 값이 들어왔습니다.");
    }

    @Test
    void 숫자생성_문자() {
        String zero = "안녕";

        assertThatThrownBy(() -> race.setRound(zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수가 아닌 값이 들어왔습니다.");
    }

    @Test
    void 숫자생성_정상입력() {
        String[] numbers = {"1", "12", "100"};

        for (String number : numbers) {
            assertThatCode(() -> race.setRound(number))
                    .doesNotThrowAnyException();
        }
    }

    @Test
    void 우승자찾기_한명만_우승() {
        List<Result> resultList = new ArrayList<>();

        String winner = "jehyuck";
        String loser = "loser";

        Result winnerResult = new Result(winner, 1);
        Result loserResult = new Result(loser, 0);
        resultList.add(winnerResult);
        resultList.add(loserResult);

        List<String> winners = race.findWinner(resultList);
        System.out.println(winners);
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo(winner);
    }

    @Test
    void 우승자찾기_다수명_우승() {
        List<Result> resultList = new ArrayList<>();

        String[] carNames = {"winner1", "winner2", "loser", "winner3"};
        String[] winnerAnswers = {"winner1", "winner2", "winner3"};
        int[] distances = {2, 2, 1, 2};

        for (int i = 0; i < 4; i++) {
            resultList.add(new Result(carNames[i], distances[i]));
        }

        List<String> winners = race.findWinner(resultList);
        assertThat(winners.size())
                .isEqualTo(3);
        for (int i = 0; i < winners.size(); i++) {
            assertThat(winners.get(i))
                    .isEqualTo(winnerAnswers[i]);
        }
    }
}