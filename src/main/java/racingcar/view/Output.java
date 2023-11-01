package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class Output {
    private static final String inputCarsName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String inputAttempt = "시도할 회수는 몇회인가요?";
    private static final String startGamePrintExcuseResult = "실행 결과";
    private static final String gameResultMent= "최종 우승자";
    private static StringBuilder sb;

    public static void inputCarsNamePrint() {
        System.out.println(inputCarsName);
    }

    public static void inputAttemptNumPrint() {
        System.out.println(inputAttempt);
    }

    public static void startGamePrintExcuseResult() {
        System.out.println("\n" + startGamePrintExcuseResult);
    }

    public static void moveCar(List<Car> cars) {
        sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ");
            for (int j = 0; j < car.getMoveDistance(); j++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void gameResult(List<Car> result) {
        sb = new StringBuilder();
        sb.append(gameResultMent).append(" : ");
        sb.append(result.get(0).getName());
        for(int i=1;i<result.size();i++){
            sb.append(", ").append(result.get(i).getName());
        }
        System.out.println(sb);
    }
}