package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    public static String[] carName;
    public static int tryNumber;
    public static int[] distance;

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
        distance = new int[carName.length];
        System.out.println("실행 결과");
        while (tryNumber > 0) {
            checkCar();
            tryNumber--;
        }
        findWinner();
    }
    private static void checkCar(){
        for (int i=0;i<carName.length;i++){
            runCar(i);
            printRacingSequence(i);
        }
        System.out.println();
    }
    private static boolean isRandomValueOverFour(){
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
    private static void runCar(int number){
        distance[number] += Boolean.compare(isRandomValueOverFour(), false);
    }
    private static void printRacingSequence(int number){
        String sequence = carName[number]+" : ";
        sequence += "-".repeat(distance[number]);
        System.out.println(sequence);
    }
    private static void findWinner(){
        int maxValue = findMax();
        printWinner(maxValue);
    }
    private static int findMax(){
        int maxValue = distance[0];
        for(int value : distance){
            if (maxValue < value){
                maxValue = value;
            }
        }
        return maxValue;
    }
    private static void printWinner(int maxValue) {
        StringBuilder winner = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == maxValue) {
                appendCommas(winner);
                winner.append(carName[i]);
            }
        }
        System.out.println(winner);
    }
    private static void appendCommas(StringBuilder winner) {
        if(winner.charAt(winner.length()-1) != ' '){
            winner.append(", ");
        }
    }
}
