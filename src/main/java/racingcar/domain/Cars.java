package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
    final private String START_PRINT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final private String GO = "-";
    private  String inputCarName = null;

    public Cars() {
    }


    public String createCars() {
        System.out.println(START_PRINT);
        String inputCarName = Console.readLine();

        return inputCarName;
    }

    public Cars(int tryCount) {

    }

    public void racing(String carsName, int tryCount) {
        RandomNumbers randomNumbers = new RandomNumbers();

        int randomNumber = randomNumbers.createRandomNumbers();

        System.out.println(randomNumber);

        System.out.println(carsName + " : " + GO);

    }

}
