class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int task : tasks) { // storing the freq of tasks in freq array
            freq[task - 'A']++;
        }
        
        Arrays.sort(freq);  // O(26log26)
        int f_max = freq[25];
        int idle = (f_max - 1) * n; // Max possible idle time

        for(int i = freq.length - 2; i >= 0 && idle > 0; i--) {
            idle -= Math.min(f_max - 1, freq[i]);   // decreasing the max no of idle slots by the putting the rest of the tasks between these idle slots
        }

        idle = Math.max(0, idle);   // If idle becomes less than 0

        return idle + tasks.length; // idle slots + busy slots
    }
}