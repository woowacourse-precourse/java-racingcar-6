package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Play {
    public void play () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        List<String> carNameList = inputCarName(inputCars);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = Console.readLine();
        int number = inputNumber(inputNumber);

        racing(carNameList, number);
    }

    //자동차의 이름을 입력받는 기능
    public List inputCarName (String cars) {
        List<String> carList = new ArrayList<>();

        for (String s : cars.split(",")) {
            carNameCheck(s);
            carList.add(s);
        }

        return carList;
    }

    //전진 횟수를 입력받는 기능
    public int inputNumber (String number) {
        numberCheck(number);

        return Integer.parseInt(number);
    }

    //횟수만큼 자동차 경주하는 기능
    public void racing (List<String> carNames, int inputNumber) {
        int number = inputNumber;
        int count = 0;
        List<Car> carList = new ArrayList<>();
        String winner = "";

        for (String s : carNames) {
            carList.add(new Car(s, ""));
        }

        while (number > count) {
            count++;
            playRacing(carList);
            System.out.println();
        }

        winner = String.join(", ",winner(carList));
        System.out.println("최종 우승자 : "+winner);
    }

    //자동차 경주 로직
    public void playRacing (List<Car> carList) {
        for (Car cars : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                cars.setDrive(cars.getDrive()+"-");
            }
            System.out.println(cars.getName() + " : " + cars.getDrive());
        }
    }

    //우승자 목록 출력
    public List<String> winner (List<Car> carList) {
        int max = 0;
        List<String> winnerList = new ArrayList();

        for (Car car : carList) {
            if (max < car.getDrive().length()) {
                max = car.getDrive().length();
            }
        }

        for (Car car : carList) {
            if (max == car.getDrive().length()) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    /////////////////////////예외체크/////////////////////////
    //사용자가 입력한 자동차 이름 체크
    public void carNameCheck (String cars) {
        if (!cars.matches("^[a-zA-Z,]+$")) {
            throw new IllegalArgumentException("영문자로 입력하여 주세요.");
        }
        if (cars.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    //사용자가 입력한 전진 횟수 체크
    public void numberCheck (String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력하여 주세요.");
        }
    }

}

