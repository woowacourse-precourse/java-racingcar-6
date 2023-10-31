package racingcar.view;

import racingcar.domain.Winners;
import racingcar.domain.CarGroup;

public class OutputView {

    private static final String CAR_POSITION_VIEW = "-";
    private static final String DELIMITER = ", ";

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printWinner(Winners winners) {
        System.out.println("최종 우승자 : " + String.join(DELIMITER, winners.winners()));
    }

    public void printRoundResult(CarGroup carGroup) {
        carGroup.getCars().stream()
            .map(car -> car.getName() + " : " + printPosition(car.getPosition()))
            .forEach(System.out::println);
        System.out.println();
    }

    private String printPosition(int position) {
        return CAR_POSITION_VIEW.repeat(position);
    }
}
