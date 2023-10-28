package racingcar.controller;

import racingcar.domain.Car;

public class MassageManager {
    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_REPEAT = "시도할 회수는 몇회인가요?";
    public static final String FINAL_WINNER = "최종 우승자 : ";
    public static final String RESULT_STAGE = "실행 결과";

    public void stageResult(Car car){
        String move = "";
        for (int i = 0; i<car.getDistance(); i++){
            move += "-";
        }
        System.out.println(car.getName() + " : " + move);
    }
}
