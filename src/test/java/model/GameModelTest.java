package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.GameModel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameModelTest {
    private GameModel gameModel;

    @BeforeEach
    public void setUp() {
        gameModel = new GameModel();
    }

    @Test
    @DisplayName("자동차 이름이 담겨있는 리스트를 Car 객체로 변환한 뒤 리스트로 저장한다")
    public void setCarsTest() {
        // given
        List<String> carNames = Arrays.asList("KWY", "DSH", "ASAP");
        List<Car> response = Arrays.asList(new Car("KWY"), new Car("DSH"), new Car("ASAP"));
        // when
        gameModel.setCars(carNames);
        List<Car> result = gameModel.getCars();
        // then
        assertThat(result).isEqualTo(response);
    }

    @Test
    @DisplayName("해당 라운드에서 move count 값이 4 이상인 자동차는 전진한다")
    public void playRoundTest() {
        // given
        List<String> carNames = Arrays.asList("KWY", "DSH", "ASAP");
        gameModel.setCars(carNames);

        List<Integer> roundMoveNumbers = Arrays.asList(1, 5, 7);
        List<Integer> roundMoveNumbers2 = Arrays.asList(5, 6, 3);
        List<Integer> roundMoveNumbers3 = Arrays.asList(3, 8, 6);
        Queue<List<Integer>> moveNumbers = new LinkedList<>();
        moveNumbers.add(roundMoveNumbers);
        moveNumbers.add(roundMoveNumbers2);
        moveNumbers.add(roundMoveNumbers3);
        // when
        gameModel.playGame(moveNumbers);
        List<Car> result = gameModel.getCars();
        // then
        assertThat(result.get(0).getMoveCount()).isEqualTo(1);
        assertThat(result.get(1).getMoveCount()).isEqualTo(3);
        assertThat(result.get(2).getMoveCount()).isEqualTo(2);
    }
}
