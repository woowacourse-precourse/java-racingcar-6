package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameTest {
    private Game game;
    private List<RacingCar> racingCars;

    private void createSingleWinner(RacingCar winner, String score) {
        for(int i = 0; i < score.length(); i++){
            game.updateStatus(winner, () -> Randoms.pickNumberInRange(4, 9) );
        }
    }

    private void createMultipleWinner(List<RacingCar> winners, String score) {
        for (RacingCar winner : winners) {
            createSingleWinner(winner, score);
        }
    }

    @BeforeEach
    void setUp() {
        racingCars = Arrays.asList(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun"));
        game = Game.createByRacingCars(racingCars);
    }

    @DisplayName("자동차 별 점수를 초기화 할 수 있다")
    @Test
    void create(){
        String expected = "pobi : \n" + "woni : \n" + "jun : \n";
        assertThat(game.toString()).isEqualTo(expected);
    }

    @DisplayName("중복된 이름을 가진 자동차가 있을 시 예외가 발생한다")
    @Test
    void validateDuplicate(){
        List<RacingCar> duplicateCars = Arrays.asList(new RacingCar("pobi"), new RacingCar("pobi"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Game.createByRacingCars(duplicateCars));
    }


    @DisplayName("자동차 경주 게임의 자동차 별 점수를 최신화 할 수 있다.")
    @ParameterizedTest
    @MethodSource("updatedData")
    void update(RacingCar racingCar, String output) {
        game.updateStatus(racingCar, () -> Randoms.pickNumberInRange(4, 9));
        assertThat(game.toString()).isEqualTo(output);
    }

    @DisplayName("우승자가 한명인 경우 누가 우승했는지 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"---:pobi", "--:woni", "-:jun"}, delimiter = ':')
    void getWinner(String score, String expectedWinner) {
        createSingleWinner(new RacingCar(expectedWinner), score);
        List<RacingCar> result = game.findWinners();
        Assertions.assertAll(
                () -> assertThat(result.size()).isEqualTo(1),
                () -> assertThat(result.get(0)).isEqualTo(new RacingCar(expectedWinner))
        );
    }

    @DisplayName("우승자가 여러명인 경우 누가 우승했는지 알 수 있다.")
    @ParameterizedTest
    @MethodSource("winnerData")
    void getMultipleWinner(String score, List<RacingCar> expectedWinners) {
        createMultipleWinner(expectedWinners, score);
        List<RacingCar> result = game.findWinners();
        Assertions.assertAll(
                () -> assertThat(result.size()).isEqualTo(expectedWinners.size()),
                () -> assertThat(result).containsAll(expectedWinners)
        );
    }

    static Stream<Arguments> updatedData() {
        return Stream.of(
                arguments(new RacingCar("pobi"), "pobi : -\n" + "woni : \n" + "jun : \n"),
                arguments(new RacingCar("woni"), "pobi : \n" + "woni : -\n" + "jun : \n"),
                arguments(new RacingCar("jun"), "pobi : \n" + "woni : \n" + "jun : -\n")
        );
    }

    static Stream<Arguments> winnerData() {
        return Stream.of(
                arguments("---", Arrays.asList(new RacingCar("pobi"), new RacingCar("woni"))),
                arguments("--", Arrays.asList(new RacingCar("pobi"), new RacingCar("jun"))),
                arguments("---", Arrays.asList(new RacingCar("pobi"), new RacingCar("jun"), new RacingCar("woni")))
        );
    }
}