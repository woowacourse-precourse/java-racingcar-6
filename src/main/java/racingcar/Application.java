package racingcar;

public class Application {
    public static void main(String[] args) {

        UserInputManager inputManager = new UserInputManager();
        String[] carNameList = inputManager.inputCarName();
        int attempts = inputManager.inputAttempts();

        Car[] car = new Car[carNameList.length];
        RaceGameManager raceGameManager = new RaceGameManager(car);


        int i = 0;
        for (String carName : carNameList) {
            car[i] = new Car(carName);
            i++;
        }

        while (attempts != 0) { // 입력받은 시도 횟수만큼 실행
            raceGameManager.noticeResult(carNameList);
            attempts--;
        }

        raceGameManager.noticeWinner();
    }
}
