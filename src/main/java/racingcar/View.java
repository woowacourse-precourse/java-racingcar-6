package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {
    private static String input;
    public static String initGameView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine();
        return input;
    }

    public static Integer getCycleView() {
        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static void resultView(int count, List<Car> cars) {
        if (count == 0) System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void winnerView(List<Car> cars) {
        System.out.print("최종 우승자 : ");
        for (int index = 0; index < cars.size(); index++) {
            System.out.print(cars.get(index).getName());
            if (index != cars.size() - 1) System.out.print(", ");
        }
    }
}
