package racingcar;

import java.util.concurrent.ConcurrentHashMap;

public class Application {
    static final String RESULT_OF_PLAY = "실행 결과";
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        Computer computer = new Computer();
        Validation validation = new Validation();

        ConcurrentHashMap<String, Integer> carMap = computer.splitCarName(input.getCarName());
        int round = validation.roundValidation(input.getRound());

        System.out.println(RESULT_OF_PLAY);
        for(int i = 0; i < round; i++){
            carMap = computer.executeRound(carMap);
            output.printResultOfRound(carMap);
        }

    }


}
