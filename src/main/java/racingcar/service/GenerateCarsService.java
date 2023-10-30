package racingcar.service;

import racingcar.exception.InputNameException;
import racingcar.util.StringAndListParser;

public class GenerateCarsService {
	private InputNameException nameException = new InputNameException();
	private StringAndListParser parser = new StringAndListParser();
	private String[] carArray;

	public String[] getNames(String names) {
		nameException.checkException(getNameList(names));
		return carArray;
	}

	public String[] getNameList(String names) {
		carArray = parser.splitString(names);
		return carArray;
	}
}