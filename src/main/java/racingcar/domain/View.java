package racingcar.domain;

import java.util.List;

public class View {

    public void printAskCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskTryRepetitionNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printProgressStatus(List<Car> carList) {

        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getMoveForwardStatus());
        }

        System.out.println();
    }

    public void printWinners(List<String> winnerList) {
        String winnerLine = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winnerLine);
    }

}
