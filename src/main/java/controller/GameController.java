package controller;

import camp.nextstep.edu.missionutils.Console;
import model.CarDto;
import racingcar.CarConstants;
import util.NameValidator;

import java.util.LinkedList;
import java.util.List;

import racingcar.CarConstants;

import  racingcar.CarConstants;


public class GameController {
    public List<CarDto> carList;
    public static int playNumberInput;
    public int maxScore;
    public List<CarDto> winnerList;

    public GameController(){
        //1. 사용자로 부터 참가자 리스트와 게임반복 횟수 입력받기
        initGame();
        //2. 반복횟수 만큼 게임 진행하기
        System.out.println(CarConstants.EXECUTION_RESULT_MESSAGE);
        playGame();
        //3. 최종 우승자 찾기
        findMaxScore();
        //4. 우승자 찾기
        findWinner();
        //5. 우승자 출력
        printWinner();
    }

    private void printPlay() {

        for(CarDto car: carList){
            System.out.print(car.getName()+" : ");
            printScore(car);
            System.out.println();
        }

    }

    private void printScore(CarDto car) {
        for(int position=0;position<car.getScore();position++)
            System.out.print("-");
    }

    private void printWinner() {
        System.out.print(CarConstants.WINNER_MESSAGE);
        for(CarDto car: winnerList){
            System.out.print(" "+car.getName());
        }

    }

    public void findWinner() {
        winnerList=new LinkedList<>();
        for(CarDto car : carList){
            sameWinnerScore(car);
        }
    }

    private void sameWinnerScore(CarDto car) {
        if(car.getScore()==maxScore){
            winnerList.add(car);
        }
    }

    public void initGame(){
        System.out.println(CarConstants.MESSAGE_INPUT_CARS_NAME);

        String participantNamesInput = Console.readLine();

        NameValidator.isValidInput(participantNamesInput);

        createCarList(participantNamesInput);

        System.out.println(CarConstants.MESSAGE_INPUT_REPEAT_NUMBER);
        String inputRepeatNumber =Console.readLine();

        if(NameValidator.isNumeric(inputRepeatNumber))
            playNumberInput = Integer.parseInt(inputRepeatNumber);

    }

    private void createCarList(String participantNamesInput) {
        carList = new LinkedList<>();
        String[] names = participantNamesInput.split(",");
        for (String name : names) {
            carList.add(new CarDto(name));
        }
    }

    public void playGame(){
        for(int stage=1;stage<=playNumberInput;stage++){
            Round();
            printPlay();
            System.out.println();
        }

    }

    private void Round() {
        for(CarDto car : carList){
            car.go();
        }
    }

    public void findMaxScore(){
        maxScore=0;
        for(CarDto car: carList){
            if(car.getScore() > maxScore)
                maxScore=car.getScore();
        }
    }

    public void setCarList(List<CarDto> carList) {
        this.carList=carList;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int i) {
        maxScore=i;
    }

    public List<CarDto> getWinnerList() {
        return winnerList;
    }
}
