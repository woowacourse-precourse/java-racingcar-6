package racingcar.service.output;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.output.CarOutputDto;
import racingcar.dto.output.CarsOutputDto;
import racingcar.util.message.Printer;

public class OutputView implements Output{
    private final static int ZERO = 0;
    @Override
    public void showPlaying(final CarsOutputDto carsOutputDto) {
        showCarNameAndPosition(carsOutputDto);
    }

    @Override
    public void showResult(final CarsOutputDto carsOutputDto) {
        printingWinners(comparingResult(carsOutputDto.cars(), carsOutputDto.cars().getCarList().get(0).getCarPosition()));
    }

    private static void printingWinners(final ResultList resultList) {
        Printer.finalWinner();
        printingNames(resultList);
    }

    private static void printingNames(final ResultList resultList) {
        for(int i = ZERO; i < resultList.getResults().size(); i++){
            printingOneWinner(resultList, i);
        }
    }

    private static void printingOneWinner(final ResultList resultList, int i) {
        Printer.nowWinner(resultList.getResults().get(i));
        checkNumberOfPrintingNames(resultList, i);
    }

    private static void checkNumberOfPrintingNames(final ResultList resultList, int i) {
        if (isNotFinished(resultList, i)){
            Printer.comma();
        }
    }

    private static boolean isNotFinished(final ResultList resultList, final int i) {
        return i < resultList.getResults().size() - 1;
    }

    private static ResultList comparingResult(final Cars cars, final int max) {
        ResultList resultList = new ResultList();
        resultListIterate(cars, max, resultList);
        return resultList;
    }

    private static void resultListIterate(final Cars cars, int max, final ResultList resultList) {
        for(Car car : cars.getCarList()){
            max = comparingWithMax(max, resultList, car);
        }
    }

    private static int comparingWithMax(int max, final ResultList resultList, final Car car) {
        if(isBiggerThenCurrantMax(max, car)){
            max = foundMax(resultList, car);
        }else if(isSameWithCurrentMax(max, car)){
            foundSame(resultList, car);
        }
        return max;
    }

    private static boolean isSameWithCurrentMax(final int max, final Car car) {
        return car.getCarPosition() == max;
    }

    private static boolean isBiggerThenCurrantMax(final int max, final Car car) {
        return car.getCarPosition() > max;
    }

    private static void foundSame(final ResultList resultList, final Car car) {
        resultList.getResults().add(
                car.getCarName()
        );
    }

    private static int foundMax(final ResultList resultList, final Car car) {
        int max = car.getCarPosition();
        resultList.getResults().clear();
        resultList.getResults().add(car.getCarName());
        return max;
    }

    private static void showCarNameAndPosition(final CarsOutputDto carsOutputDto) {
        for(Car car: carsOutputDto.cars().getCarList()){
            showOneCarNameAndPosition(car);
        }
    }

    private static void showOneCarNameAndPosition(final Car car) {
        printNameAndPosition(new CarOutputDto(car));
    }

    private static void printNameAndPosition(final CarOutputDto carOutputDto) {
        printName(carOutputDto);
        printPosition(carOutputDto);
        Printer.switchLine();
    }


    private static void printPosition(final CarOutputDto carOutputDto) {
        for(int i = ZERO; i< carOutputDto.car().getCarPosition();i++){
            Printer.positionDash();
        }
    }

    private static void printName(final CarOutputDto carOutputDto) {
        Printer.carName(carOutputDto.car().getCarName());
    }
}
