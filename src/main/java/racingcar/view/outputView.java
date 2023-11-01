package racingcar.view;

import java.util.List;

public class outputView {
    public static void printTitle(){
        System.out.println("\n실행 결과");
    }
    public static void printGameResult(String carName, int pos){
        printCarName(carName);
        printRoundResult(pos);
    }
    public static void printGameWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            checkSeveralWinner(winners, i);
        }
        System.out.println();
    }

    private static void checkSeveralWinner(List<String> winners, int i){
        if (i < winners.size() - 1) {
            System.out.print(", ");
        }
    }
    private static void printCarName(String carName){
        System.out.print(carName + " : ");
    }
    private static void printRoundResult(int pos){
        for(int i=0; i < pos; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
