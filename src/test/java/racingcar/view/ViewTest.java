package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class ViewTest extends NsTest {

    @DisplayName("단독 우승자를 출력하는 테스트")
    @Test
    void printFinalWinner() {
        //given
        List<String> winners = List.of("pobi");

        //when
        OutputView.printFinalWinner(winners);

        //then
        assertThat(output()).isEqualTo("최종 우승자 : pobi");
    }

    @DisplayName("공동 우승자 목록을 출력하는 테스트")
    @Test
    void printFinalWinners() {
        //given
        List<String> winners = List.of("pobi,dui");

        //when
        OutputView.printFinalWinner(winners);

        //then
        assertThat(output()).isEqualTo("최종 우승자 : pobi,dui");
    }

    @DisplayName("차수별 실행 결과를 출력하는 기능 테스트")
    @Test
    void printResult() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("dui");

        car1.move(2);
        car2.move(4);
        List<Car> carList = List.of(car1, car2);

        //when
        OutputView.printResult(carList);

        //then
        assertThat(output()).isEqualTo("pobi : --\ndui : ----");
    }

    @Override
    protected void runMain() {

    }
}
