package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class OutputView {
    public static void printWinners(List<String> winners) {
        String result = String.join(Constant.WINNER_CAR_SEPERATE, winners);
        System.out.print("최종 우승자 : ");
        System.out.println(result);
    }

    public static void print_position_bar(int position){
        for (int j = 0; j < position; j++) {
            System.out.print(Constant.POSITION_BAR);
        }
    }

    public static void printCarPosition(Car car, int position) {
        System.out.print(car + Constant.CAR_SEPERATE);
        print_position_bar(position);
        System.out.println();
    }

    public static void printresultMessage(){
        System.out.println(Constant.EXECUTION_RESULT);
    }

}
