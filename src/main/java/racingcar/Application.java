package racingcar;

import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputFunction inputFunction = new InputFunction();
        InputFunction.InputResult InputDataList = inputFunction.InputData();
        if(!Objects.equals(InputDataList.inputDataList.get(0), "Error") &&
                !Objects.equals(InputDataList.numberOfTime, -1)){
            PlayGameFunction playGameFunction = new PlayGameFunction();

        }
    }
}
