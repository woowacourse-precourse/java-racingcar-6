package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
    }
}

class RacingCar {
    private String[] carNames;
    private Integer numberOfFinish;
    private Integer randomNum;
    public RacingCar(){
        getCarNames();
        getNumberOfMove();
        do{
            startRacingCar();
        }while(isRaceFinished());
        printWinner();
    }

    private void getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String names = Console.readLine();
        carNames = names.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if(carNames[i].length()>5) throw new IllegalArgumentException();
            carNames[i] = carNames[i].trim() + " : ";
        }
    }

    private void getNumberOfMove(){
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfFinish = Integer.parseInt(Console.readLine());
    }

    private Boolean checkRandomNumber(){
        randomNum = Randoms.pickNumberInRange(0,9);
        if(randomNum>=4) return true;
        return false;
    }

    private void printMove(){
        for(String i : carNames){
            System.out.println(i);
        }
        System.out.println();
    }

    public void startRacingCar(){
        for (int i = 0; i < carNames.length; i++){
            if(checkRandomNumber()){
                carNames[i] = carNames[i] + "-";
            }
        }
        printMove();
    }

    private void printWinner() {
        String[] Winner;
        String print = "최종 우승자 : ";
        for(String i: carNames){
            Winner = i.split(" ");
            if(Winner.length>2 && Winner[2].length()==numberOfFinish){
                print += Winner[0] + ",";
            }
        }
        print = print.replaceAll(",$","");
        System.out.print(print);
    }

    private boolean isRaceFinished() {
        for(String i: carNames){
            if(i.split(" ").length>2 && i.split(" ")[2].length()==numberOfFinish){
                return false;
            };
        }
        return true;
    }


}