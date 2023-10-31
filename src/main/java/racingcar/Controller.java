package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

class Game {
    private static final int NUMBER_START = 0;
    private static final int NUMBER_END = 9;
    private static final int MORE_THAN_FOUR = 4;
    static ArrayList<String> carsNames = new ArrayList<String>();
    private static final String GET_CARS_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_PLAY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PLAY_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    Game() {

    }

    public static void init(){
        String carsNamesStr = getCarsNames();
        int playNumber = getPlayNumber();
        divideString(carsNamesStr);

        gamePlay(carsNames, playNumber);
    }

    private static void gamePlay(ArrayList<String> carsNames, int playNumber) {
        System.out.println(PLAY_RESULT_MESSAGE);
        ArrayList<Integer> countCarsMove = new ArrayList<Integer>(carsNames.size());

       for(String car : carsNames){
           int randomNumber = getRandomNumber();
           if()
       }



    }

    private static int getRandomNumber() {
        return pickNumberInRange(NUMBER_START, NUMBER_END);
    }

    private static String getCarsNames() {
        System.out.println(GET_CARS_NAMES_MESSAGE);
        String inputCarsNames = readLine();
        //checkException(inputCarsNames);
        carsNames = divideString(inputCarsNames);

        return inputCarsNames;
    }

    private static int getPlayNumber(){
        System.out.println(GET_PLAY_NUMBER_MESSAGE);
        String inputPlayNumber = readLine();
        checkException(inputPlayNumber);

        return Integer.parseInt(inputPlayNumber);
    }

    private static ArrayList<String> divideString(String carStr) {

        return new ArrayList<>(Arrays.asList(carStr.split(",")));
    }

    static void checkException(final String str){
        if(!Game.checkInput(str)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInput(String isNumber){
        try {
            int inputValue = Integer.parseInt(isNumber);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}