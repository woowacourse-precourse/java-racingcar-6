package CarGameStart;

import java.util.List;

import Carset.CarFuctSet;
import Carset.CarNamedSet;
import Carset.PrintResult;

public class CarGameStart {
	CarNamedSet nameset;
	PrintResult result;
	List<String> CarNameds;
	
	
	
	public CarGameStart() {
		nameset = new CarNamedSet();
		CarNameds = nameset.NameSetting();
		result = new PrintResult(CarNameds);
		
	}
	
	
	
	
	public void run() {
		
		
		
		
	}
	
	

}
