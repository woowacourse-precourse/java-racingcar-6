package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private int rounds;

    public void playGame() {
        inputNames();
//        inputRounds();
        for(int round = 0; round < rounds; round++){

        }
    }

    private void inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
    }
}
