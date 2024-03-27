package zam.week3;

/*
문제명 : K번쨰 수
https://school.programmers.co.kr/learn/courses/30/lessons/42748

문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

*/
import java.util.*;

public class test_solution2 {
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[100];
	        
	        for(int i = 0; i < array.length; i++){
	            for(int j = 0; j < commands.length; j++){
	                //array[j]
	            }
	        }
	        
	        return answer;
	    }
	}
}
/*
import java.util.*;
class Solution {
			       // {1,5,2,6,3,7,4} / {{2,5,3},{4,4,1},{1,7,3}}
	public static int[] solution(int[] array, int[][] commands) { 
		int[] answer = new int[commands.length]; // 3
		int n = 0;
		
		for (int i = 0; i < commands.length; i++) {
			int k = 0;
                                    // new int[4] // new int[1] // new int[7]
			int[] list = new int[commands[i][1] - commands[i][0] + 1]; 
                                     // j = 2 ~ 5 / j = 4 ~ 4 / j= 1 ~ 7
			for (int j = commands[i][0]; j <= commands[i][1]; j++) { 
				list[k++] = array[j - 1]; // {5,2,6,3} / {6} / {1,5,2,6,3,7,4}
			}
			Arrays.sort(list); // 오름차순 정렬 {2,3,5,6} / {6} / {1,2,3,4,5,6,7}
			answer[n++] = list[commands[i][2] - 1]; // {5,6,3}
		}
		return answer;
	}
}
*/
