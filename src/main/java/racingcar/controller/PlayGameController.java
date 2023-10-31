package racingcar.controller;

import racingcar.model.Participant;
import racingcar.model.Participants;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class PlayGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberValidator numberValidator = new NumberValidator();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    InputParticipantController inputParticipantController = new InputParticipantController();

    Participants participants = new Participants();
    HashMap<Integer, Participant> map1 = participants.getParticipants();

    int playNumber;
    int peopleNum;
    List<String> winners = new ArrayList<>();

    public void gameStart(){
        // 이름 스트링 입력받기
        String nameString = inputView.enterCarNames();
        // 이름 파싱
        List<String> names = inputParticipantController.nameParsing(nameString);
        peopleNum = names.size();
        // 개별 Participant 객체 생성
        List<Participant> people = inputParticipantController.initializeParticipants(names);
        // 그룹 Participants 생성
         participants.setParticipants(people);
         // 게임 시작
        playNumber = getPlayNumber();
        outputView.printResult();
        repeatRacing();
        whoWin();
    }

    private void repeatRacing(){
        for(int i=0; i<playNumber; i++){
            List<Integer> randomNumbers = getRandomNumbers(peopleNum);
            goOrStop(randomNumbers);
            showPlayResult();
        }
    }

    private void goOrStop(List<Integer> randomNumbers) {
        for(int i=0; i<randomNumbers.size(); i++){
            String name = map1.get(i).getName();
            go(randomNumbers.get(i), i);
        }
    }

    private void go(int randomNumber, int index){
        if(numberValidator.isOverFour(randomNumber))
            participants.setPoint(index);
    }

    private int getPlayNumber(){
        String playNumber = inputView.enterPlayNumber();
        numberValidator.isValidNumber(Integer.parseInt(playNumber));
        return Integer.parseInt(playNumber);
    }

    private List<Integer> getRandomNumbers(int peopleNum){
        return randomNumberGenerator.generateRandomNumbers(peopleNum);
    }

    private void showPlayResult(){
        for(Map.Entry<Integer, Participant> entry : map1.entrySet()){
            System.out.print(entry.getValue().getName() + " : ");
            printBar(entry.getValue().getPoint());
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
        List<Integer> points = new ArrayList<>();
        for(int i=0; i< map1.size(); i++){
            points.add(map1.get(i).getPoint());
        }
        return Collections.max(points);
    }

    private void findWinners(int maxVal){
        for(Map.Entry<Integer, Participant> entry : participants.getParticipants().entrySet()){
            isSameWithMaxVal(maxVal, entry.getKey());
        }
    }

    private void isSameWithMaxVal(int maxVal, int index) {
        if(map1.get(index).getPoint() == maxVal){
            winners.add(map1.get(index).getName());
        }
    }
}
