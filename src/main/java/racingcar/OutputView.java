package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class OutputView {

    public static void print_position_bar(int position){
        for (int j = 0; j < position; j++) {
            System.out.print("-");
        }
    }

    public static void printCarPosition(Car car, int position) {
        System.out.print(car + " : ");
        print_position_bar(position);
        System.out.println();
    }

    public static void printresultMessage(){
        System.out.println("\n실행결과");
    }

}
