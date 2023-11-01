package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;

public class RacingGameService {
    private final CarRepository carRepository = new CarRepository();
    private final int MAXNAMELENGTH = 5;
    private final int MINNAMELENGTH = 1;
    private final int forwardCondition = 4;
    // 게임 초기화 함수
    public void initGame(String playerInput){
        //parsing name
        String[] playerNames = inputParser(playerInput);

        //Player creation and add to repository
        for (String playerName:playerNames) {
            if (carRepository.isCarIn(playerName)){
                throw new IllegalArgumentException();
            }
            carRepository.addCar(createPlayer(playerName));
        }
    }

    public List<Car> playTurn(){
        // 각 차량에대해
        for (Car car : carRepository.getCars()){
            // 랜덤 넘버 생성
            if (getRandomOneDigitNum() >= forwardCondition){
                // 전진 로직
                movingForward(car);
            }
        }
        return carRepository.getCars();
    }

    //input에서 사용자 이름 파싱
    public String[] inputParser(String inputString) throws IllegalArgumentException{
        String[] tokens = inputString.split(",");
        for (String token: tokens){
            //Validation
            if (token.length()<MINNAMELENGTH || token.length()>MAXNAMELENGTH ){
                throw new IllegalArgumentException();
            }
        }
        return tokens;
    }

    // Player 생성 메서드
    private Car createPlayer(String carName){return new Car(carName);}

    // 시도회수 형 변환
    public int attemptParseToInt(String attempts) throws IllegalArgumentException{
        int parsedInt = Integer.parseInt(attempts);
        //입력값이 0보다 작은 경우 예외 처리
        if (parsedInt < 0){
            throw new IllegalArgumentException();
        }
        return parsedInt;

    }

    private int getRandomOneDigitNum(){
        return Randoms.pickNumberInRange(0,9);
    }


    // 전진 구현
    private void movingForward(Car car){
        car.incScore();
    }
    // 우승자 선출
    public ArrayList<Car> findWinners(){
        ArrayList<Car> winners = new ArrayList<>();
        int maxScore = findMaxScore();
        for(Car car : carRepository.getCars()){
            if(maxScore == car.getScore()){
                winners.add(car);
            }
        }
        return winners;
    }
    private int findMaxScore(){
        int maxScore = -1;
        for(Car car : carRepository.getCars()){
            if (maxScore < car.getScore()){
                maxScore = car.getScore();
            }
        }
        return maxScore;
    }
}
