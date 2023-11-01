package view;

import constant.Message;
import controller.dto.CarDto;

import java.util.List;

public class OutputView {
    public void inputCarName() {
        System.out.print(Message.INPUT_CAR_NAMES.getMessage());
    }

    public void inputRoundNumber() {
        System.out.print(Message.INPUT_ROUND_NUMBER.getMessage());
    }

    public void outputRunResult() {
        System.out.print(Message.OUTPUT_RUN_RESULT.getMessage());
    }

    public void outputCarPosition(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.print(Message.OUTPUT_CAR_POSITION.getMessage(car));
        }
        System.out.print(Message.OUTPUT_NEWLINE.getMessage());
    }

    public void outputFinalWinner(List<CarDto> cars) {
        System.out.print(Message.OUTPUT_FINAL_WINNER.getMessage(cars));
    }
}
