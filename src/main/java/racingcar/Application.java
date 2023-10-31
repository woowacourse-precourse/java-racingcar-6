package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputMessage inputMessage = new InputMessage();
        SplitName splitName = new SplitName();
        CheckError CheckError = new CheckError();
        Race race = new Race();

        inputMessage.inputCarNameMessage();
        String totalName = Console.readLine();

        String[] carNameList = splitName.splitName(totalName);
        CheckError.checkCarName(carNameList);

        inputMessage.inputCountMessage();
        try {
            Car.count = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException ime) {
            throw new IllegalArgumentException("숫자만 입력하세요");
        }

        Car[] cars = race.setCars(carNameList);

        OutputResult outputResult = new OutputResult();
        for(int i = 0; i < Car.count; i++) {
            cars = race.racingCount(cars);
            outputResult.outputMiddleResult(cars);
        }

        List<String> winners = race.getWinnerList(cars);
        outputResult.outputLastResult(winners);

    }
}
