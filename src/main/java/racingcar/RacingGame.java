package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    public static String[] carName;
    public static int tryNumber;

    private RacingGame(){
        throw new IllegalArgumentException();
    }
    public static void startGame(){
        inputCarName();
        inputTryNumber();
        playGame();
    }
    private static void inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameLine = Console.readLine();
        divideCarNameLine(carNameLine);
        isWrongInput(isCarNameOverFive());
    }
    private static void divideCarNameLine(String carNameLine){
        carName = carNameLine.split(",");
    }
    private static boolean isCarNameOverFive(){
        for (String name : carName) {
            if (name.length() > 5) {
                return true;
            }
        }
        return false;
    }
    private static void isWrongInput(boolean inputResult){
        if (inputResult) {
            throw new IllegalArgumentException();
        }
    }
    private static void inputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String stringNumber = Console.readLine();
        isCorrectNumber(stringNumber);
        tryNumber = Integer.parseInt(stringNumber);
    }
    private static void isCorrectNumber(String stringNumber){
        isWrongInput(isNotNumber(stringNumber));
        isWrongInput(isNotInRange(stringNumber));
    }
    private static boolean isNotNumber(String stringNumber){
        try{
            Integer.parseInt(stringNumber);
            return false;
        }
        catch(NumberFormatException e){
            return true;
        }
    }
    private static boolean isNotInRange(String stringNumber){
        int number = Integer.parseInt(stringNumber);
        return (number <= 0);
    }
    private static void playGame(){
        while (tryNumber > 0) {
            tryNumber--;
        }
    }
}
