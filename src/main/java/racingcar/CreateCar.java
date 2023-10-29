package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class CreateCar {

    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public String[] carName(String input) {
        String[] carName = input.split(",");
        return carName;
    }

    public int carCount(String[] carName) {
        int carCount = carName.length;
        return carCount;
    }




}
