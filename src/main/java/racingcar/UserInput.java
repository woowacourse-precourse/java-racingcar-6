package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {

    public List<String> getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carList = List.of(input.split(","));
        for (String carName : carList) {
            validCar(carName);
        }
        return carList;
    }

    public void validCar(String carName) {
        int carNameLength = carName.length();
        if (carNameLength == 0 || carNameLength > 5) {
            throw new IllegalArgumentException("Car name must be 5 characters or less and greater than 0.");
        }
    }

    public int getAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validAttemptNumber(input);
        int attempt = Integer.parseInt(input);
        return attempt;
    }

    public void validAttemptNumber(String input) {
        if (!(input.matches("[0-9]+"))) {
            throw new IllegalArgumentException("only numeric values are accepted.");
        }
    }
}
