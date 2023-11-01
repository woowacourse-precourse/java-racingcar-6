package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.OutputConstant;
import racingcar.constant.message.GuideMessage;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.CarNameList;
import racingcar.domain.RacingCarManager;

public class OutputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @DisplayName("경주할 자동차 이름 입력 요구 문구 출력 테스트")
    @Test
    void 경주할_자동차_이름_입력_요구_문구_출력_테스트() {
        // given
        OutputView outputView = new OutputView();

        // when
        outputView.askToInsertCarNameList();

        // then
        assertEquals(GuideMessage.INSERT_CAR_NAME_LIST_DIRECTION + "\n", outContent.toString());
    }

    @DisplayName("경주 게임을 시도할 횟수 입력 요구 문구 출력 테스트")
    @Test
    void 경주_게임을_시도할_횟수_입력_요구_묵구_출력_테스트() {
        // given
        OutputView outputView = new OutputView();

        // when
        outputView.askToInsertNumberOfGames();

        // then
        assertEquals(GuideMessage.INSERT_NUMBER_OF_GAMES_DIRECTION + "\n", outContent.toString());
    }

    @DisplayName("경주 게임 진행 차수 별, 각 자동차가 전진한 정도를 출력 테스트")
    @Test
    void 경주_게임_진행_차수_별_각_자동차가_전진한_정도를_출력_테스트() {
        // given
        OutputView outputView = new OutputView();
        final String[] carNames = {"woowa", "junju", "baemi"};
        CarNameList carNameList = new CarNameList(carNames);
        RacingCarManager racingCarManager = new RacingCarManager(carNameList);
        CarList carList = racingCarManager.getCarList();
        StringBuilder expectedOutput = new StringBuilder();

        // when
        for (int i = 0; i < 10; i++) {
            racingCarManager.playRacingGame();
            outputView.printCarStatus(racingCarManager.getCarList());
            expectedOutput.append(makeExpectedOutputInCarProgressTest(carList));
        }

        // then
        assertEquals(expectedOutput.toString(), outContent.toString());
    }

    private String makeExpectedOutputInCarProgressTest(CarList carList) {
        StringBuilder expectedOutput = new StringBuilder();
        int carListSize = carList.getCarList().size();
        for (int i = 0; i < carListSize; i++) {
            Car car = carList.getCarList().get(i);
            expectedOutput.append(car.getName()).append(" : ")
                    .append(OutputConstant.CAR_DISTANCE_VALUE_SYMBOL.repeat(
                            Integer.parseInt(String.valueOf(car.getDistance()))))
                    .append("\n");
        }
        expectedOutput.append("\n");
        return expectedOutput.toString();
    }

    @DisplayName("경주 게임 진행 후, 우승자 출력 테스트 ( 여러 명이 우승 시 쉼표(,)로 구분 )")
    @Test
    void 경주_게임_진행_후_우승자_출력_테스트() {
        // given
        OutputView outputView = new OutputView();
        final String[] carNames = {"woowa", "junju", "baemi"};
        CarNameList carNameList = new CarNameList(carNames);
        RacingCarManager racingCarManager = new RacingCarManager(carNameList);

        // when
        for (int i = 0; i < 10; i++) {
            racingCarManager.playRacingGame();
        }
        outputView.printFinalWinner(racingCarManager.getMostDistanceCarList());
        String expectedOutput = makeExpectedOutputWhenGameFinished(racingCarManager);

        // then
        assertEquals(expectedOutput, outContent.toString());
    }

    private String makeExpectedOutputWhenGameFinished(RacingCarManager racingCarManager) {
        StringBuilder expectedOutput = new StringBuilder();
        CarList mostDistanceCarList = racingCarManager.getMostDistanceCarList();
        int carListSize = mostDistanceCarList.getCarList().size();

        expectedOutput.append(GuideMessage.FINAL_WINNER_ANNOUNCEMENT_SIGN);
        for (int i = 0; i < carListSize; i++) {
            Car car = mostDistanceCarList.getCarList().get(i);
            if (i < carListSize - 1) {
                expectedOutput.append(car.getName()).append(", ");
            } else if (i == carListSize - 1) {
                expectedOutput.append(car.getName());
            }
        }
        expectedOutput.append("\n");
        return expectedOutput.toString();
    }
}