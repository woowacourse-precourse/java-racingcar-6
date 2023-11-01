package racingcar;

public class Application {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE ="\n실행 결과";

    public void run(){
        String[] carNames;
        int attemptsNumber;

        UserInput userInput = new UserInput();

        System.out.println(INPUT_CAR_NAME_MESSAGE);
        carNames = userInput.carName();

        System.out.println(INPUT_ATTEMPTS_NUMBER_MESSAGE);
        attemptsNumber = userInput.attemptsNumber();

        System.out.println(RESULT_MESSAGE);
        PlayGame playGame = new PlayGame(carNames, attemptsNumber);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
