package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<RacingCar> racingCars = InputManager.get_input_car_names();
        int play_num = InputManager.get_input_play_num();

        System.out.println("실행 결과");

        for(int i=0;i<play_num;i++){
            move(racingCars);
            printCarsCount(racingCars);
            System.out.println();
        }

        List<RacingCar> winner = getWinner(racingCars);
        printResult(winner);
    }

    private void printResult(List<RacingCar> winner) {
        System.out.print("최종 우승자 : ");
        for(int i=0;i<winner.size();i++){
            System.out.print(winner.get(i).getName());
            if(i!= winner.size()-1){
                System.out.print(", ");
            }
        }
    }

    static List<RacingCar> getWinner(List<RacingCar> racingCars) {
        int max = 0;
        List<RacingCar> winners= new ArrayList<RacingCar>();

        for(int i=0;i<racingCars.size();i++){
            if(max<racingCars.get(i).getCount()){
                max=racingCars.get(i).getCount();
                winners.clear();
                winners.add(racingCars.get(i));
            } else if (max==racingCars.get(i).getCount()) {
                winners.add(racingCars.get(i));
            }
        }

        return winners;
    }

    private void printCarsCount(List<RacingCar> racingCars) {
        for(int i=0;i<racingCars.size();i++){
            racingCars.get(i).printNowCount();
        }
    }

    public void move(List<RacingCar> cars){
        for(int i=0;i<cars.size();i++){
            cars.get(i).move();
        }
    }

}
