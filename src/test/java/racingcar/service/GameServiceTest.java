package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.GamePlayer;
import racingcar.domain.GameWinner;

public class GameServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final GameService gameService = new GameService();

    @ParameterizedTest
    @MethodSource
    public void 입력받은_값들로_자동차를_생성한다(String input) {
        //given
        CarNames carNames = CarNames.fromInput(input);
        //when
        List<Car> cars = carNames.createCars();
        StringBuilder result = new StringBuilder("");
        for (Car car : cars) {
            result.append(car.getName()).append(",");
        }
        //then
        assertThat(result.toString()).contains(input);
    }

    private static Stream<Arguments> 입력받은_값들로_자동차를_생성한다() {
        return Stream.of(
                Arguments.of("name1,name2,name3"),
                Arguments.of("a,b,c"),
                Arguments.of("김,이,박")
        );
    }

    @ParameterizedTest
    @MethodSource
    public void 자동차_이름으로_플레이어_생성_검증(String input) {
        //given
        CarNames carNames = CarNames.fromInput(input);
        //when
        GamePlayer gamePlayer = gameService.createGamePlayer(carNames);
        List<Car> cars = gamePlayer.getCars();
        StringBuilder result = new StringBuilder("");
        for (Car car : cars) {
            result.append(car.getName()).append(",");
        }
        //then
        assertThat(result.toString()).contains(input);
    }

    private static Stream<Arguments> 자동차_이름으로_플레이어_생성_검증() {
        return Stream.of(
                Arguments.of("name1,name2,name3"),
                Arguments.of("1,2,3"),
                Arguments.of("김,이,박")
        );
    }


    @ParameterizedTest
    @MethodSource
    public void 모든_자동차를_이동_시킨다(List<Integer> moveCondition, List<Integer> expectedResult) {
        //given
        CarNames carNames = CarNames.fromInput("name1,name2,name3");
        GamePlayer gamePlayer = gameService.createGamePlayer(carNames);
        //when
        assertRandomNumberInRangeTest(
                () -> {
                    gameService.moveCars(gamePlayer);
                },
                moveCondition.get(0), moveCondition.get(1), moveCondition.get(2)
        );
        List<Car> cars = gamePlayer.getCars();
        //then
        assertThat(cars.get(0).getMoveDistance()).isEqualTo(expectedResult.get(0));
        assertThat(cars.get(1).getMoveDistance()).isEqualTo(expectedResult.get(1));
        assertThat(cars.get(2).getMoveDistance()).isEqualTo(expectedResult.get(2));
    }

    private static Stream<Arguments> 모든_자동차를_이동_시킨다() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(Arrays.asList(MOVING_FORWARD, STOP, STOP)),
                        new ArrayList<>(Arrays.asList(1, 0, 0))
                ),
                Arguments.of(
                        new ArrayList<>(Arrays.asList(MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD)),
                        new ArrayList<>(Arrays.asList(1, 1, 1))
                ),
                Arguments.of(
                        new ArrayList<>(Arrays.asList(STOP, STOP, MOVING_FORWARD)),
                        new ArrayList<>(Arrays.asList(0, 0, 1))
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    public void 가장_높은_점수와_같은_점수를_갖고있는_자동차들을_구한다(List<Integer> moveCondition, String expectedResult) {
        //given
        CarNames carNames = CarNames.fromInput("name1,name2,name3");
        GamePlayer gamePlayer = gameService.createGamePlayer(carNames);
        //when
        assertRandomNumberInRangeTest(
                () -> {
                    gameService.moveCars(gamePlayer);
                },
                moveCondition.get(0), moveCondition.get(1), moveCondition.get(2)
        );
        List<Car> cars = gamePlayer.getCars();
        GameWinner gameWinner = gameService.createGameWinner(gamePlayer);
        String result = gameWinner.getNames();
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> 가장_높은_점수와_같은_점수를_갖고있는_자동차들을_구한다() {
        return Stream.of(
                Arguments.of(new ArrayList(Arrays.asList(MOVING_FORWARD, STOP, STOP)), "name1"),
                Arguments.of(new ArrayList(Arrays.asList(MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD)),
                        "name1, name2, name3"),
                Arguments.of(new ArrayList(Arrays.asList(STOP, STOP, MOVING_FORWARD)), "name3")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
