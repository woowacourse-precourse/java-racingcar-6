package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String getNamesOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String namesOfCars  = Console.readLine();

        return namesOfCars;
    }

    public String getNumberOfAttempt() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String attempt = Console.readLine();

        return attempt;
    }
}