<h1> 🚗 자동차 경주 </h1>

- 작성자 : [GaGa-Kim](https://github.com/GaGa-Kim/java-racingcar-6/tree/GaGa-Kim)
- 미션 진행 및 회고글 : [기술 블로그](https://gaga-kim.tistory.com/1662) (미션 종료 후 공개될 예정입니다.)

<br>

<h2> 📍 게임 설명 </h2>

```bash
[초단간 자동차 경주 게임]
1. 주어진 횟수 동안 무작위 값에 따라 n대의 자동차는 전진 또는 멈춤
2. 각 자동차에 이름을 부여하여 전진하는 자동차를 출력
3. 자동차 경주 게임을 완료한 후 우승자 출력
```

<br>

<h2> 🖨 출력 예시 </h2>

```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

<br>

<h2> 📄 구현할 기능 목록 </h2>

```bash
1) 게임이 시작되면 자동차 이름을 입력받기 위해 '경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)' 출력

2) 입력받은 경주할 자동차 이름을 쉼표로 구분하여 저장
자동차에 따라 쉼표를 구분자로 하여 5자 이하의 자동차 이름 저장
[Exception]
쉼표로 구분되지 않을 경우 (구분자를 포함하지 않은 경우)
1자 이상, 5자 이하가 아닐 경우
다른 자동차의 이름과 중복될 경우
→ 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

3) 이동할 횟수를 입력받기 위해 '시도할 횟수는 몇회인가요?' 출력

4) 입력받은 시도할 횟수를 저장
[Exception]
정수가 아닐 경우 (소수, 문자 포함)
음수 혹은 0일 경우 (1보다 작을 경우)
→ 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

5) 시도할 횟수 동안, 각 자동차에 대한 전진하는 조건 구하기
0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진
4 미만일 경우 멈춤

6) 전진 결과를 출력
전진하는 자동차는 자동차를 출력할 때 자동차 이름을 같이 출력
전진 횟수에 따라 '-' 출력

7) 시도할 횟수만큼 시도한 후 최종 우승자 출력
가장 많이 전진한 자동차 이름 출력
우승자가 여러 명일 경우 쉼표(,)를 이용하여 이름 출력
```

<br>

<h2> 🗂 MVC 패턴을 적용한 디렉토리 구조 </h2>

```bash
model
|- domain   
    |- Car.java : 자동차 객체 정보 Domain
    |- Game.java : 게임 객체 정보 Domain
|- dto   
    |- CarRequestDto.java : 자동차 이름 요청 DTO
    |- CarResponseDto.java : 우승 자동차 이름 응답 DTO
    |- GameRequestDto.java : 게임 시도 횟수 요청 DTO
    |- GameResponseDto.java : 게임 진행 결과 응답 DTO
|- service
    |- RacingCarService.java : 게임 관련 자동차 움직이기, 우승자 찾기 등의 Service

view
|- InputView.java : 사용자 입력 View
|- OutputView.java : 사용자 출력 View

controller
|- RacingCarController.java : 게임 시작 Controller

utils
|- Validator.java : 입력 변수 처리하고 예외처리 Util
|- Generator.java : 전진/멈춤값 랜덤 생성 Util
|- Parser.java : 형변환 Util

constants   
|- Error.java : 예외 메시지 상수 Constant
|- Phrase.java : 출력 메시지 상수 Constant
|- Rule.java : 룰 상수 Constant

Application.java
```