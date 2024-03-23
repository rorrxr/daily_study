-- 월별 잡은 물고기 수 구하기

-- 월별 잡은 물고기의 수와 월을 출력하는 SQL문을 작성해주세요.

-- 잡은 물고기 수 컬럼명은 FISH_COUNT, 월 컬럼명은 MONTH로 해주세요.
-- 결과는 월을 기준으로 오름차순 정렬해주세요.
-- 단, 월은 숫자형태 (1~12) 로 출력하며 9 이하의 숫자는 두 자리로 출력하지 않습니다. 잡은 물고기가 없는 월은 출력하지 않습니다.

SELECT count(ID) AS FISH_COUNT, MONTH(TIME) AS MONTH
FROM FISH_INFO
GROUP BY MONTH
ORDER BY MONTH ASC

-- Q. 결과는 알맞게 나오는데 MONTH(TIME) 말고 DATE_FORMAT으로는 구현이 안 되는 것인가요???