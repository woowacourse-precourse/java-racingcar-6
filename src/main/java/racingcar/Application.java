package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    static Racer[] createRacerFromInput() {

        String[] names = Console.readLine().split(",");

        Racer[] racers = new Racer[names.length];

        for(int i=0; i< names.length; i++){
            racers[i] = new Racer(names[i]);
        }

        return racers;
    }
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        Racer[] racers = createRacerFromInput();
    }
}
