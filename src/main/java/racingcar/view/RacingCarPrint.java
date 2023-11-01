package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class RacingCarPrint {
    public void printStartMention(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printGameCountMention(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMention(){
        System.out.println("실행 결과");
    }

    public void printResultAll(List<Car> cars){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cars.size(); i++){
            sb.append(cars.get(i).getCarName() + " : ");
            for(int j = 0; j < cars.get(i).getGoCount(); j++){
                sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void printWinner(List<String> winners){
        if(winners.size() == 1) System.out.println("최종 우승자 : " + winners.get(0));
        else{
            System.out.print("최종 우승자 : ");
            for(int i = 0; i < winners.size()-1; i++){
                System.out.print(winners.get(i) + ", ");
            }
            System.out.println(winners.get(winners.size()-1));
        }
    }
}
