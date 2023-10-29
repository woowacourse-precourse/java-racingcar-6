package racingcar.controller;

import racingcar.model.Participants;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class PlayGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberValidator numberValidator = new NumberValidator();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    Participants participants = new Participants();
    InputParticipantController inputParticipantController = new InputParticipantController();
    int playNumber;
    int peopleNum;
    List<String> winners = new ArrayList<>();

    public void gameStart(){
        String nameString = inputView.enterCarNames();
        List<String> names = inputParticipantController.getParticipants(nameString);
        playNumber = getPlayNumber();
        numberValidator.isValidNumber(playNumber);
        participants.setParticipants(names);
        participants.setIndex(names);
        peopleNum = names.size();

        outputView.printResult();
        for(int i=0; i<playNumber; i++){
            List<Integer> randomNumbers = getRandomNumbers(peopleNum);
            goOrStop(randomNumbers);
            showPlayResult();
        }
        whoWin();
    }

    private void goOrStop(List<Integer> randomNumbers) {
        for(int i=0; i<randomNumbers.size(); i++){
            String name = String.valueOf(participants.getIndex(i));
            go(randomNumbers.get(i), name);
        }
    }

    private void go(int randomNumber, String name){
        if(numberValidator.isOverFour(randomNumber))
            participants.setPoint(name, participants.getPoint(name)+1);
    }

    private int getPlayNumber(){
        String playNumber = inputView.enterPlayNumber();
        return Integer.parseInt(playNumber);
    }

    private List<Integer> getRandomNumbers(int peopleNum){
        return randomNumberGenerator.generateRandomNumbers(peopleNum);
    }

    private void showPlayResult(){
        for(Map.Entry<String, Integer> entry : participants.getParticipants().entrySet()){
            System.out.print(entry.getKey() + " : ");
            printBar(entry.getValue());
        }
        System.out.println();
    }

    private void printBar(int value){
        for(int i=0; i< value; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private void whoWin(){
        outputView.printWinner();
        int maxVal = findMaxCount();
        findWinners(maxVal);
        printWinnerName();
    }

    private void printWinnerName(){
        String str = winners.toString().replaceAll("[\\['\\]]", "");
        System.out.print(str);
    }

    private int findMaxCount(){
        return Collections.max(participants.getParticipants().values());
    }

    private void findWinners(int maxVal){
        for(Map.Entry<String, Integer> entry : participants.getParticipants().entrySet()){
            isSameWithMaxVal(entry.getValue(), maxVal, entry.getKey());
        }
    }

    private void isSameWithMaxVal(int ownVal, int maxVal, String name) {
        if(ownVal == maxVal){
            winners.add(name);
        }
    }
}
