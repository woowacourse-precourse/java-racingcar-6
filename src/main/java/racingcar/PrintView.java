package racingcar;

import java.util.List;

public class PrintView {
    public void printProgress(Car[] carList){
        for (Car car : carList) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getForwardCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printExecuteResultString(){
        System.out.println("실행결과");
    }

    public void printWinner(List<String> winnerList){
        for (String winner : winnerList) {
            System.out.println("최종 우승자 : " + winner);
        }
    }
}
