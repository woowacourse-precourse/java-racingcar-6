package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.input.Input;

public class InputService {
    private Input input;

    public void requestInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String racingCount = Console.readLine();
        generateInput(carNames, racingCount);
    }

    private void generateInput(String CarName, String racingCount){
        input = new Input(CarName, racingCount);
    }

    public String getCarNames(){
        return input.getCarNames();
    }

    public int getRacingCount() {
        return input.getRacingCount();
    }
}
