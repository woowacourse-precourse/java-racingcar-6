package racingcar;

public class Application {
    public static void main(String[] args) {
        // 차 이름 입력받기
        OutputView.outputCar();
        String inputCarNames = InputView.InputCar();
        
        // 쉼표 기준으로 나누고 객체 생성
        String[] splitCarNames = inputCarNames.split(",");
        Car[] carObjectsArray = new Car[splitCarNames.length];
        for (int i = 0; i < splitCarNames.length; i++) {
            HandleException.carName(splitCarNames[i]);
            carObjectsArray[i] = new Car(splitCarNames[i]);
        }
        
        // 횟수 입력받기
        OutputView.outputTimes();
        String inputTimes = InputView.InputTimes();
        // 횟수 예외상황 처리
        int timesValue = HandleException.times(inputTimes);
        
        // 게임 진행
        OutputView.outputResult();
        for (int i = 0; i < timesValue; i++) { // 횟수만큼 반복
            Game.playOnce(carObjectsArray);
        }
        
        // 결과 도출
        Game.chooseWinner(carObjectsArray);
    }
}
