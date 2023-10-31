package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class JudgementTest {
    Judgement judgement = new Judgement();

    @Test
    void 우승자_선발_테스트() {
        // given
        List<Car> carList = new ArrayList<>();
        Car c1 = new Car("pobi");
        Car c2 = new Car("woni");
        Car c3 = new Car("jun");
        c1.setPosition(3);
        c2.setPosition(3);
        c3.setPosition(1);
        carList.addAll(List.of(c1, c2, c3));

        // when
        List<String> winners = judgement.selectWinners(carList);

        // then
        Assertions.assertEquals(winners, List.of("pobi", "woni"));
    }

}
