# 구현할 기능 목록



# VER.1
## [x] 1. 자동차 입력 받아서 갯수만큼 자동차 객체 생성하기
    [x] RacingCar 도메인 정의하기 -> RacingCars
    [x] 입력값에 split(",") 호출해서 String 배열로 만들기 -> InputService.readInput()
    [x] 객체 생성 과정에서 입력값 체크하기 -> InputService.validateInput()
    [x] 입력값 서비스에 의존하여 자동차 객체 생성하기 -> GameService.createCars()

## [x] 2. 시도 횟수 입력 받기
    [x] 

## [x] 3. 각 객체에 대해서 랜덤한 수 받아서 추가하기
    [x] 랜덤값이 전진에 적합한지 확인하기
    [x] 추가이후 형식에 맞게 출력하기

## [x] 4. 시도 횟수만큼 실행한 후, 각 객체 간 진행 정도 비교해서 우승자 출력하기
    [x] 출력 시에 String.join() 통해서 한 문자열로 합치기



# VER.2
## [x] 1. 테스트 코드 작성
    [x] RacingCar
    [x] InputService
    [x] GameService

## [x] 2. GameService 기능별로 분리하기
    [x] GameService.run()을 RacingCarGameController에 두고, GameService는 각각의 로직에 집중
    [x] GameService.playGameForTimes()에서 랜덤 및 전진 가능성 확인 로직 분리
    [x] NumberConstant 생성해서 GameService에서 사용하는 상수 이동

## [x] 3. InputService의 validate 메서드 Validator로 이동



# VER.3
## [x] 1. 요구사항, 1차 피드백에 만족하도록 수정
    [x] InputService에서 split(",")한 각 문자열에 대해 trim() 적용
    [x] PrintService -> OutputService로 변경
    [x] 불필요한 주석 제거

## [x] 2. 각 객체 간 의존관계 점검