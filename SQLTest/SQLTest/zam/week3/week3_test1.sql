-- 자동차 종류별 특정 옵션이 포함된 자동차 수 구하기

-- CAR_RENTAL_COMPANY_CAR 테이블에서 '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차가 자동차 종류 별로 몇 대인지 출력하는 SQL문을 작성해주세요. 
-- 이때 자동차 수에 대한 컬럼명은 CARS로 지정하고, 결과는 자동차 종류를 기준으로 오름차순 정렬해주세요.

SELECT CAR_TYPE, CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTION = "%통풍시트%" AND OPTION = "%가죽시트%"