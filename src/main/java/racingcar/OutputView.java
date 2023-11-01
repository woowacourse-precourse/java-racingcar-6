package racingcar;

import java.util.ArrayList;

public class OutputView {
    // 자동차 한줄 출력
    public static void printDistance(Cars car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    // 한 회차 경주 출력
    public static void oneTurnRace(Cars[] carsArray, int tryNum) {
        for (int i = 0; i < carsArray.length; i++) {
            carsArray[i].distance = carsArray[i].move(tryNum);
            printDistance(carsArray[i]);
        }
    }

    // 전체 경주 시합 출력
    public static void startRace(Cars[] carsArray, int tryNum) {
        System.out.println("실행 결과");
        for (int j = 0; j < tryNum; j++) {
            oneTurnRace(carsArray, tryNum);
            System.out.println();
        }
    }

    // 우승자 출력
    public static void printWinner(ArrayList<Cars> winnerCars) {
        System.out.print("최종 우승자 : ");
        if (winnerCars.size() > 1) {
            for (int i = 0; i < winnerCars.size(); i++) {
                System.out.print(winnerCars.get(i).getName() + ", ");
            }
        }

        else {
            for (int i = 0; i < winnerCars.size(); i++) {
                System.out.print(winnerCars.get(i).getName());
            }
        }
        
    }
}
