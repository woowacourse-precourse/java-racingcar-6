package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarPlayer;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameServiceTest {

    private final GameService game = new GameService();
    private final List<String> carList= new ArrayList<>();

    @Test
    void 시도_횟수_예외_처리(){
        assertThrows(IllegalArgumentException.class, () -> game.validateCount("a") );
        assertThatThrownBy(() -> game.validateCount("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 정수값으로 입력해야합니다.");
    }
    @Test
    void 이름이_5자_초과_예외_처리(){
        carList.add("abcdefg");
        assertThatThrownBy(() -> game.validateNames(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 5자를 초과할 수 없습니다.");
        carList.clear();
    }
    @Test
    void 이름이_공백_예외_처리(){
        carList.add("");
        assertThatThrownBy(() -> game.validateNames(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 공백일 수 없습니다.");
        carList.clear();
    }

    @Test
    void 차_이름_저장_확인(){
        carList.add("1번차");
        carList.add("2번차");
        List<CarPlayer> newCarList = game.saveCarNames(carList);
        assertThat(newCarList.get(0).getName()).isEqualTo("1번차");
        carList.clear();
    }

    @Test
    void 점수_갱신_확인(){
        carList.add("1번차");
        carList.add("2번차");
        List<CarPlayer> newCarList = game.saveCarNames(carList);
        for(CarPlayer player : newCarList) {
            System.out.print(player.getName());
            System.out.println(player.getScore());
        }
        game.updateCarScore(newCarList);
        for(CarPlayer player : newCarList) {
            System.out.print(player.getName());
            System.out.println(player.getScore());
        }
        carList.clear();
    }
    @Test
    void 우승자_확인(){
        carList.add("1번차");
        carList.add("2번차");
        List<CarPlayer> newCarList = game.saveCarNames(carList);
        newCarList.get(0).setScore();
        String winner = game.checkFinalScores(newCarList);
        assertThat(winner).isEqualTo("1번차");
    }
}
