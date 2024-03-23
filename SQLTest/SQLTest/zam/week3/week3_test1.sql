-- 자동차 종류별 특정 옵션이 포함된 자동차 수 구하기

-- CAR_RENTAL_COMPANY_CAR 테이블에서 '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차가 자동차 종류 별로 몇 대인지 출력하는 SQL문을 작성해주세요. 
-- 이때 자동차 수에 대한 컬럼명은 CARS로 지정하고, 결과는 자동차 종류를 기준으로 오름차순 정렬해주세요.

SELECT CAR_TYPE, COUNT(CAR_ID) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
-- WHERE OPTIONS LIKE "%통풍시트%" OR OPTIONS LIKE "%가죽시트%" OR OPTIONS LIKE "%열선시트%"
-- WHERE OPTIONS REGEXP '통풍시트|가죽시트|열선시트'
ORDER BY CAR_TYPE ASC

-- Q. 조건문 때문에 안 되는 거 같은데 정규식 표현도 찾아서 해봤는데 왜 안 될까요...?