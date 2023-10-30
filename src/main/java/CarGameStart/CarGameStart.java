package CarGameStart;

import java.util.List;

import Carset.CarFuctSet;
import Carset.CarNamedSet;

public class CarGameStart {
	CarNamedSet nameset;
	CarFuctSet fuctset;
	
	
	public CarGameStart() {
		nameset = new CarNamedSet();
		fuctset = new CarFuctSet();
		
	}
	
	public void run() {
		List<String> CarNameds=	nameset.NameSetting();
		fuctset.MoveAdvance(CarNameds);
	}
	
	
	
	public void StartResult() {
		List<String> CarNamed;
		int number = fuctset.InputNumber();
		
		CarNamed = nameset.GetCarMembers();
		
		for(int i =0; i < number; i++) {
			for(int j =0; j < CarNamed.size(); i++) {
				System.out.println(CarNamed.get(j) + ":" );
				
			}
		}
	}
	
	

}
