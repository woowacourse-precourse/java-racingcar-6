# 구현 기능 목록

## 1. 초기화 : init()
### - 자동차들의 이름 입력
* Console.readline()을 이용하여 String 형태로 입력 받은 자동차들의 이름들을 미리 선언해둔 전역변수 carString에 저장
* checkCarLength() : carString에 저장된 차들의 이름 길이 판별
  * 이름의 길이가 5보다 큰 경우는 IllegalArgumentException 발생시킴.
### - 자동차 이름 입력 테스트 : checkCarLength_자동차_이름_길이확인
* junit의 @Test와 Assertions의 assertThat을 이용하여 5이하의 이름 길이만 받는지 테스트 진행.
### - 시도할 횟수 입력
* Consol.readLine()을 이용하여 String 형태로 받은 값을 Integer.parseInt()를 이용하여 정수로 변환해 준다.
* 이렇게 변환한 정수 값을 미리 선언해둔 전역변수 tryNum에 넣어준다.

## 2. 자동차 이름 분리 저장 : changeToCarArr()
* init()에서 입력받은 carString을 ","로 분리하여 carArray에 저장.

## 3. 단계별 실행 결과 저장 및 출력 : carRace()
### - 실행 결과 저장 : saveResult()
* Randoms.pickNumberInRange(0, 9)를 이용하여 받은 수가 4이상이면 전진을 저장하고, 4미만이면 변동 없음.
* carArray의 크기와 동일한 크기의 결과 저장 배열 raceResultArr에 전진 결과를 저장한다.
  * 단, 저장할때, 전진해야하는 수가 나온 경우인데 그 전까진 전진을 한단계도 못하여 null인 경우는 값에 "-"을 대입해준다.
  * 이미 전진을 한적이 있는 경우 "-"를 하나 더 더한 값을 대입해준다.
* checkForward() : 무작위 수가 4이상이면 true 반환, 4미만이면 false 반환시켜줌.
  * 그리하여, 이 값이 false면 continue시켜줌.
### - 실행 결과 출력 : printResult()
* 저장된 결과를 출력 양식에 맞게 출력해줌.
  * 단, 아직 한 단계도 전진하지 못하여 null인 경우에는 ""를 출력해주며 null이라고 출력이 안되게 설정함.
### - checkForwardTest()
* junit의 @Test와 Assertions의 assertThat을 이용하여 4미만의 수와 이상의 수를 판별하는지 테스트 진행.

## 4. 우승자 출력 : whoIsWinner()
### - 우승자가 몇단계 전진 했는지 파악 : checkMaxSize()
* raceResultArr를 돌면서 가장 length가 긴 우승자의 전진 사이즈를 전역변수 size에 저장시켜 주었다.
### - 우승자 명단 저장 : saveWinner()
* raceResultArr를 돌면서 미리 저장해놓은 size의 길이와 일치하는  length를 가진 자동차의 이름을 List에 저장해준다.
### - 우승자 명단 출력 : printWinner()
* 우승자가 한명일 경우는 List의 0번째 인덱스를 출력.
* 우승자가 두명이상일 경우
  * moreThanOneWinner() : List를 돌면서 출력하는데 자동차 이름 사이마다 ", "를 넣어주면서 출력.
