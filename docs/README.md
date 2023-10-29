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


우테코 피드백
1. 요구사항을 정확히 준수한다
2. 커밋 메시지 의미있게 쓴다
3. git에 class, idea 파일 뺀다
4. 코드 자동정렬 (옵션+컨트롤+L)
5. 변수명 안 짧아도 되니 의미를 충분히
6. 들여쓰기 depth는 2까지만
7. 함수를 최대한 작은 단위로 쪼갠다
   *** 8. test/java/study를 참고하여 작성한 구현 기능 목록에 맞게 테스트 코드를 작성한다


느낀 점
1. private 메서드에 대한 테스트
2. playGameForTimes() 테스트
3. 기능 별 구현, 기능 별 커밋의 장점