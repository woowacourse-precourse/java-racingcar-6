package racingcar;

import static racingcar.InputController.carArrList;
import static racingcar.FindWinnerController.winnerDistance;

public class PrintController {

    public static void printCarNameDirection() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printCycleNumDirection() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printDirection() {
        System.out.println("");
        System.out.println("실행 결과");
    }
    public void printResult(int index) {
        String carName =carArrList.get(index).getName();
        int distance =carArrList.get(index).getDistance();
        System.out.printf("%s : ",carName);
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    void printWinner() {
        String winnerName =carArrList.get(0).getName();
        System.out.printf("최종 우승자 : %s", winnerName);
        int carNum =carArrList.size();
        for (int index = 1; index < carNum; index++) {
            if (carArrList.get(index).getDistance() ==winnerDistance) {
                winnerName =carArrList.get(index).getName();
                System.out.printf(", %s", winnerName);
            }
            else {
                break;
            }
        }
    }
}
