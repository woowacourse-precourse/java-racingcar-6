package racingcar.view;

import racingcar.domain.Car;

public class Views {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String RESULT_NESSAGE = "실행 결과";
    public void printInputCarMessage(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTrialMessage(){
        System.out.println(INPUT_TRIAL_NUMBER);
    }
    public void printResultMessage(){
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
}
