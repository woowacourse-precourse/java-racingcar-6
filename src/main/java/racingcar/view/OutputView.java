package racingcar.view;


import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarModel;

public class OutputView {
    public static final String DEMAND_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String DEMAND_REPEAT_NUMBER = "시도할 회수는 몇회인가요?";
    public static final String PRINT_RESULT = "\n실행 결과";
    public static final String PRINT_WINNER = "최종 우승자 : ";

    public static void printCarNameDemand() {
        System.out.println(DEMAND_CAR_NAME);
    }

    public static void printRepeatNumberDemand() {
        System.out.println(DEMAND_REPEAT_NUMBER);
    }

    public static void printResult(){
        System.out.println(PRINT_RESULT);
    }

    public static void printRacing(String carName, int location) {
        StringBuilder result = new StringBuilder();

        result.append(carName).append(" : ");
        result.append("-".repeat(Math.max(0, location)));
        System.out.println(result);
    }


    public static void printWinner(List<CarModel> winnerCars) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> winners = new ArrayList<>();

        for (CarModel carModel : winnerCars) {
            winners.add(carModel.getName());
        }
        stringBuilder.append(PRINT_WINNER).append(String.join(", ", winners));
        System.out.println(stringBuilder);
    }
}
