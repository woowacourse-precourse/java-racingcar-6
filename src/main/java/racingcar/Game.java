package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer attemptsNumber;
    private Integer currentRound;

    public Game() {
        this.currentRound = 0;
    }

    public void start() {
        userInputCarName();
        printResult();
    }

    public void userInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputCarNameString = Console.readLine();
        String[] userInputCarNameArray = stringToArrayByComma(userInputCarNameString);

        List<Car> carList = new ArrayList<>();

        for (String userInputCarName : userInputCarNameArray) {
            carList.add(new Car(userInputCarName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        attemptsNumber = Integer.valueOf(Console.readLine());
    }

    public String[] stringToArrayByComma(String userInputString) {
        return userInputString.split(",");
    }

    public void printResult() {
        System.out.println("실행 결과");

        for (int i = 0; i < attemptsNumber; i++) {
            System.out.println("pobi : ");
            System.out.println("woni : ");
            System.out.println("jun : ");
            System.out.println();
        }

        System.out.println("최종 우승자 : ");
    }
}
