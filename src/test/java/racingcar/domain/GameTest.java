package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {

    Cars cars;
    Game game;

    @BeforeEach
    void beforeGame() {
        cars = new Cars();
        cars.settingNames("seori,snow,joy");
        game = new Game(cars);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1",
        "1 ",
        " 1",
        " 1 "
    })
    void 시도횟수를_올바르게_입력한_경우(String input) {
        game.settingChance(input);
        assertEquals(1, game.tryChance);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0보다 큰 숫자를 입력해야 합니다.",
        "r,숫자를 입력해야 합니다.",
    })
    void 시도횟수를_잘못_입력한_경우(String input, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> game.settingChance(input));
        assertEquals(e.getMessage(), exceptionMessage);
    }

    @Test
    void 게임_1라운드_결과가_Map으로_저장된다() {
        game.running();
        Map<String, Integer> gameResult = game.getGameResult();
        ArrayList<String> carNames = new ArrayList<>();

        for(Car car : game.getCars().getCarList()) {
            carNames.add(car.getName());
        }
        Set<String> resultKey = gameResult.keySet();

        assertEquals(resultKey.size(), carNames.size());
        assertTrue(resultKey.containsAll(carNames));
    }

}