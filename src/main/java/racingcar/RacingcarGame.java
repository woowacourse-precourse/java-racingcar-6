package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 자동차경주 게임
 */
public class RacingcarGame {
    UserInputCheck userInputCheck = new UserInputCheck(); // 사용자 입력 유효성 확인 및 Exception 처리
    List<Racingcar> racingcars = new ArrayList<>(); // 게임에 참여하는 자동차
    private int tryCount; // 시도 횟수

    /**
     * 자동차경주 게임 진행
     */
    public void playGame() {
        // 사용자 입력
        getCarName();
        getTryCount();

        // 시도 횟수만큼 자동차 전진 결정 및 전진 과정 출력
        System.out.println("\n"+Constant.RESULT_INFO_MESSAGE);
        for (int i=0; i<tryCount; i++) {
            decideMoveCar();
            printMoveCarResult();
        }

        // 우승자 결정 및 출력
        List<String> winner = decideWinner();
        printWinnerResult(winner);
    }

    /**
     * 사용자 자동차 이름 입력 및 유효성 확인
     */
    public void getCarName(){
        System.out.println(Constant.INPUT_NAME_MESSAGE);
        String input = Console.readLine();

        // 유효성 확인 및 Exception 처리
        userInputCheck.checkNameLength(input);

        // 자동차 정보 저장
        String [] names = input.split(",");
        for (String name : names){
            Racingcar newCar = new Racingcar(name);
            racingcars.add(newCar);
        }
    }

    /**
     * 사용자 시도 횟수 입력 및 유효성 확인
     */
    public void getTryCount(){
        System.out.println(Constant.INPUT_COUNT_MESSAGE);
        String input = Console.readLine();

        // 유효성 확인 및 Exception 처리
        userInputCheck.checkNumber(input);

        // 시도 횟수 저장
        tryCount = Integer.parseInt(input);
    }

    /**
     * 자동차 전진 여부 결정
     */
    public void decideMoveCar(){
        for (Racingcar car : racingcars){
            car.decideMove();
        }
    }

    /**
     * 전진 과정 출력
     */
    public void printMoveCarResult(){
        for (Racingcar car : racingcars){
            String moves = Constant.RESULT_MOVE_STR.repeat(car.getMoveCount());
            System.out.println(String.format(Constant.RESULT_CAR_MESSAGE, car.getName(), moves));
        }
        System.out.println();
    }

    /**
     * 우승자 결정
     */
    public List<String> decideWinner(){
        List<String> winner = new ArrayList<>();
        Collections.sort(racingcars); // 정렬
        int maxMoveCount = racingcars.get(0).getMoveCount();
        for (Racingcar car : racingcars){
            if (car.getMoveCount()==maxMoveCount){
                winner.add(car.getName());
            }
        }
        return winner;
    }

    /**
     *  우승자 출력
     */
    public void printWinnerResult(List<String> winner){
        String winners = String.join(", ", winner);
        System.out.println(String.format(Constant.RESULT_WINNER_MESSAGE, winners));
    }
}
