package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.GameModel;

import java.util.Arrays;
import java.util.List;

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
}
