package View;


import Domain.Car;

import java.util.List;

public class OutputView {
    //실행 결과, 우승자 출력 화면
    public static void OutputRaceResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void OutputRaceResult(List<Car> carList) {
        for (Car car : carList) {
            OutputCarPosition(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    public static void OutputCarPosition(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void OutputWinner(String winner) {
        System.out.print("최종 우승자 : ");
        System.out.println(winner);
    }
}
