package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

    }

    public static HashMap<String, StringBuilder> requestRacers(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = readLine().split(",");

        if (input.length<2) throw new IllegalArgumentException();

        Map<String, StringBuilder> racers = Stream.of(input)
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("Name should be 5 characters or less: " + name);
                    }
                })
                .collect(Collectors.toMap(name -> name, name -> new StringBuilder()));

        return new HashMap<>(racers);
    }

}
