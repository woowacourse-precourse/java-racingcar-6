package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Views {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String RESULT_NESSAGE = "실행 결과";
    private static final String LAST_WINNER_MESSAGE = "최종 우승자 : ";
    public void printInputCarMessage(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTrialMessage(){
        System.out.println(INPUT_TRIAL_NUMBER);
    }
    public void printResultMessage(){
        printLineBreak();
        System.out.println(RESULT_NESSAGE);
    }
    public void printCarName(Car car){
        System.out.print(car.getCarName() + " : ");
    }
    public void printLocation(Car car){
        for(int i =0; i<car.getCarLocation();i++){
            System.out.print("-");
        }
    }
    public void printLineBreak(){
        System.out.println();
    }
    public void printLastWinnerMessage(){
        System.out.print(LAST_WINNER_MESSAGE);
    }

    public void printWinner(List<String> winnerName){
        for(int i = 0 ; i < winnerName.size(); i++){
            System.out.print(winnerName.get(i));
            if(i < winnerName.size() - 1){
                System.out.print(",");
            }
        }
    }

}
