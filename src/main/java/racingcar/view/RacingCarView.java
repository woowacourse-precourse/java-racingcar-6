package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.List;

public class RacingCarView {

    private final String LOCATION = "-";
    private final String CAR_NAME_LIST_INPUT_PRINT = "경주할 자동차 이름을 입력하시오.(이름은 쉼표(,) 기준으로 구분)";
    private final String READ_COUNT_PRINT = "시도할 회수는 몇회인가요?";
    private final String GAME_PROGRESS_RESULT_PRINT = "\n실행 결과";
    private final String PRINT_WINNER = "최종 우승자 : ";


    public void carNameListInputPrint() {
        System.out.println(CAR_NAME_LIST_INPUT_PRINT);
    }

    public void readCountPrint() {
        System.out.println(READ_COUNT_PRINT);
    }

    public void gameProgressResultPrint() {
        System.out.println(GAME_PROGRESS_RESULT_PRINT);
    }

    public void gameProgressPrint(CarList carList) {
        for (Car car : carList.getCarList()) {
            int location = car.getLocation();
            System.out.println(car.getName() + " : " + LOCATION.repeat(location));
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerList) {
        System.out.print(PRINT_WINNER);
        System.out.print(String.join(", ", winnerList));
    }

}
