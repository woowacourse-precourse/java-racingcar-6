package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public class ConsolePrintServiceImpl implements PrintService{
    private static final String INPUT_NAME_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_NOTICE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_NOTICE = "실행 결과";
    private static final String GAME_WINNER_NOTICE = "최종 우승자 : ";

    @Override
    public void printInputNameNotice() {
        System.out.println(INPUT_NAME_NOTICE);
    }

    @Override
    public void printInputCountNotice() {
        System.out.println(INPUT_COUNT_NOTICE);
    }

    @Override
    public void printResultNotice() {
        System.out.println(RESULT_NOTICE);
    }

    @Override
    public void printGameResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            int distance = car.getDistance();
            for (int i=0;i<distance;i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void printFinalGameResult(List<String> carNameList) {
        System.out.print(GAME_WINNER_NOTICE);
        String carNamesResult = "";
        for(String carName:carNameList){
            carNamesResult += carName;
            carNamesResult += ", ";
        }
        carNamesResult = carNamesResult.substring(0, carNamesResult.length() - 2);
        System.out.println(carNamesResult);
    }
}
