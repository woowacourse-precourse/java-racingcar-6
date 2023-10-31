package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SystemOutputTest {
    private static SystemOutput systemOutput;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void initTest() {
        systemOutput = new SystemOutput();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void showStatusTest() {
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        String testName = "user1";
        int testLocation = 4;

        systemOutput.showStatus(testName, testLocation);
        Assertions.assertThat(outputStreamCaptor.toString().trim()).contains("user1 : ----");
    }

    @Test
    void showResultTest() {
        Map<String, Car> players = new HashMap<>();
        List<String> testNames = List.of("test1,test2,test3,test4".split(","));
        Map<String, Integer> locationValuesInCarClasses = new HashMap<>();
        List<String> winner = new ArrayList<>();

        //각 이름마다 새로운 차량을 생성
        for (String testName : testNames) {
            players.put(testName, new CarImpl());
        }

        //car.goOrsStop 메서드를 각각 10번씩 실행
        for(int i = 0; i < 10; i++){
            for (Car car : players.values()) {
                car.goOrStop(0, 9);
            }
        }

        //valuesInCarClasses 에 각 차량의 위치를 입력후 최대값 추출
        for (String testName : testNames) {
            locationValuesInCarClasses.put(testName,players.get(testName).getLocation());
        }
        Integer maxValueInCarClasses = Collections.max(locationValuesInCarClasses.values());

        //우승자 추출
        for (Map.Entry<String, Integer> entry : locationValuesInCarClasses.entrySet()) {
            if (entry.getValue().equals(maxValueInCarClasses)) {
                winner.add(entry.getKey());
            }
        }

        //테스트에서 추출한 우승자가 메서드를 이용해 얻은 우승자와 같은지 확인.
        String winnerStr;
        winnerStr = String.join(", ", winner);
        systemOutput.showResult(players);
        Assertions.assertThat(outputStreamCaptor.toString().trim()).contains("최종 우승자 : " + winnerStr);
    }
}