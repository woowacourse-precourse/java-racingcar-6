package console;

import java.util.List;
import racingcar.Car;

public class Printer {

    public static void printWinners(List<Car> winners) {
        if (winners.isEmpty()) {
            System.out.println("우승자가 없습니다.");
        }
        System.out.println("최종 우승자 : ");
        for( int i = 0; i < winners.size() ; i++ ) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.println(",");
            }
        }
    }
}