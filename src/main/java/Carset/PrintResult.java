package Carset;

import java.util.List;

public class PrintResult {
	List<String> carNames;
	CarFuctSet fuctset;
	
	public PrintResult(List<String> carNames) {
		this.carNames = carNames;
		this.fuctset = new CarFuctSet();
	}
	
	public void Start() {
		System.out.println("실행 결과");
	}
	
	
	
	
	
	
	public void printStatus() {
		Start();
		int number = fuctset.InputNumber();
		
		for(int i =0; i < number; i ++) {
			for(String carName : carNames) {
				fuctset.MoveCondition();
				 printCarStatus(carName, fuctset.getDistance());
			}
		}
		
	}
	
	private void printCarStatus(String carName, int distance) {
        System.out.print(carName + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
	
}
