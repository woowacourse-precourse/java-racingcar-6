package racingcar;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static List<Car> cars = new ArrayList<>();
    static ArrayList<String> winners = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(MessageUtil.MSG_INPUT_CARNAME);
        RacingSetting.createCars(Console.readLine().trim());
        System.out.println(MessageUtil.MSG_INPUT_TRIAL);
        Integer trialNumber = RacingSetting.saveTrialNumber(Console.readLine().trim());
        System.out.println(MessageUtil.MSG_LABEL_RESULT);
        DriveProcedure.drive(trialNumber);
        RacingResult.showWinner();
    }
}