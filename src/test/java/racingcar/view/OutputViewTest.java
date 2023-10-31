package racingcar.view;

import racingcar.constants.DomainConstant;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private final OutputView outputView = new OutputView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("자동차 입력 메세지 출력 테스트")
    void testPrintInputCarsMessage() {
        outputView.printCarsNameInputMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도 횟수 입력 메세지 출력 테스트")
    void testPrintInputAttemptCountMessage() {
        outputView.printTotalRoundInputMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("결과 안내 메세지 출력 테스트")
    void testPrintResultGuideMessage() {
        outputView.printResultGuideMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("실행 결과");
    }

    @Test
    @DisplayName("한 라운드 전진 결과 출력 테스트")
    void testOneRoundMoveResult() {
        Cars cars = new Cars("tiger,bear,eagle");
        int drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 1;

        for (Car car : cars) {
            car.move(drivingSkill++);
            outputView.printMoveRecord(car.getName(), car.getPosition());
        }

        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output.trim()).isEqualTo("tiger : \nbear : -\neagle : -");
    }

    @Test
    @DisplayName("전체 라운드 전진 결과 출력 테스트")
    void testTotalRoundMoveResult() {
        Cars cars = new Cars("tiger,bear,eagle");
        int totalRound = 3;
        int drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 4;

        while (totalRound != 0) {
            totalRound = totalRound - 1;
            for (Car car : cars) {
                car.move(drivingSkill++);
                outputView.printMoveRecord(car.getName(), car.getPosition());
            }
            outputView.printRoundSeparator();
        }

        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output.trim()).isEqualTo("""
                tiger :\s
                bear :\s
                eagle :\s
                                
                tiger :\s
                bear : -
                eagle : -
                                
                tiger : -
                bear : --
                eagle : --""");
    }

    @Test
    @DisplayName("최종 결과 가장 많이 이동한 단독 우승자 출력")
    void testPrintSoloWinner() {
        Cars cars = new Cars("tiger,eagle,bear");

        int drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 1;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 2;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        outputView.printWinners(cars.getWinnersName());
        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output.trim()).isEqualTo("최종 우승자 : bear");
    }

    @Test
    @DisplayName("최종 결과 가장 많이 이동한 공동 우승자 쉼표(,)로 구분하여 출력")
    void testPrintCoWinner() {
        Cars cars = new Cars("tiger,eagle,bear");

        int drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 1;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 1;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        outputView.printWinners(cars.getWinnersName());
        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output.trim()).isEqualTo("최종 우승자 : eagle, bear");
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}

