package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> carList;

    public void runGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();

        buildCarList(carNameInput);

        

    }

    private void buildCarList(String userInput) {
        List<String> carNames = extractCarNames(userInput);

        this.carList = carNames.stream()
                .map(element -> new Car(element))
                .collect(Collectors.toList());
    }

    private List<String> extractCarNames(String userInput) {
        List<String> nameList = Arrays.asList(userInput.split(","));

        nameList.stream().forEach(element -> {
            if (element.length() > 5 || element.length() <= 0) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
            }
        });

        return nameList;
    }
}
