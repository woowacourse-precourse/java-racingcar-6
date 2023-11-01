package racingcar.Controller;

import static racingcar.Model.RandomModel.checkRandomNumber;
import static racingcar.View.InputView.getCarCntFromUser;
import static racingcar.View.InputView.getCarNameFromUser;
import static racingcar.View.OutputView.printResult;

import java.util.List;
import racingcar.Model.CarModel;

public class Race {

    Race(){
        try {
            start();
        }
        catch (IllegalArgumentException e){
            throw e;
        }
    }

    public static void start(){
        notifyToWriteName();
        List<CarModel> carModelList = getCarNameFromUser();

        notifyToWriteCnt();
        Integer carCnt = getCarCntFromUser();

        while (carCnt--!=0) {
            String result = "";
            for (int i=0; i<carModelList.size(); i++){
                CarModel carModel = carModelList.get(i);
                if(checkRandomNumber()){
                    carModel.goForward();
                }
                result += carModel.printRacing();
            }
            printResult(result);
        }
    }

    public static void notifyToWriteName(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void notifyToWriteCnt(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void notifyResult(){
        System.out.println("실행 결과");
    }
}
