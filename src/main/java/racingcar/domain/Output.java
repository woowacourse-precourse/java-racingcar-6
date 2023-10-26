package racingcar.domain;

import java.util.List;

public class Output {

    public void CarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(.) 기준으로 구분)");
    }

    public void gameCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void resultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> moveResult) {
        for (int i = 0; i < moveResult.size(); i++) {
            System.out.println(moveResult.get(i).toString());
        }
        System.out.println();
    }

    public void printWinner(Cars cars) {
        List<String> winners = cars.whosWinner();
        String winnerList = "";
        for (int i = 0; i < winners.size(); i++) {
            winnerList += winners.get(i);
            if (winners.size() > 1 && i + 1 != winners.size()) {
                winnerList += ", ";
            }
        }
        System.out.println("최종 우승자 : " + winnerList);
    }
}
