package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class OutputviewTest {
    private String winnerMessage = "최종 우승자 : ";
    private String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)";
    private String tryMessage = "시도할 회수는 몇회인가요?";

    @Test
    public void printFinMessage(){
        List<String> racerNames = List.of("pobi", "test", "test2");
        System.out.print(winnerMessage);
        String winnerNames = racerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames);
    }
}
