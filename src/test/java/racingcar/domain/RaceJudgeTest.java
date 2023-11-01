package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.MoveResult;

class RaceJudgeTest {

    RaceJudge raceJudge = new RaceJudge();
    CarsRepository carsRepository = CarsRepository.getInstance();

    @DisplayName("심판은 레이스할 자동차를 등록합니다.")
    @Test
    void addCars() {
        // given
        List<String> names = List.of("pobi", "jason");
        Cars cars = Cars.from(names);

        // when
        raceJudge.addCars(names);
        Cars findCars = carsRepository.findCars().get();

        // then
        assertThat(findCars).isEqualTo(cars);
    }

    @DisplayName("자동차 이름은 중복될 수 없습니다.")
    @Test
    void addCars_exception_withDuplicateNames() {
        // given
        List<String> names = List.of("pobi", "pobi");

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> raceJudge.addCars(names))
                .withMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("자동차는 4이상의 값이 입력되면 한 칸 전진한다.")
    @Test
    void moveCars() {
        // given
        List<String> names = List.of("pobi", "jason");
        raceJudge.addCars(names);

        // when
        raceJudge.moveCars(() -> 4);
        boolean isMove = raceJudge.createSingleMoveResults()
                .results()
                .stream()
                .map(MoveResult::position)
                .allMatch(number -> number == 1);

        // then
        assertThat(isMove).isTrue();
    }

    @DisplayName("자동차는 4미만의 값이 입력되면 정지한다.")
    @Test
    void moveCars_fail_notEnoughValue() {
        // given
        List<String> names = List.of("pobi", "jason");
        raceJudge.addCars(names);

        // when
        raceJudge.moveCars(() -> 3);
        boolean isStop = raceJudge.createSingleMoveResults()
                .results()
                .stream()
                .map(MoveResult::position)
                .allMatch(number -> number == 0);

        // then
        assertThat(isStop).isTrue();
    }

    @DisplayName("우승자를 찾을 수 있다.")
    @Test
    void findAllWinnerNames() {
        // given
        List<String> names = List.of("pobi", "jason");
        raceJudge.addCars(names);

        // when
        raceJudge.moveCars(() -> 4);
        String winners = raceJudge.findAllWinnerNames().toString();

        // then
        assertThat(winners).isEqualTo("pobi,jason");
    }

    @DisplayName("경주에 참가할 자동차는 반드시 존재해야 합니다.")
    @Test
    void shouldHaveCars_toRace() {
        // given & when
        carsRepository.save(null);

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> raceJudge.moveCars(() -> 4))
                .withMessageContaining("자동차 경주에 참가할 자동차가 없습니다.");
    }
}