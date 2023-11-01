package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    private List<RacingCar> racingCars;
    private RandomNumGenerator randomNumGenerator;
    private int numOfPlaying;

    public RacingCarGame(){
        this.racingCars = new ArrayList<>();
        this.randomNumGenerator = new RandomNumGenerator();
        this.numOfPlaying = 0;
    }


    private void play(){
        decideToGoOrStop();

    }
    private void decideToGoOrStop(){
        for(RacingCar racingCar:racingCars){
            boolean goOrNot = checkNum(randomNumGenerator.generateNum());
            go(racingCar, goOrNot);
        }
    }

    private boolean checkNum(int num){
        if(num<4){
            return false;
        }
        return true;
    }

    private void go(RacingCar racingCar,boolean goOrNot){
        if(goOrNot){
            racingCar.plusDistance();
        }
    }


    private void init(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        generateListOfRacingCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputNum = Console.readLine();
        checkInputNumValid(inputNum);
        setNumOfPlaying(Integer.parseInt(inputNum));

    }

    private void checkInputNumValid(String inputNum){
        try{
            Integer.parseInt(inputNum);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    private void checkCarNameValid(String carName){
        if (carName.length()>6){
            throw new IllegalArgumentException();
        }
    }

    private void generateListOfRacingCars(String carNames){

        List<String> listOfCarNames = stringToListOfString(carNames);

        for(String carName:listOfCarNames){
            checkCarNameValid(carName);
            RacingCar racingCar = generateRacingCar(carName);
            racingCars.add(racingCar);
        }
    }
    private List<String> stringToListOfString(String carNames){
        return Arrays.asList(carNames.split(","));
    }
    private RacingCar generateRacingCar(String carName){
        return new RacingCar(carName);
    }
    private void setNumOfPlaying(int numOfPlaying) {
        this.numOfPlaying = numOfPlaying;
    }
}
