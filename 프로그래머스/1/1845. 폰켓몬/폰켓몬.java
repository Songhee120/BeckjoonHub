import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer;
        
        // HashMap 생성
        Map<Integer, Integer> mons = new HashMap<Integer, Integer>();
        
        // HashMap에 값 저장
        for(int num : nums) {
           if(mons.get(num) != null) {
               mons.put(num, mons.get(num) + 1);
           } else {
               mons.put(num, 1);
           }
        }
        
        // 최대 개수 조건식
        if(nums.length / 2 < mons.size()) {
            answer = nums.length / 2;
        } else {
            answer = mons.size();
        }
        
        return answer;
    }
}