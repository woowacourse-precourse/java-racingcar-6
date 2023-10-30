package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    public static String[] carName;

    private RacingGame(){
        throw new IllegalArgumentException();
    }
    public static void startGame(){
        inputCarName();
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
}
