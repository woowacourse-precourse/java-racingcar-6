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
import racingcar.domain.CarName;
import racingcar.domain.CarNames;
import racingcar.domain.GamePlayer;
import racingcar.domain.GameWinner;

public class GameServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final GameService gameService = new GameService();


    @ParameterizedTest
    @MethodSource
    public void 자동차_이름으로_플레이어_생성_검증(List<CarName> input) {
        //given
        CarNames carNames = CarNames.fromInput(input);
        //when
        GamePlayer gamePlayer = gameService.createGamePlayer(carNames);
        List<String> expectedResult = input.stream()
                .map(CarName::getValue)
                .toList();
        List<String> result = gamePlayer.getCars().stream()
                .map(Car::getName).toList();
        //then
        for (int i = 0; i < input.size(); i++) {
            assertThat(result.get(i)).isEqualTo(expectedResult.get(i));
        }
    }

    private static Stream<Arguments> 자동차_이름으로_플레이어_생성_검증() {
        return Stream.of(
                Arguments.of(new ArrayList(
                        Arrays.asList(new CarName("name1"), new CarName("name2"), new CarName("name3")))),
                Arguments.of(new ArrayList(
                        Arrays.asList(new CarName("a"), new CarName("b"), new CarName("c")))),
                Arguments.of(new ArrayList(
                        Arrays.asList(new CarName("김"), new CarName("이"), new CarName("박"))))
        );
    }


    @ParameterizedTest
    @MethodSource
    public void 자동차_랜덤값에_의한_이동(List<Integer> moveCondition, List<Integer> expectedResult) {
        //given
        CarNames carNames = CarNames.fromInput(
                new ArrayList<>(Arrays.asList(new CarName("name1"), new CarName("name2"), new CarName("name3"))));
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

    private static Stream<Arguments> 자동차_랜덤값에_의한_이동() {
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
    public void 게임플레이어_정보로_우승자_생성(List<Integer> moveCondition, String expectedResult) {
        //given
        CarNames carNames = CarNames.fromInput(
                new ArrayList<>(Arrays.asList(new CarName("name1"), new CarName("name2"), new CarName("name3"))));
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

    private static Stream<Arguments> 게임플레이어_정보로_우승자_생성() {
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
