package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameServiceTest {

    private GameService gameService;
    private final int MOVING_FORWARD = 4;
    private final int STOP = 3;

    @BeforeEach
    public void setUp() {
        gameService = new GameService();
    }

    @Test
    public void initGame_게임_변수_초기화(){
        //given
        Set<String> cars = Set.of("pobi", "woni","jun");

        //when
        gameService.initGame(cars);

        //then
        gameService.getCars().forEach(car -> {
            assertThat(car.getPosition()).isEqualTo(0);
            assertThat(car.getName()).isIn(cars);
        });
    }

    @Test
    public void convertInputCarNamesToSet_입력받은_자동차_이름들을_Set_변환(){
        //given
        String inputCarNames = "pobi,woni,jun";

        //when
        Set<String> result = gameService.convertInputCarNamesToSet(inputCarNames);

        //then
        assertThat(result).containsOnly("pobi", "woni", "jun");
    }

    @Test
    public void convertInputCarNamesToSet_자동차_이름_5글자_초과_예외_발생(){
        //given
        String inputCarNames = "pobi,woni,jun,hoony0321";

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> gameService.convertInputCarNamesToSet(inputCarNames));
    }

    @Test
    public void convertInputCarNamesToSet_중복된_자동차_이름_예외_발생(){
        //given
        String inputCarNames = "pobi,woni,jun,pobi";

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> gameService.convertInputCarNamesToSet(inputCarNames));
    }

    @Test
    public void convertInputTryCountToInt_입력받은_시도횟수_int_변환(){
        //given
        String inputTryCount = "5";

        //when
        int result = gameService.convertInputTryCountToInt(inputTryCount);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void convertInputTryCountToInt_시도횟수_0_이하_예외_발생() {
        //given
        String inputTryCount = "0";

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> gameService.convertInputTryCountToInt(inputTryCount));
    }

    @Test
    public void convertInputTryCountToInt_시도횟수_숫자_변환_불가능_예외_발생(){
        //given
        String inputTryCount = "a";

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> gameService.convertInputTryCountToInt(inputTryCount));
    }

    @Test
    public void playGame_게임_진행(){
        //given
        gameService.setCars(new ArrayList<>(List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        )));

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    gameService.playGame();
                },
                MOVING_FORWARD,MOVING_FORWARD,STOP
        );

        //then
        List<Car> carList = gameService.getCars();
        assertThat(carList.stream().filter(car -> car.getName().equals("pobi")).findFirst().get().getPosition()).isEqualTo(1);
        assertThat(carList.stream().filter(car -> car.getName().equals("woni")).findFirst().get().getPosition()).isEqualTo(1);
        assertThat(carList.stream().filter(car -> car.getName().equals("jun")).findFirst().get().getPosition()).isEqualTo(0);
    }

    @Test
    public void getWinners_최종_우승자_단일_반환(){
        //given
        gameService.setCars(new ArrayList<>(List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        )));

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    gameService.playGame();
                    gameService.playGame();
                    gameService.playGame();
                },
                MOVING_FORWARD,MOVING_FORWARD,STOP,
                MOVING_FORWARD,STOP,STOP,
                MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD
        );

        //then
        assertThat(gameService.getWinners().size()).isEqualTo(1);
        assertThat(gameService.getWinners().get(0).getName()).isEqualTo("pobi");
    }

    @Test
    public void getWinners_최종_우승자_여러명_반환(){
        //given
        gameService.setCars(new ArrayList<>(List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        )));

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    gameService.playGame();
                    gameService.playGame();
                    gameService.playGame();
                },
                MOVING_FORWARD,MOVING_FORWARD,STOP,
                MOVING_FORWARD,MOVING_FORWARD,STOP,
                MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD
        );

        //then
        assertThat(gameService.getWinners().size()).isEqualTo(2);
        assertThat(gameService.getWinners().get(0).getName()).isEqualTo("pobi");
        assertThat(gameService.getWinners().get(1).getName()).isEqualTo("woni");
    }
}
