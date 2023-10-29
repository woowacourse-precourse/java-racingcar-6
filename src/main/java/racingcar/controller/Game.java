package racingcar.controller;

import static java.util.Collections.max;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.service.CarMove;
import racingcar.service.CarName;
import racingcar.service.RandomNumber;

public class Game {

    private CarMove carMove;
    private CarName carName;
    private RandomNumber randomNumber;

    public Game(CarMove carMove, CarName carName, RandomNumber randomNumber) {
        this.carMove = carMove;
        this.carName = carName;
        this.randomNumber = randomNumber;
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        carName.input();
        carName.split();
        carName.range();
        randomNumber.generate();
        carMove.initializeLengthList();

        System.out.println("시도할 회수는 몇회인가요?");

        String input = Console.readLine();
        int num = Integer.parseInt(input);
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            carMove.increaseLength();
            carMove.drawHistogram();
            System.out.println();

        }
        printWinners();


    }

    private void printWinners () {
        int maxValue = Collections.max(carMove.lengthCount);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carMove.lengthCount.size(); i++) {
            if (carMove.lengthCount.get(i) == maxValue) {
                winners.add(carName.rangeCarList.get(i));
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}





