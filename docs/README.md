## Car
    name : 이름
    forwardCount : 전진 횟수

    showStatus() : 현재 전진 상태를 출력
    incrementForwardCount() : 1칸 전진

## RacingGame
    players : 자동차 목록
    turn : 시도 횟수
    
    play() : 게임의 과정을 총괄
    setCars() : 사용자의 입력을 받아 Car 객체 생성
    setTurn() : 사용자의 입력을 받아 시도 횟수 설정
    run() : 자동차 경주 한 번의 시도
    finish() : 최종 우승자 결정

## Judge
    maxNameLength : 자동차 이름의 최대 길이
    forwardCriterion : forward의 기준이 되는 숫자
    lowerBoundRandomNumber : RandomNumber의 하한
    upperBoundRandomNumber : RandomNumber의 상한

    canMove() : forward의 여부를 판단
    pickRandomNumber() : random한 숫자 결정
    isEffectiveInputNames() : 입력받은 이름 형식이 유효한지 판단
    isEffectiveInputTurn() : 입력받은 시도 횟수가 유효한지 판단