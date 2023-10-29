package view;

public class OutputView {
    private static final PRINT_NAME_OF_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final PRINT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private static final PRINT_GAME_RESULT = "실행 결과";

    public void printNameOfCar() {
        System.out.println(PRINT_NAME_OF_CAR);
    }

    public void printTryNumber() {
        System.out.println(PRINT_TRY_NUMBER);
    }

    public void printGameResult() {
        System.out.println(PRINT_GAME_RESULT);
    }

    
}