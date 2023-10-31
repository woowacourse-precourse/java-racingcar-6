package racingcar;

public class GameManager {
    GameManager(){
        UserInput userInput = new UserInput();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = userInput.inputCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = userInput.inputCount();
        int[] location = new int[carNames.length];

        Racing racing = new Racing();
        PrintResult printResult = new PrintResult();
        for(int i = 0; i < carNames.length; i++){
            location = racing.startOneRound(location);
            printResult.printLocation(location, carNames);
        }
        printResult.printWinner(location, carNames);
    }
}
