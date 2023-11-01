package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = Console.readLine().split(",");
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            }
        }
        // 이름에 대한 여러 예외들 처리 (5자 이하만 가능), 그냥 엔터를 쳤을 때는??, 같은 이름 등
        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameRoundString = Console.readLine();
        // 숫자 아닌 경우 예외 처리 신경쓰자, 숫자라도 0, 음수 등 예외 처리
        int gameRound;
        try{
            gameRound = Integer.parseInt(gameRoundString);
        }
        catch (NumberFormatException exception){
            throw new IllegalArgumentException();
            // 메세지 나중에 입력
        }
        System.out.println();
        System.out.println("실행 결과");

        List<Car> carList = new ArrayList<>();

        for (String s : nameList) {
            carList.add(new Car(s));
        }

        for (int i = 0; i < gameRound; i++) {
            for (Car car : carList) {
                car.randomMove();
                car.gameResultPrint();
            }
            System.out.println();
        }

        int maxMoveCount = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.getMoveCount() > maxMoveCount) {
                maxMoveCount = car.getMoveCount();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));

    }
}

class Car{
    private final String name;
    public int moveCount;
    Car(String name){
        this.name = name;
        moveCount = 0;
    }
    public void randomMove(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4) moveCount++;
    }
    public void gameResultPrint(){
        System.out.println(name + " : " + "-".repeat(moveCount));
    }
    public int getMoveCount(){
        return moveCount;
    }
    public String getName(){
        return name;
    }
}
