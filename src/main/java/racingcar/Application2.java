//package racingcar;
//
//import camp.nextstep.edu.missionutils.Randoms; // Random값 추출
//import camp.nextstep.edu.missionutils.Console; //사용자가 입력하는 값
//
//import java.util.Arrays;
//import java.util.List;
//
//public class Application2 {
//    private static final int MOVE_THRESHOLD = 4; //랜덤값이 4이상일 경우에만 전진
//
//    public static void main(String[] args) {
//        Console console = new Console(); //  사용자의 입력을 받고 출력하는 데 사용
//        String[] carNames = console.readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)").split(",");
//        int numberOfAttempts = Integer.parseInt(console.readLine("시도할 회수는 몇회인가요?"));
//
//        Race race = new Race(carNames);
//        race.start(numberOfAttempts); // 게임을 실제로 실행, numberOfAttempts 횟수만큼 자동차들을 전진시킴
//        race.printRaceResult(); // 경주 결과를 출력
//    }
//}
//
//class Race {
//    private final List<Car> cars; // 레이스에 참가하는 자동차 리스트를 저장하는 변수
//
//    public Race(String[] carNames) { // Race 클래스의 생성자, 자동차 이름 배열을 받아 초기화함
//        cars = initializeCars(carNames);
//    }
//
//    // 주어진 자동차 이름 배열을 기반으로 자동차 객체를 생성하여 리스트로 반환하는 메서드
//    private List<Car> initializeCars(String[] carNames) {
//        return Arrays.stream(carNames).map(Car::new).toList(); ///
//    }
//
//    public void start(int numberOfAttempts) { // 주어진 횟수만큼 자동차들을 이동시키는 메서드
//        for (int i = 0; i < numberOfAttempts; i++) {
//            moveCars();
//            printCars();
//        }
//    }
//
//    private void moveCars() { // 모든 자동차를 한 번씩 이동시키는 메서드
//        for (Car car : cars) {
//            car.move();
//        }
//    }
//
//    private void printCars() { // 라운드 진행 중 결과 표현
//        for (Car car : cars) {
//            Console.println(car.getName() + " : " + "-".repeat(car.getPosition()));
//        }
//        Console.println("\n");
//    }
//    public void printRaceResult() { // 레이스 결과를 출력하는 메서드
////        for (Car car : cars) {  // 각 자동차의 이름과 이동 거리를 출력
////            Console.print(car.getName() + " : " + "-".repeat(car.getPosition()));
////        }
//        List<String> winners = getWinners();
//        Console.println("\n최종 우승자: " + String.join(", ", winners));
//    }
//
//    private List<String> getWinners() { // 우승한 자동차들의 이름을 출력
//        int maxPosition = getMaxPosition();
//        return extractWinnerNames(maxPosition);
//    }
//
//    private int getMaxPosition() { // 가장 멀리 간 자동차의 이동 거리를 반환하는 메서드
//        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
//    }
//
//    // 우승한 자동차들의 이름을 추출하여 리스트로 반환하는 메서드
//    private List<String> extractWinnerNames(int maxPosition) {
//        return cars.stream()
//                .filter(car -> car.getPosition() == maxPosition)
//                .map(Car::getName)
//                .toList();
//    }
//}
//
//class Car {
//    private final String name; // 자동차의 이름을 저장하는 변수
//    private int position = 0; // 자동차의 현재 위치를 나타내는 변수
//
//    public Car(String name) { // Car 클래스의 생성자, 자동차의 이름을 받아 초기화함
//        this.name = name;
//    }
//
//    public void move() { // 자동차를 무작위로 전진시키는 메서드
//        int randomNumber = Randoms.pickNumberInRange(0, 9);
//        if (randomNumber >= MOVE_THRESHOLD) {
//            position++;
//        }
//    }
//
//    public String getName() { // 자동차의 이름을 반환하는 메서드
//        return name;
//    }
//
//    public int getPosition() { // 자동차의 현재 위치를 반환하는 메서드
//        return position;
//    }
//
//    /*
//     * name: 자동차의 이름을 저장하는 멤버 변수
//     * position: 자동차의 현재 위치를 나타내는 멤버 변수
//     * public Car(String name): 클래스의 생성자로, 자동차의 이름을 받아 초기화
//     * public void move(): 자동차를 무작위로 전진시키는 메서드.
//     *   Randoms.pickNumberInRange(0, 9)를 사용하여 0에서 9까지의 무작위 값을 얻고,
//     *   이 값이 MOVE_THRESHOLD(4) 이상일 때만 전진
//     * public String getName(): 자동차의 이름을 반환하는 메서드
//     * public int getPosition(): 자동차의 현재 위치를 반환하는 메서드
//     */
//}