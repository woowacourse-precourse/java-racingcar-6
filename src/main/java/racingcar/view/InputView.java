package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static InputView inputView;

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public List<Car> inputCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] inputSplited = input.split(",");

        List<Car> retCarList = new ArrayList<>();
        for (int i = 0; i < inputSplited.length; i++)
            retCarList.add(new Car(inputSplited[i]));

        return retCarList;
    }

    public int inputMoveCount() {
        System.out.println();
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int moveCount = Integer.parseInt(input);

        return moveCount;
    }
}
