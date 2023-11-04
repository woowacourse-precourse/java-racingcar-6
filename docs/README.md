# ✨ 기능 구현  목록

## 📕 domain.Car : 

    ✅ 기능1. 랜덤 값에 따라 자동차를 한 칸 전진한다. ➡ move()

    ✅ 기능2. 특정 자동차의 이름과 이동거리를 반환한다. ➡ getStatus()


## 📕 service.RacingService :

    ✅ 기능3. 현재 라운드를 진행한다. ➡ playRound()
    
    ✅ 기능4. 전체 라운드를 진행한다. ➡ playAllRounds()

    ✅ 기능5. 경기가 끝났을 때, 가장 많이 이동한 자동차의 이동거리를 찾는다. ➡ getMaxMovingDistance()

    ✅ 기능6. 우승자들을 찾는다. ➡ generateWinnerList()

    ✅ 기능7. 최종 결과를 반환한다. ➡ makeFinalResult()

## 📕 controller.RacingController :

    ✅ 기능8. 경기에 출전하는 자동차의 이름을 등록한다. ➡ setPlayer()

    ✅ 기능9. 자동차의 이름이 6글자 이상이면 에러를 발생시킨다. ➡ validateCarName()

    ✅ 기능10. 경주의 전체 라운드 수를 등록한다. ➡ setTotalRound()

    ✅ 기능11. 경주 전체 라운드 수로 입력한 값이 숫자가 아니면 에러를 발생시킨다. ➡ validateTotalRound()

    ✅ 기능13. 전체 경주를 진행하고 결과를 출력한다. ➡ playRacing()

    ✅ 기능14. 전체 경주 종료 후 우승자 목록을 출력한다. ➡ announceWinner()

    ✅ 기능15. 경기 흐름을 제어한다. ➡ play()