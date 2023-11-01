package racingcar.Domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.Service.CarService;
import racingcar.Service.InputService;

public class Judge {
    private static  CarService carservice ;
    private static InputService inputService;
    Car maxCar=null;

    public Judge() {
    }

    public static CarService getCarservice() {
        return carservice;
    }

    public static void setCarservice(CarService carservice) {
        Judge.carservice = carservice;
    }

    public static InputService getInputService() {
        return inputService;
    }

    public static void setInputService(InputService inputService) {
        Judge.inputService = inputService;
    }

    public Judge(CarService carservice) {
        carservice=new CarService();
    }

    public List<String> judgeWinner() {
        List<Car> cars = inputService.getCars();
        sortCarsByStackSize(cars);

        int maxStackSize = cars.get(0).getForwardStack().size();
        return getWinners(cars, maxStackSize);
    }

    private void sortCarsByStackSize(List<Car> cars) {
        cars.sort((car1, car2) -> car2.getForwardStack().size() - car1.getForwardStack().size());
    }

    private List<String> getWinners(List<Car> cars, int maxStackSize) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardStack().size() == maxStackSize) {
                winners.add(car.getName());
            } else {
                break;
            }
        }
        return winners;
    }
}
