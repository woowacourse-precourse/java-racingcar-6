package racingcar.object;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Host {
    private List<Car> carList = new ArrayList<>();
    private Integer attemptCount;
    private String racingResult;

    public void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames;
        carNames = readLine();
        String[] carNamesArray = carNames.split(",");
        carNameJudgment(carNamesArray);
    }

    private void carNameJudgment(String[] carNamesArray) {
        for (String s : carNamesArray) {
            if (s.length() > 5)
                throw new IllegalArgumentException(String.format("현재 %s 자동차는 %d자입니다. 줄여서 다시 입력하세요.", s, s.length()));
            carList.add(new Car(s, ""));
        }
    }

    public void inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        attemptCount = Integer.parseInt(readLine());
        setAttemptCount(attemptCount);
    }

    public void carRacingResults() {
        for (int i = 0; i < attemptCount; i++) {
            forwardSetting();
            carRacingPrint();
        }
        winnerAnnouncement();
    }

    private void forwardSetting() {
        for (Car cars : carList) {
            int forwardPossibilityCount = Randoms.pickNumberInRange(0, 9);
            if (forwardPossibilityCount >= 4)
                cars.setMoveForward(cars.getMoveForward().concat("-"));
        }

    }

    private void carRacingPrint() {
        carList.forEach(car -> {
            System.out.printf("%s : %s %n", car.getName(), car.getMoveForward());
        });
        System.out.println();
    }

    private void winnerAnnouncement() {
        List<String> winnerList = new ArrayList<>();
        carList.sort((car1, car2) -> car2.getMoveForward().length() - car1.getMoveForward().length());
        int forwardLengthCheck = carList.get(0).getMoveForward().length();
        for (Car cars : carList) {
            if (forwardLengthCheck == cars.getMoveForward().length()) {
                winnerList.add(cars.getName());
            } else
                break;
        }
        racingResult = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + racingResult);
    }


    public List<Car> getCarList() {
        return carList;
    }

    public Integer getAttemptCount() {
        return attemptCount;
    }

    public String getRacingResult() {
        return racingResult;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void setAttemptCount(Integer attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void setRacingResult(String racingResult) {
        this.racingResult = racingResult;
    }

}
