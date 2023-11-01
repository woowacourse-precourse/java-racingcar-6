package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.Constant.*;

class Game {
    Game(){
        getCarsNames();
        int playNumber = getPlayNumber();

        gamePlay(playNumber);
    }

    private static void gamePlay(int playNumber) {
        System.out.println(PLAY_RESULT_MESSAGE);
        ArrayList<Integer> countCarsMove = new ArrayList<Integer>(Collections.nCopies(carsNames.size(), 0));
        int playCount = playNumber;

        while(playCount != 0) {
            for(String car : carsNames){
                System.out.print(car + SEPARATOR_STATUS);
                int randomNumber = getRandomNumber();
                if(randomNumber >= MORE_THAN_FOUR){
                    int index = carsNames.indexOf(car);
                    countCarsMove.set(index, countCarsMove.get(index) + 1);
                    playCount--;
                    System.out.print(CAR_DISTANCE.repeat(countCarsMove.get(index)));
                }
                System.out.println();
            }
        }
        printWinner(countCarsMove, playNumber);
    }

    private static void printWinner(ArrayList<Integer> countCarsMove, int playNumber) {
        int winnerCount = Collections.frequency(countCarsMove, playNumber);
        if(winnerCount == 1){
            printWinnerAlone(countCarsMove.indexOf(playNumber));
        }
        if(winnerCount > 1){
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
        System.out.println(FINAL_WINNER_MESSAGE + carsNames.get(index));
    }
    private static void printWinnerSeveral(ArrayList<Integer> winnersIndexes) {
        ArrayList<String> winners = new ArrayList<>();
        for(int winnerIndex : winnersIndexes){
            winners.add(carsNames.get(winnerIndex));
        }
        System.out.print(FINAL_WINNER_MESSAGE + String.join(SEPARATOR_WINNER, winners));
    }

    private static int getRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private static void getCarsNames() {
        System.out.println(GET_CARS_NAMES_MESSAGE);
        String inputCarsNames = readLine();

        setCarNames(inputCarsNames);
    }

    private static void setCarNames(String inputCarsNames){
        carsNames = stringToArrayList(inputCarsNames);
    }

    private static int getPlayNumber(){
        System.out.println(GET_PLAY_NUMBER_MESSAGE);
        String inputPlayNumber = readLine();
        checkException(inputPlayNumber);

        return Integer.parseInt(inputPlayNumber);
    }

    private static ArrayList<String> stringToArrayList(String carStr) {
        ArrayList<String> carNameCheck = new ArrayList<>(Arrays.asList(carStr.split(SEPARATOR)));
        for(String s : carNameCheck){
            if(s.length() > MAX_NAME_SIZE){
                throw new IllegalArgumentException();
            }
        }
        return carNameCheck;
    }

    static void checkException(final String str){
        if(!Game.isNumeric(str)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isNumeric(String isNumber){
        if(isNumber == null || isNumber.isEmpty()){
            return false;
        }
        for(char c : isNumber.toCharArray()) {
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}