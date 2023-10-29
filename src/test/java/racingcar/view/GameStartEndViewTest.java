//package racingcar.view;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import racingcar.OutputTestSupport;
//import racingcar.domain.car.Car;
//import racingcar.domain.car.RaceCars;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//import static racingcar.constants.MessageConstants.ATTEMPT_COUNT_MESSAGE;
//import static racingcar.constants.MessageConstants.START_MESSAGE;
//
//class GameStartEndViewTest extends OutputTestSupport {
//
//    GameStartEndView gameStartEndView = new GameStartEndView();
//
//    @Test
//    @DisplayName("시작 메시지를 출력할 수 있다.")
//    public void printStartMessage() {
//        // given // when
//        gameStartEndView.printStartMessage();
//        // then
//        assertThat(outputWithoutTrim()).isEqualTo(START_MESSAGE);
//    }
//
//    @Test
//    @DisplayName("시도할 횟수를 물어보는 메시지를 출력할 수 있다.")
//    public void printAttemptCountMessage() {
//        // given // when
//        gameStartEndView.printAttemptCountMessage();
//        // then
//        assertThat(outputWithoutTrim()).isEqualTo(ATTEMPT_COUNT_MESSAGE);
//    }
//
//    @Test
//    @DisplayName("최종 우승한 자동차의 이름을 출력할 수 있다.")
//    public void printWinningCarNames() {
//        // given
//        String name = "haen";
//        RaceCars raceCars = new RaceCars(List.of(new Car(name)));
//        String winningCarNames = raceCars.getWinningCarNames();
//        // when
//        gameStartEndView.printWinningCarNames(winningCarNames);
//        // then
//        assertThat(outputWithoutTrim()).isEqualTo("최종 우승자 : " + name);
//    }
//
//}