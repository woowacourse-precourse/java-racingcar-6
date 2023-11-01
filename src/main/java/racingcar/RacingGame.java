package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    ArrayList<Car> carList;
    UserInputValidator validator; // user 입력을 올바른지 체크하기 위한 validator

    public RacingGame() {
        carList = new ArrayList<>();
    }

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userCarName = Console.readLine();

        String[] carArr = validator.validateCarName(userCarName);
        settingCar(carArr);

        System.out.println("시도할 횟수는 몇회인가요?");
        String userInput = Console.readLine();
        int userGameNumber = validator.validateGameNumber(userInput);

        progressCarGame(userGameNumber);
    }
    // 입력받은 Car name으로 Car 객체를 생성함
    public void settingCar(String[] carArray) {
        for (String element : carArray) {
            Car car = new Car(element);
            carList.add(car);
        }
    }
    //
    public void progressCarGame(int userGameNumber) {
        int num = 0;
        while (true) {
            if (num == userGameNumber)
                break;
            for (Car car : carList) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                if (randomNum >= 4) {
                    car.moveForward();
                }
            }
            num++;
            printRunResult();
        }
        printWinner();
    }

    public void printWinner () {
        Car maxCar = carList.get(0);
        List<String> winnerCar = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getmovingDistance() > maxCar.getmovingDistance()) {
                maxCar = carList.get(i);
            }
        }
        for (Car car : carList) {
            if(car.getmovingDistance() == maxCar.getmovingDistance()) {
                winnerCar.add(car.getName());
                System.out.println("d" + car.getmovingDistance());
            }
        }
        String result = String.join(", ", winnerCar);
        System.out.print("최종 우승자 : " + result);
    }
    public void printRunResult() {
        System.out.println("실행 결과");
        for(Car car : carList) {
            String progress = "-".repeat(car.getmovingDistance());
            System.out.println(car.getName() + " : " + progress);
        }
        System.out.println();
    }
}