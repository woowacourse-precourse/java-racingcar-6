package racingcar.model;


public class Cars {
    private static final String DELIMITER = ",";
    public static String[] makeCarList(String input) {
        String[] list = input.split(DELIMITER);
        return list;
    }
    // 이건 객체지향
//    public static void makeCarListtmp(String[] list) {
//        List<Car> cars = new ArrayList<>();
//        for (String carName : list) {
//            cars.add(new Car(carName));
//        }
//    }
}
