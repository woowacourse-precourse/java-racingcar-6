package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    public void playGame(){
        init();
        System.out.println("\n실행결과");
        for(int i =0;i<numOfPlaying;i++){
            play();
        }
        printWinner();
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

    private void generateListOfRacingCars(final String carNames){

        final List<String> listOfCarNames = stringToListOfString(carNames);

        for(String carName:listOfCarNames){
            checkCarNameValid(carName);
            RacingCar racingCar = generateRacingCar(carName);
            racingCars.add(racingCar);
        }
    }

    private List<String> stringToListOfString(final String carNames){
        return Arrays.asList(carNames.split(","));
    }

    private void checkCarNameValid(final String carName){
        if (carName.length()>5){
            throw new IllegalArgumentException();
        }
    }

    private RacingCar generateRacingCar(final String carName){
        return new RacingCar(carName);
    }

    private void checkInputNumValid(final String inputNum){
        try{
            Integer.parseInt(inputNum);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private void setNumOfPlaying(final int numOfPlaying) {
        this.numOfPlaying = numOfPlaying;
    }

    private void play(){
        decideToGoOrStop();
        printCurrentResult();
    }
    private void decideToGoOrStop(){
        for(RacingCar racingCar:racingCars){
            go(racingCar);
        }
    }

    private void go(RacingCar racingCar){
        if(randomNumGenerator.generateNum()>=4){
            racingCar.plusDistance();
        }
    }

    private void printCurrentResult(){
        for(RacingCar racingCar:racingCars){
            System.out.print(racingCar.getCarName()+" : ");
            for(int i =0;i<racingCar.getDistance();i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private List<String> whoIsWinner(){

        List<String> winnerList = new ArrayList<>();

        int maxDistance = racingCars.stream().max(Comparator.comparing(RacingCar::getDistance)).get().getDistance();

        for(RacingCar racingCar:racingCars){
            if(racingCar.getDistance()==maxDistance){
                winnerList.add(racingCar.getCarName());
            }
        }
        return winnerList;
    }

    private void printWinner(){
        List<String> winnerList = whoIsWinner();
        System.out.print("최종 우승자 :");
        for(int i=0;i<winnerList.size();i++){
            if(i>0){
                System.out.print(",");
            }
            System.out.print(" " + winnerList.get(i));
        }
    }
}
