package racingcar.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import racingcar.game.car.Car;
import racingcar.game.storage.CarStorage;

class GameTest {
    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 3;
    CarStorage carStorage;
    Game game;

    @BeforeEach
    void setUp() {
        carStorage = new CarStorage();
        game = new Game(carStorage);
    }

    @Test
    @DisplayName("전달 받은 자동차 이름 리스트가 빈 리스트일 때 실패해야한다.")
    void test_SetUpFailed_EmptyStringList() {
        //given
        List<String> carNames = Collections.emptyList();

        //when & then
        assertThatThrownBy(() -> game.setUp(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 자동차가 없습니다.");
    }

    @Test
    @DisplayName("전달 받은 자동차 이름 리스트에 중복된 이름이 있을 경우 실패해야한다.")
    void test_SetUpFailed_DuplicateName() {
        //given
        List<String> carNames = List.of("car1", "car2", "car1");

        //when & then
        assertThatThrownBy(() -> game.setUp(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    @DisplayName("문제 없는 자동차 이름 리스트를 전달 받으면 게임 셋업을 성공한다.")
    void test_SetUpSuccessFul() {
        //given
        List<String> carNames = List.of("car1", "car2");

        //when
        List<Car> savedCars = game.setUp(carNames);

        //then
        assertThat(savedCars).hasSize(2);
    }

    @Test
    @DisplayName("전달 받은 시도 횟수만큼 시도해서 게임을 진행한다.")
    void test_PlayAllSuccessful() {
        //given
        List<String> carNames = List.of("car1", "car2");
        game.setUp(carNames);
        int trials = 2;

        //when
        Executable playAll = () -> {
            List<GameProgress> gameResult = game.playAll(trials);
            assertThat(gameResult.get(0).convertResultToString()).contains("car2 : -");
            assertThat(gameResult.get(1).convertResultToString()).contains("car2 : --");
        };

        //then
        assertRandomNumberInRangeTest(playAll, MOVE_FORWARD, STOP, MOVE_FORWARD, STOP);
    }

    @Test
    @DisplayName("우승자를 찾을 때 저장된 자동차가 없으면 예외를 반환해야한다.")
    void test_GetWinnersFailed_NoCarsStored() {
        assertThatThrownBy(() -> game.getWinners())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("저장된 자동차가 없습니다");
    }

    @Test
    @DisplayName("우승자가 하나 밖에 없을 땐 크기가 하나인 리스트를 반환해야한다.")
    void test_GetWinnersSuccessful_OnlyOneWinner() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 1);
        carStorage.saveCar(car1);
        carStorage.saveCar(car2);

        //when
        List<Car> winners = game.getWinners();

        //then
        assertThat(winners).hasSize(1).containsOnly(car1);
    }

    @Test
    @DisplayName("우승자가 두대 이상일 땐 크기가 우승자 수 만큼의 리스트를 반환해야한다.")
    void test_GetWinnersSuccessful_MultipleWinners() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);
        carStorage.saveCar(car1);
        carStorage.saveCar(car2);
        carStorage.saveCar(car3);

        //when
        List<Car> winners = game.getWinners();

        //then
        assertThat(winners).hasSize(2).contains(car1, car3);
    }
}
