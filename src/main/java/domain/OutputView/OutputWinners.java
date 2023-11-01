package domain.OutputView;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputWinners {
    public static void printWinners(String [] winners){
        String totalWinners=String.join(", ", winners);
        System.out.printf("최종우승자 : %s%n",totalWinners);
    }
}
