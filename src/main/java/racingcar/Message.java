package racingcar;

import java.util.List;

public class Message {
    public static void startMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void countMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void racingMessage(int carListSize ,List<Integer> winCount, List<String> carList) {
        for (int i =0; i < carListSize; i++) {
            System.out.print(carList.get(i)+" : ");
            System.out.println("-".repeat(winCount.get(i)));
        }
        System.out.println();
    }

    public static void winnerMessage(List<String> carList, List<Integer> winnerIndex) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerIndex.size(); i++){
            System.out.print(carList.get(winnerIndex.get(i)));
            if (!(i == winnerIndex.size()-1)) {
                System.out.print(", ");
            }
        }
    }
}
