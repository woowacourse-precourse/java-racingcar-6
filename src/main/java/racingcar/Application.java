package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    //차가 움직일지 멈춰있을지 판단
    public static boolean isMove() {
        int randomNumber = pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    //차 이동 기록
    public static List<Integer> moveCars(int sizeOfCars, List carsStatus) {
            for (int i = 0; i < sizeOfCars; i++) {
                boolean movementOrNot = isMove();
                if (movementOrNot){
                    carsStatus.set(i, (int) carsStatus.get(i) + 1);
                }
            }
            return carsStatus;
    }

    public static void game() throws IllegalArgumentException {

        //사용자에게 입력값 (경주할 자동차 이름, 게임을 시도할 회수) 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringCars = readLine();
        List<String> cars = List.of(stringCars.split(","));

        //입력값이 5자 이하인지 확인
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String stringNumberOfGames = readLine();

        //입력값이 숫자인지 확인
        int numberOfGames = 0;
        try {
            numberOfGames = Integer.parseInt(stringNumberOfGames);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");

        List<Integer> carsStatus = new ArrayList<>();
        for(int i=0;i< cars.size();i++){
            carsStatus.add(0);
        }

        for(int i=0;i<numberOfGames;i++) {
            carsStatus= moveCars(cars.size(),carsStatus);
        }
    }

    public static void main(String[] args) {
        game();
    }
}
