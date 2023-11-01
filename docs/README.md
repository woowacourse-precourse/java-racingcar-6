# 구현할 기능 목록

## Car
레이싱 카를 구현하는 클래스
* getName() : 레이싱 카의 name을 가져온다.
* getPosition() : 레이싱 카의 position을 가져온다.
* Move 인터페이스를 구현한다.
## CarName
레이싱 카의 이름을 Validation 하는 클래스
* validateNameLength() : name의 길이가 5초과되지 않도록 한다.
## Move
이동할 수 있다는 인터페이스
* move() : 객체를 이동시키는 메서드.

## Game
자동차 경주 게임을 진행하는 클래스
* run() : 게임을 실행한다.
* input() : 게임을 실행하기 위한 Input
* allMove() : 게임에 속한 레이싱 카들을 이동시킨다.
* determineWinner() : 게임의 우승자를 뽑는다.

## GameInput
자동차 경주 게임의 Input 을 관리하는 클래스
* inputCarNames() : 여러개의 레이싱 카를 입력받는다. Validation 하는 과정도 포함된다.
* inputCount() : 시도 횟수를 입력받는다. Validation 하는 과정도 포함된다. 

## GamePrinter
게임의 각종 메세지를 출력하는 클래스
* inputCarNames() : 사용자로부터 경주할 자동차의 이름을 입력받는 메시지를 출력하는 함수 및 입력하라는 프롬프트 제공한다.
* inputCount() : 사용자로부터 시도할 회수를 입력받는 메시지를 출력하는 함수 및 입력하라는 프롬프트 제공한다.
* startMove() : 게임을 시작하고 실행 결과를 표시하는 메시지를 출력하는 함수이다.
* printCarNamePosition() : 레이싱 카의 이름과 현재 위치를 출력하는 함수이다.
* determineWinner() : 최종 우승자의 이름을 출력하는 함수이다.