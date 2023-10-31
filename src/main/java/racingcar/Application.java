package racingcar;

import java.util.concurrent.ConcurrentHashMap;

public class Application {
    static final String RESULT_OF_PLAY = "실행 결과";

    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        Computer computer = new Computer();

        ConcurrentHashMap<String, Integer> carMap = computer.splitCarName(input.getCarName());
        int round = computer.getIntRound(input.getRoundInput());

        System.out.println(RESULT_OF_PLAY);
        for (int i = 0; i < round; i++) {
            carMap = computer.executeRound(carMap);
            output.printResultOfRound(carMap);
        }

        output.printWinner(computer.findWinner(carMap));
    }


}
