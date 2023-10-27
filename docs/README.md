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

