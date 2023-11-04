package service;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Game;

/**
 * 서로 역할을 가진 Car 와 Game 도메인을 함께 사용하여 기능을 만드는 클래스
 */
public class CarGameService {
    Game game = new Game();

    /**
     * 경주 할 자동차 목록 만들기
     *
     * @param carNames 사용자가 입력한 경주한 자동차 이름들
     * @return 각 자동차 이름을 분리하여 리스트에 담아 리턴한다.
     */
    public List<Car> getCarList(String carNames){
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = carNames.split(",");

        for(String carName : carNameArray){
            carName = carName.trim();
            carList.add(new Car(carName));
        }

        return carList;
    }

    /**
     * 한판의 레이싱 게임 실행
     *
     * @param carList 경주에 참여할 자동차
     * @return 경주에 참여한 모든 자동차들의 게임 결과 리턴
     */
    public List<Car> runRacingGame(List<Car> carList){
        Game.tryCount--;
        List<Car> racingGameResult = getRacingGameResult(carList);

        return racingGameResult;
    }

    /**
     * <p>자동차 경주 한판의 전진 결과</p>
     * 각 자동차들은 임의의 값을 기준으로 전진하거나 멈춘다.
     *
     * @return List<Car> 각 자동차들의 경주 결과를 담아서 리턴
     */
    private List<Car> getRacingGameResult(List<Car> carList){
        for(Car car : carList){
            int randomNumber = car.getRandomNumber();

            if(car.isStepForward(randomNumber)){
                car.MoveForward();
            }
        }

        return carList;
    }

    /**
     * 자동차 실행 결과 가공하기
     *
     * @param carList 경주한 자동차와 이동횟수를 담은 리스트
     * @return "{자동차명} : {전진횟수}" 형태로 가공하여 리턴
     */
    public List<String> getRacingGameResultList(List<Car> carList){
        List<String> racingGameResultList = new ArrayList<>();

        for(Car car : carList){
            String step = "";
            int stepCount = car.getStepCount();

            while (stepCount > 0){
                stepCount--;
                step += "-";
            }

            StringBuilder gameText = new StringBuilder(car.getName())
                    .append(" : ")
                    .append(step);
            racingGameResultList.add(gameText.toString());
        }

        return racingGameResultList;
    }

    /**
     * 자동차 경주 우승자 결과 만들기
     *
     * @param carList 경주한 자동차들의 결과를 담은 List
     * @return 자동차 경주 우승자 결과 리턴
     */
    public String getRacingGameWinner(List<Car> carList){
        int maxStepCount = game.getMaxStepCount(carList);
        String getWinnerList = game.getWinnerList(carList, maxStepCount);

        return getWinnerList;
    }

}
