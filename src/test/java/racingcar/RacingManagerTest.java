package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.number_generator.NumberGenerator;
import racingcar.records.RacingCarSnapshot;
import racingcar.records.RacingHistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

public class RacingManagerTest {
    @Test
    void 올바른_입력이_주어졌을_때_정상적으로_racing_manager_인스턴스가_생성된다() {
        String validCarsNameInput = "pobi,woni,jun";
        String validRacingCountInput = "3";

        RacingManager racingManager = new RacingManager(validCarsNameInput, validRacingCountInput);

        assertThat(racingManager.getMoveCount()).isEqualTo(3);
        assertThat(racingManager.getRacingCars())
                .hasSize(3)
                .extracting(RacingCar::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 올바르지_않은_cars_name이_주어지면_예외가_발생한다() {
        String invalidCarsNameInput = "";
        String validRacingCountInput = "3";

        assertThatThrownBy(() -> new RacingManager(invalidCarsNameInput, validRacingCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름들을 입력해주세요.");
    }

    @Test
    void 올바르지_않은_racingCount가_주어지면_예외가_발생한다() {
        String validCarsNameInput = "pobi,woni,jun";

        String emptyCountInput = "";
        assertThatThrownBy(() -> new RacingManager(validCarsNameInput, emptyCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수를 입력해주세요.");

        String zeroCountInput = "0";
        assertThatThrownBy(() -> new RacingManager(validCarsNameInput, zeroCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 1이상이어야 합니다.");

        String nonNumberCountInput = "string";
        assertThatThrownBy(() -> new RacingManager(validCarsNameInput, nonNumberCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 숫자여야 합니다.");
    }

    @Test
    void start_race_시_차들의_forward_count가_정상적으로_증가한다() {
        String validCarsNameInput = "pobi,woni";
        String validRacingCountInput = "2";

        int forward = RacingCar.MAX_MOVE_WEIGHT;
        int stop = RacingCar.MIN_MOVE_WEIGHT;
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(forward, stop, forward, stop);

        RacingManager racingManager = new RacingManager(validCarsNameInput, validRacingCountInput, fixedNumberGenerator);

        racingManager.startRace();
        assertThat(racingManager.getRacingCars())
                .extracting(RacingCar::getForwardCount)
                .containsExactly(2, 0);
    }

    @Test
    void start_race_시_racing의_history가_저장된다() {
        String validCarsNameInput = "pobi,woni";
        String validRacingCountInput = "2";

        int forward = RacingCar.MAX_MOVE_WEIGHT;
        int stop = RacingCar.MIN_MOVE_WEIGHT;
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(forward, forward, forward, stop);

        RacingManager racingManager = new RacingManager(validCarsNameInput, validRacingCountInput, fixedNumberGenerator);

        racingManager.startRace();
        List<RacingHistory> racingResult = racingManager.getRacingResult();

        assertThat(racingResult).hasSize(2);

        RacingHistory firstHistory = racingResult.get(0);
        assertThat(firstHistory.snapshots())
                .extracting(RacingCarSnapshot::name, RacingCarSnapshot::forwardCount)
                .containsExactly(tuple("pobi", 1), tuple("woni", 1));

        RacingHistory secondHistory = racingResult.get(1);
        assertThat(secondHistory.snapshots())
                .extracting(RacingCarSnapshot::name, RacingCarSnapshot::forwardCount)
                .containsExactly(tuple("pobi", 2), tuple("woni", 1));
    }
}

class FixedNumberGenerator implements NumberGenerator {
    private final List<Integer> fixedNumberList;

    public FixedNumberGenerator(Integer... numbers) {
        fixedNumberList = new ArrayList<>(Arrays.asList(numbers));
    }

    @Override
    public int generate(int min, int max) {
        if (fixedNumberList.isEmpty()) {
            return -1;
        } else {
            return fixedNumberList.remove(0);
        }
    }
}
