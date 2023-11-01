package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.RacingCar;

public class OutputView {

    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printEnterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printEnterMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExecResult() {
        System.out.println("실행 결과");
    }

    public void printRacingResultEachCount(List<RacingCar> racingCarList) {
        Map<String, Integer> namePositionMap = racingCarList.stream()
                .collect(Collectors.toMap(RacingCar::getCarName, RacingCar::getCurrentPosition,
                        (oldPosition, newPosition) -> newPosition, LinkedHashMap::new));

        for (String carName : namePositionMap.keySet()) {
            int currentPosition = namePositionMap.get(carName);
            printCarCurrentPosition(carName, currentPosition);
        }
    }

    private void printCarCurrentPosition(String carName, int currentPosition) {
        System.out.print(carName + " : ");
        IntStream.rangeClosed(1, currentPosition)
                .forEach(count -> System.out.print("-"));
        System.out.print("\n");
    }
}
