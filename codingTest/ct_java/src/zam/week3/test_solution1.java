package zam.week3;

/*
문제명 : 최소 직사각형 구하기
https://school.programmers.co.kr/learn/courses/30/lessons/86491

문제 설명
명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 
이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.

아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.

명함 번호	가로 길이	세로 길이
1	60	50
2	30	70
3	60	30
4	80	40
가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 
하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.

모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.

*/

public class test_solution1 {
	class Solution {
	    public int solution(int[][] sizes) {
	        int answer = 0;
	        
	        int result = 0;
	        int temp[][] = new int[10000][10000];
	        
	        for(int i = 0; i < sizes.length; i++){
	            for(int j = 0; j < sizes[i].length; i++){
	                temp[i][j] = i*j;
	                if(result > temp[i][j])
	                    answer = i*j;
	            }
	        }
	        
	        return answer;
	    }
	}
}

// Q. 2차원 배열 중첩 for문을 사용하여 가장 큰 값을 하려고 했는데 잘못 접근한 걸까요...?

/*
// https://adjh54.tistory.com/227
// 브루트 포스?

import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_v=0;
        int max_h=0;
        for(int i=0;i<sizes.length;i++){
            int v=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            max_v=Math.max(max_v,v);
            max_h=Math.max(max_h,h);
        }
        return answer=max_v*max_h;
    }
}

*/
