* 사용자 입력

차량 개수, 반복할 횟수
- camp.nextstep.edu.missionutils.Console의 readLine()를 통해 입력받기
- 숫자가 아닌 다른 값을 입력할 경우 IllegalArgumentException 발생 후 종료

자동차 이름
- camp.nextstep.edu.missionutils.Console의 readLine()를 통해 입력받기
- 자동차 이름은 쉼표(,)를 기준으로 구분
- 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료


* 난수 생성

- 0~9 사이의 난수
- 난수 생성은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 통해 생성




MVC 구조

* View

- RequestMessage //시작과 끝에 나올 메세지
  - requestInputCarsName()
  - requestInputNumver()

- 