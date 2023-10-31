package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator;

import java.util.ArrayList;
import java.util.List;

public class MainCarGame {
    //입력받기
    //CarManager로 데이터 넘기기

    CarManager carManager = new CarManager();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    ScorePrinter scorePrinter = new ScorePrinter();

    public static int ATTEMPT_COUNT = 0;
    public static List<String> carOrderList;

    public void gameStart(){
        setInput();

        for(int i = 0; i<ATTEMPT_COUNT; i++){
            //System.out.println("-----"+i+"번째-------");
            carManager.setCarRandomNumber();
            scorePrinter.printMidtermScore();
        }
        scorePrinter.printFinalScore();


    }

    private void setInput() { //+유효검사
        Validator validator = new Validator();

        carOrderList = getCarNameInput(); //List<String
        validator.validatorForCar(carOrderList); //유효검사는 객체생성보다 먼저되어야함
        carManager.initCar(carOrderList); //객체 생성

        ATTEMPT_COUNT = getAttemptCountInput();
        validator.validatorForAttemptCount(ATTEMPT_COUNT);
    }


    private int getAttemptCountInput() {
        String answer = Console.readLine();

        return Integer.parseInt(answer);
    }

    private List<String> getCarNameInput() {
        String answer = Console.readLine();

        return toListString(answer);
    }

    public List<String> toListString(String str) {
        String[] arry = str.split(",");

        List<String> list = new ArrayList<>();
        for (String sample : arry) {
            list.add(sample);
        }

        return list;
    }
}
