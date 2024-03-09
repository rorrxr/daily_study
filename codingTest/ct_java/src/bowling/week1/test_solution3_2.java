package bowling.week1;

import java.util.Arrays;

public class test_solution3_2 {
	public int solution(int[] d, int budget) {
        int answer = 0;
        // 최대 변수 -> 오름 차순 정렬부터
        // 1,2,3,4,5 => 6 = 5 + 1
        // 6 = 1 + 2 + 3
        // 6 -1 -2 -3 = 0
        
        Arrays.sort(d);
        
        for (int i = 0; i<d.length; i++) { 
            budget -= d[i];
            
            if (budget < 0) {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}
