package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Car {
    private List<String> Car;
    private String userInput;
    public void inputCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = Console.readLine();
        Car = Arrays.stream(userInput.split(",")).toList();
    }
}
