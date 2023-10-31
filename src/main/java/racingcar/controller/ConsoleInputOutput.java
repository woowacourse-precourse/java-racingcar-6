package racingcar.controller;


import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameOperator;

public class ConsoleInputOutput implements GameOperator {
    @Override
    public Cars generateCars() {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        return Converter.stringToCar(userInput);
    }

    @Override
    public int setTrial() {
        print("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();

        return Converter.stringToTrial(userInput);
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}

