package racingcar;

public class GameManager {
    UserInput userInput;
    Racing racing;
    PrintResult printResult;
    GameManager(){
        init();
    }
    private void init(){
        userInput = new UserInput();
        racing = new Racing();
        printResult = new PrintResult();
    }

    public void startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = userInput.inputCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = userInput.inputCount();
        int[] location = new int[carNames.length];

        System.out.println("실행 결과");
        for(int i = 0; i < count; i++){
            racing.playOneRound(location);
            printResult.printLocation(location, carNames);
        }
        printResult.printWinner(location, carNames);
    }
}
