package zam.week1;

/*
문제명 : 음양 더하기(월간 코드 챌린지 시즌2)
https://school.programmers.co.kr/learn/courses/30/lessons/76501
* 
문제 설명
어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 
이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 
실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
* */

public class test_solution1 {
	public int solution(int[] absolutes, boolean[] signs) {
       int sum = 0;
       
       //배열 길이
       for(int i=0; i<absolutes.length; i++){
           
           if(signs[i] == true){
               sum += absolutes[i];
           }
           else if(signs[i] == false){
               sum -= absolutes[i];
           }
       }
       return sum;
   }
}