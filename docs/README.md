# 📌 자동차 경주 기능 목록

## ✔️CarController

### startGame()
* 전체적인 로직을 실행한다.
* 입력이나 출력문을 담당하는 함수이다.

### runCar()
* 시도횟수만큼 랜덤 숫자를 생성하는 함수를 호출한다.
* 시도횟수만큼 출력문을 관리한다.

### makeRandomNumber()
* 랜덤 숫자를 만들어서 전진여부에 따라 전진한다.
* 나중에 우승자를 위해 가장 많이 전진한 숫자를 결정한다.

### printResult()
* 해당 차가 전진한 만큼 결과를 표시한다.

### maxNumber()
* 현재까지 가장 많이 전진한 개수를 저장한다.

### makeWinner()
* 전진한 횟수와 maxNumber을 통해 우승자를 list에 넣고 출력한다.

## ✔️ValidationController

### validateNameNumber()
* 입력한 이름의 길이가 5자리가 넘어가면 IllegalArgumentException로 에러 처리를 해준다.

### validateNumber()
* 해당 랜덤 숫자가 4보다 큰경우에만 전진하도록 처리한다.

## ✔️ConstantUtil
* 상수를 static final 변수로 관리한다.
