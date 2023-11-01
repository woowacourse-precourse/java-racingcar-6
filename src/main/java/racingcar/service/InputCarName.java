package racingcar.service;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.view.PrintAll;
import racingcar.service.ParsingCarName;
import racingcar.repository.SaveCarList;
import java.util.List;

public class InputCarName {
    private CarList carList = new CarList();
    private SaveCarList saveCarList = new SaveCarList(carList);
    private ParsingCarName parsingCarName = new ParsingCarName(saveCarList,carList);

    //public InputCarName(SaveCarList saveCarList){

        //this.saveCarList = saveCarList;}

    public CarList getCarName(){
        PrintAll printAll = new PrintAll();

        printAll.inputCarPrint();//경주할 자동차 이름을 입력하세요.
        String inputCars = Console.readLine();
        parsingCarName.parsingInput(inputCars);

       return saveCarList.entireCarList();
    }
}
