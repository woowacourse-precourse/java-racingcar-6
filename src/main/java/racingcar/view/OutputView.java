package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printCarNameInputGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryNumInputGuide() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRacingResult(List<Car> carList) {
        for (Car car : carList) {
            String bar = "-".repeat(car.getForwardNum());
            System.out.println(String.format("%s : %s", car.getName(), bar));
        }
        System.out.println("\n");
    }

    public void printResultMessage(){
        System.out.println("\n실행 결과");
    }

    public void printWinner(List<String> winnerList) {
        String winnerMsg = "최종 우승자 : ";
        for(int i = 0; i < winnerList.size(); i++) {
            winnerMsg += winnerList.get(i) + ", ";
        }
        if (winnerMsg.endsWith(", ")) {
            winnerMsg = winnerMsg.substring(0, winnerMsg.length() - 2);
        }
        System.out.println(winnerMsg);
    }
}
