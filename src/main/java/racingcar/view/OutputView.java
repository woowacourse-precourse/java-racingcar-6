package racingcar.view;

import racingcar.model.Cars;
import racingcar.domain.Car;
import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "실행 결과";
    private static final String END_MESSAGE = "최종 우승자 :";

    public void printStartMessage() {

        System.out.println(START_MESSAGE);
    }
    public void printEndMessage() {
        System.out.print(END_MESSAGE);
    }
    public void printRoundResult(Cars cars) {
        List<Car> carList = cars.getCars();
        for(int i=0;i<carList.size();++i){
            String result = carList.get(i).getName()+" : ";
            int step = carList.get(i).getStep();
            for(int j=0;j<step;++j){
                result+="-";
            }
            System.out.println(result);
        }
        System.out.println();
    }

    public void printFinalResult(Cars cars, int maxStepValue){
        List<Car> carList = cars.getCars();
        String result="";
        for(int i=0;i<carList.size();++i){
            if(carList.get(i).getStep()==maxStepValue){
                result+=" "+carList.get(i).getName()+",";
            }
        }
        printEndMessage();
        System.out.println(result.substring(0,result.length()-1));
    }

}
