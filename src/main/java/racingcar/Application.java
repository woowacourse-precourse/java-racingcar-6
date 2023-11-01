package racingcar;

import racer.Race;

public class Application {
    public static void main(String[] args) {

        Race race = new Race();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        race.inputNames();

        System.out.println("시도할 회수는 몇회인가요?");
        race.inputCount();

        race.startRace();

    }
}
