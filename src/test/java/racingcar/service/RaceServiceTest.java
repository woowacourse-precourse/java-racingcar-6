package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

public class RaceServiceTest extends NsTest {

    RaceService raceService = new RaceService();

    private List<Car> createListOfCars() {
        return List.of(
                new Car("a"),
                new Car("b"),
                new Car("c")
        );
    }

    @Test
    void 레이스_저장_확인() {
        Race race = new Race(createListOfCars(), 3);
        raceService.playARace(race);
        Long id1 = raceService.saveRace(race);
        assertEquals(id1, 0L);

        Race newRace = new Race(createListOfCars(), 3);
        raceService.playARace(newRace);
        Long id2 = raceService.saveRace(newRace);
        assertEquals(id2, 1L);
    }

    @Test
    void 레이스_수_프로세싱_확인() {
        String numRacesInput = "3";
        assertEquals(raceService.processNumRaces(numRacesInput), 3);
    }

    @Test
    void 레이스_수_프로세싱_1_미만_오류() {
        String zeroNumRacesInput = "0";
        String negativeNumRacesInput = "-1";
        assertThrows(IllegalArgumentException.class, () -> raceService.processNumRaces(zeroNumRacesInput));
        assertThrows(IllegalArgumentException.class, () -> raceService.processNumRaces(negativeNumRacesInput));
    }

    @Test
    void 레이스_수_프로세싱_숫자_아님_오류() {
        String letterNumRacesInput = "abc";
        assertThrows(IllegalArgumentException.class, () -> raceService.processNumRaces(letterNumRacesInput));
    }

    @Test
    void 자동차_이름_프로세싱_확인() {
        String carNamesInput = "a,b,c";
        assertEquals(raceService.processCarNames(carNamesInput), List.of("a", "b", "c"));
    }

    @Test
    void 자동차_이름_프로세싱_공백있음_오류() {
        String carNamesInput = "a bc";
        assertThrows(IllegalArgumentException.class, () -> raceService.processCarNames(carNamesInput));
    }

    @Test
    void 자동차_이름_프로세싱_쉼표로_끝남_오류() {
        String carNamesInput = "abc,";
        assertThrows(IllegalArgumentException.class, () -> raceService.processCarNames(carNamesInput));
    }

    @Test
    void 자동차_이름_프로세싱_연속_쉼표_오류() {
        String carNamesInput = "ab,,c";
        assertThrows(IllegalArgumentException.class, () -> raceService.processCarNames(carNamesInput));
    }

    @Test
    void 자동차_이름_프로세싱_중복_오류() {
        String carNamesInput = "a,b,a";
        assertThrows(IllegalArgumentException.class, () -> raceService.processCarNames(carNamesInput));
    }

    @Test
    void 자동차_이름_프로세싱_5자_초과_오류() {
        String carNamesInput = "123456";
        assertThrows(IllegalArgumentException.class, () -> raceService.processCarNames(carNamesInput));
    }

    @Override
    protected void runMain() {
    }
}
