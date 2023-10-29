package racingcar;

import racingcar.domain.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input testInput = new Input();
        System.out.println(testInput.getCarName());
        System.out.println(testInput.getCountYouWantTry());
    }
}
