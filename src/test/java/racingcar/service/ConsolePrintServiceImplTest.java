package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class ConsolePrintServiceImplTest extends NsTest {
    ConsolePrintServiceImpl printService = new ConsolePrintServiceImpl();

    @DisplayName("이름 입력 안내 문구 출력")
    @Test
    void printInputNameNotice() {
        printService.printInputNameNotice();
        assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @DisplayName("횟수 입력 안내 문구 출력")
    @Test
    void printInputCountNotice() {
        printService.printInputCountNotice();
        assertThat(output()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @DisplayName("실행 결과 문구 출력")
    @Test
    void printResultNotice() {
        printService.printResultNotice();
        assertThat(output()).isEqualTo("실행 결과");
    }

    @DisplayName("게임 결과 출력")
    @Test
    void printGameResult() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");
        Car carD = new Car("carD");

        carA.forward();
        carA.forward();
        carC.forward();

        List<Car> carList = List.of(carA, carB, carC, carD);

        printService.printGameResult(carList);

        //왜 마지막 공백은 출력 안되는거지..?
        assertThat(output()).contains("carA : --", "carB : ", "carC : -", "carD :");
    }

    @DisplayName("최종 우승자 출력")
    @Test
    void printFinalGameResult() {
        List<String> winnerList = List.of("carA", "carD");
        printService.printFinalGameResult(winnerList);
        assertThat(output()).isEqualTo("최종 우승자 : carA, carD");
    }

    @Override
    protected void runMain() {

    }
}