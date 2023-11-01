package racingcar;

import java.util.List;

public class Print {

    String startingComment = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    String askHowManyTurn = "시도할 회수는 몇회인가요?";
    String resultComment = "실행 결과";
    String finalWinnerComment = "최종 우승자 : ";

    void Score(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.name + " : " + "-".repeat(car.score));
        }
        System.out.println();
    }

    void Winner(List<Car> carList) {
        GameFunction gameFunction = new GameFunction();
        List<String> winnerName = gameFunction.getWinner(carList);
        String result = String.join(", ", winnerName);

        System.out.print(finalWinnerComment);
        System.out.println(result);
    }
}
