package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printRequestCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestTryNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printGameResultMessage(List<Car> cars) {
        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            printCarLocationMessage(car.getPosition());
        }
        System.out.println();
    }

    public static void printCarLocationMessage(int position) {
        for(int i = 0 ; i < position; i++){
            System.out.print("-");
        }
        System.out.println();
    }


    public static void printFinalWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }

    }
}
