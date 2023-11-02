package racingcar;

import java.util.List;

public class PrintView {
    public static void printRaceProgress(Car[] carList){
        for (Car car : carList) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getForwardCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printExecuteResultString(){
        System.out.println("실행결과");
    }

    public static void printRaceWinner(List<String> winnerList){
        for (String winner : winnerList) {
            System.out.println("최종 우승자 : " + winner);
        }
    }

    public static void printCreationCompelete(){
        System.out.println("생성완료");
    }
}
