package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.WinnerNames;

@DisplayName("Position 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinnerNamesTest {

    @Test
    void 생성자는_우승_자동차_리스트가_주어지면_이름을_리스트로_저장한다() {
        List<Car> winners = List.of(new Car(new Name("이하늘")), new Car(new Name("이하늘하이")));

        WinnerNames winnerNames = new WinnerNames(winners);

        Assertions.assertEquals(winnerNames.getNames()[0], "이하늘");
        Assertions.assertEquals(winnerNames.getNames()[1], "이하늘하이");
    }

    @Test
    void getNames_메소드는_이름_리스트를_배열로_변환해_반환한다() {
        List<Car> winners = List.of(new Car(new Name("이하늘")), new Car(new Name("이하늘하이")));

        WinnerNames winnerNames = new WinnerNames(winners);

        Assertions.assertEquals(winnerNames.getNames().length, 2);
    }
}
