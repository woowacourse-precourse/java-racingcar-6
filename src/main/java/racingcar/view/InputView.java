package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.Validator;
import racingcar.model.Car;
import racingcar.model.CarList;

public class InputView {
    CarList carList = new CarList();
    private int carNumbers;


    public List<Car> askName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        List<String> carNames = splitName(inputName);
        carNumbers = carNames.size();
        Validator.validateString(carNames);
        return carList.makeCarList(carNames, carNumbers);
    }

    public int askGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String readLine = Console.readLine();
        Validator.validateNumber(readLine);
        return Integer.parseInt(readLine);
    }

    private List<String> splitName(String inputName) {
        return Arrays.asList(inputName.split(","));
    }

    //만약 기능요구사항에 자동차 이름에 숫자를 넣을 수 없다고 있었다면 숫자예외도 던져줄 수 있을 것 같다
    //또는 영어만 받도록 정규표현식으로 걸러주는 방법도 있을것 같다
}
