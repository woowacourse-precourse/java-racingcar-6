package racingcar;

import java.util.List;

public class OutputResult {
    OutputMessage outputMessage = new OutputMessage();
    public void outputMiddleResult(Car[] cars) {
        outputMessage.outputMessage1();
        for (Car car : cars) {
            System.out.print(car.getCarName());
            System.out.print(" : ");
            outputDrawCar(car.getAdvanceCount());
        }
    }
    public void outputDrawCar(int num) {
        for(int i = 0; i < num; i++)
            System.out.print("-");
        System.out.println();
    }

    public void outputLastResult(List<String> winner) {
        outputMessage.outputMessage2();
        System.out.print(winner.get(0));

        int i = 1;
        while(i < winner.size()) {
            System.out.print(",");
            System.out.print(winner.get(i));
            i++;
        }
    }
}
