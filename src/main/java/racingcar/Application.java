package racingcar;

public class Application {
    public static void main(String[] args) {
        // 차 이름 입력받기
        OutputView.outputCar();
        String inputCar = InputView.InputCar();
        
        // TODO : 차 이름 예외상황 처리
        
        // 쉼표 기준으로 나누고 객체 생성
        String[] carName = inputCar.split(",");
        Car[] car = new Car[carName.length];
        for (int i = 0; i < carName.length; i++) {
            //System.out.println(carName[i]);
            //car[i].name = carName[i];
            //car[i].location = 0;
            car[i] = new Car(carName[i]);
            System.out.println(car[i].location + car[i].name);
        }
        
        // 횟수 입력받기
        OutputView.outputTimes();
        String inputTimes = InputView.InputTimes();
        // 횟수 예외상황 처리
        int times = HandleException.times(inputTimes);
        
        // 게임 진행
        for (int i = 0; i < times; i++) { // 횟수만큼 반복
            for (int j = 0; j < car.length; j++) {
                car[j].changeLocation();
                car[j].printLocation();
            }
            System.out.println();
        }
        
    }
}
