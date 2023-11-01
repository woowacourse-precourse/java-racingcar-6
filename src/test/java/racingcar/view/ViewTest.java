package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MovableNumberGenerator;

public class ViewTest {
    @Test
    public void InputView_자동차_이름_입력_화면_테스트() {
        assertThat(InputView.enterCarNamesMessage()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    public void InputView_총_라운드_수_입력_화면_테스트() {
        assertThat(InputView.enterNumberOfRoundsMessage()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    public void OutputView_실행_결과_화면_테스트() {
        assertThat(OutputView.resultHeaderMessage()).isEqualTo("실행 결과");
    }

    @Test
    public void OutputView_현재_자동차들의_전진_상태_화면_테스트() {
        List<Car> carList = new ArrayList<>() {{
            add(new Car("car1"));
            add(new Car("car2"));
            add(new Car("car3"));
        }};
        Cars cars = new Cars(carList);
        // car1: 1칸 전진, car2: 2칸 전진
        cars.get(0).tryToMove(new MovableNumberGenerator());
        cars.get(1).tryToMove(new MovableNumberGenerator());
        cars.get(1).tryToMove(new MovableNumberGenerator());

        String resultMessage = OutputView.currentForwardStateMessage(cars);
        System.out.println(resultMessage);
        assertThat(resultMessage).contains("car1 : -", "car2 : --");
    }

    @Test
    public void OutputView_최종_우승자_화면_테스트() {
        List<Car> carList = new ArrayList<>() {{
            add(new Car("car1"));
            add(new Car("car2"));
            add(new Car("car3"));
        }};
        String resultMessage = OutputView.winnersMessage(new Cars(carList));

        assertThat(resultMessage).contains("최종 우승자 : ", "car1", "car2", "car3");
    }
}
