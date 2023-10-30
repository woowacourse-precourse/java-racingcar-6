package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class OutputView {
    public void printRacingCarNameInputMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumberOfTryInputMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult(List<RacingCar> racingCars){
        System.out.println("실행 결과");

        for(int i = 0; i < racingCars.size(); i++){
            System.out.print(racingCars.get(i).getName() + " : ");
            for(int k = 0; k < racingCars.get(i).getMoveNumber(); k++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinner(List<RacingCar> racingCars){
        System.out.print("최종 우승자 : ");

        int max = 0;

        for(int i = 0; i < racingCars.size(); i++){
            if(max < racingCars.get(i).getMoveNumber()){
                max = racingCars.get(i).getMoveNumber();
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < racingCars.size(); i++){
            if(racingCars.get(i).getMoveNumber() == max){
                if(sb.isEmpty()){
                    sb.append(racingCars.get(i).getName());

                    continue;
                }

                sb.append(", " + racingCars.get(i).getName());
            }
        }

        System.out.println(sb.toString());
    }
}
