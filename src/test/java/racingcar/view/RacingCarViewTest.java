package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.Car.MOVE_CONDITION_MIN_NUMBER;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCar;

class RacingCarViewTest extends IOTest {

    @DisplayName("printStartRacingCar을 호출하면 자동차 이름을 입력하라는 메시지가 출력된다")
    @Test
    void printStartRacingCarMessage() {
        //given
        RacingCarView racingCarView = new RacingCarView();

        //when
        racingCarView.printStartRacingCar();

        //then
        assertThat(getSystemOut()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @DisplayName("printAskNumberOfRetries를 호출하면 횟수를 묻는 메시지가 출력된다")
    @Test
    void printAskingNumberOfRetriesMessage() {
        //given
        RacingCarView racingCarView = new RacingCarView();

        //when
        racingCarView.printAskingNumberOfRetries();

        //then
        assertThat(getSystemOut()).isEqualTo("시도할 회수는 몇회인가요?\n");
    }

    @DisplayName("printResultMessage를 호출하면 실행 결과 메시지가 호출된다")
    @Test
    void printResultPerRacing() {
        //given
        RacingCarView racingCarView = new RacingCarView();

        //when
        racingCarView.printResultMessage();

        //then
        assertThat(getSystemOut()).isEqualTo("실행 결과\n");
    }

    @DisplayName("printCarListMovement를 호출하면 각 자동차별 이동거리가 출력된다")
    @Test
    void printCarListMovement() {
        //given
        RacingCar racingCar = new RacingCar("baek,eun,hee");
        RacingCarView racingCarView = new RacingCarView();
        racingCar.getCars().get(0).moveForward(MOVE_CONDITION_MIN_NUMBER);
        racingCar.getCars().get(0).moveForward(MOVE_CONDITION_MIN_NUMBER);
        racingCar.getCars().get(1).moveForward(MOVE_CONDITION_MIN_NUMBER);
        racingCar.getCars().get(2).moveForward(MOVE_CONDITION_MIN_NUMBER);

        //when
        racingCarView.printCarListMovement(racingCar);

        //then
        assertThat(getSystemOut()).isEqualTo("baek : --\neun : -\nhee : -\n\n");
    }

    @DisplayName("printFinalMessage를 호출하면 최종 우승자가 출력된다")
    @Test
    void printFinalMessage() {
        //given
        List<Car> winners = List.of(new Car("baek"), new Car("eun"));
        RacingCarView racingCarView = new RacingCarView();

        //when
        racingCarView.printFinalMessage(winners);

        //then
        assertThat(getSystemOut()).isEqualTo("최종 우승자 : baek, eun");

    }

}