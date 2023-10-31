package domain.OutputView;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputWinners {
    OutputWinners(String [] winners){
        String totalWinners=String.join(", ", winners);
        System.out.printf("최종우승자 : %s%n",totalWinners);
    }
}
