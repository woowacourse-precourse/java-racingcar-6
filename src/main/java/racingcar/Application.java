package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputAndOutput.outputMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = InputAndOutput.inputCarNames();
        List<Car> carList = Car.makeCarList(carNameList);

        InputAndOutput.outputMessage("시도할 회수는 몇회인가요?");
        int tryTimes = InputAndOutput.inputTryTimes();

        InputAndOutput.outputMessage("\n실행 결과");
        RacingLogic.repeatRaceAsTryTimes(carList, tryTimes);
    }
}
