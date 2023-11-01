package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

class Game {
    private static final int MAX_RANDOM_NUMBER = 0;
    private static final int MIN_RANDOM_NUMBER = 9;
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
        stringToArrayList(carsNamesStr);

        gamePlay(carsNames, playNumber);
    }

    private static void gamePlay(ArrayList<String> carsNames, int playNumber) {
        System.out.println(PLAY_RESULT_MESSAGE);
        ArrayList<Integer> countCarsMove = new ArrayList<Integer>(Collections.nCopies(carsNames.size(), 0));
        int endGameNumber = playNumber;
        while(endGameNumber != 0) {
            for(String car : carsNames){
                int randomNumber = getRandomNumber();
                if(randomNumber >= MORE_THAN_FOUR){
                    int index = carsNames.indexOf(car);
                    countCarsMove.set(index, countCarsMove.get(index) + 1);
                    endGameNumber--;
                    System.out.print(car + " : ");
                    System.out.println("-".repeat(countCarsMove.get(index)));
                    System.out.println();
                }
            }
        }
        printWinner(countCarsMove, playNumber);
    }

    private static void printWinner(ArrayList<Integer> countCarsMove, int playNumber) {
        int winnerCount = Collections.frequency(countCarsMove, playNumber);
        if(winnerCount == 1){
            printWinnerAlone(countCarsMove.indexOf(playNumber));
        }
        else if(winnerCount > 1){
            ArrayList<Integer> winnersIndexes = new ArrayList<>();
            for(int i = 0; i < countCarsMove.size(); i++){
                if(countCarsMove.get(i) == playNumber){
                    winnersIndexes.add(i);
                }
            }
            printWinnerSeveral(winnersIndexes);
        }
    }

    private static void printWinnerAlone(int index) {
        System.out.println(FINAL_WINNERS_MESSAGE + carsNames.get(index));
    }
    private static void printWinnerSeveral(ArrayList<Integer> winnersIndexes) {
        ArrayList<String> winners = new ArrayList<>();
        for(int index : winnersIndexes){
            winners.add(carsNames.get(index));
        }
        System.out.print(FINAL_WINNERS_MESSAGE + String.join(", ", winners));

    }

    private static int getRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private static String getCarsNames() {
        System.out.println(GET_CARS_NAMES_MESSAGE);
        String inputCarsNames = readLine();
        //checkException(inputCarsNames);
        carsNames = stringToArrayList(inputCarsNames);

        return inputCarsNames;
    }

    private static int getPlayNumber(){
        System.out.println(GET_PLAY_NUMBER_MESSAGE);
        String inputPlayNumber = readLine();
        checkException(inputPlayNumber);

        return Integer.parseInt(inputPlayNumber);
    }

    private static ArrayList<String> stringToArrayList(String carStr) {
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