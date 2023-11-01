package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OutputManager {
    public void printCarStatus(Map<String, Integer> carStatus) {
        carStatus.forEach((key, value) -> {
            System.out.println(String.format("%s : %s", key, "-".repeat(value)));
        });
        System.out.println();
    }

    public void printWinners(List<String> winners){
        System.out.print("최종 우승자 : ");
        IntStream.range(0, winners.size()).forEach(idx -> {
            if(idx == 0){
                System.out.print(winners.get(idx));
            }else {
                System.out.print(", "+winners.get(idx));
            }
        });
    }
}
