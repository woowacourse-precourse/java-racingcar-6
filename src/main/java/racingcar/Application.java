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
        int times = HandleException.times(inputTimes);
        
    }
}
