package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputFunction inputFunction = new InputFunction();
        InputResultModel InputDataList = inputFunction.InputData();
        List<Integer> UserRace = IntStream.range(0, InputDataList.getInputDataList().size())
                .map(i -> 0)
                .boxed()
                .collect(Collectors.toList());
        if(!Objects.equals(InputDataList.getNumberOfTime(), -1)){
            PlayGameFunction playGameFunction = new PlayGameFunction();
            playGameFunction.PlayGame(UserRace, InputDataList);
        }
    }
}
