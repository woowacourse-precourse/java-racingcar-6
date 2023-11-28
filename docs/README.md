* 사용자 입력

차량 개수, 반복할 횟수
- camp.nextstep.edu.missionutils.Console의 readLine()를 통해 입력받기
- 숫자가 아닌 다른 값을 입력할 경우 IllegalArgumentException 발생 후 종료

* 자동차 이름
- camp.nextstep.edu.missionutils.Console의 readLine()를 통해 입력받기
- 자동차 이름은 쉼표(,)를 기준으로 구분
- 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료


* 난수 생성

- 0~9 사이의 난수
- 난수 생성은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 통해 생성


코드 구조

* Controller
  - 게임이 돌아가기 위한 Controller

* Model
  - 게임을 위한 메세지를 담고 있는 Message
  - 게임을 위한 차 모델 Car

* Service
  - 입력 등 게임을 위한 GameManager
  - 차 이름을 입력받기 위한 InputCarsNameService
  - 반복 횟수를 입력받기 위한 InputTryNumberService

* Util
  - 이름 예외처리를 도와주는 CheckNameException
  - 숫자 예외처리를 도와주는 CheckNumberException
