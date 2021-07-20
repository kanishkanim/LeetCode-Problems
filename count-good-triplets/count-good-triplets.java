class Solution {
public int countGoodTriplets(int[] arr, int a, int b, int c) {
    int count = 0;
    for(int i = 0; i < arr.length; i++)
    {
        for(int j = i+1; j < arr.length-1; j++)
        {
            int ad = Math.abs(arr[i]-arr[j]);
            if(ad > a) continue;
            for(int k = j+1; k < arr.length; k++)
            {
                int bd = Math.abs(arr[j]-arr[k]);
                int cd = Math.abs(arr[i]-arr[k]);
                
                if(bd <= b && cd <= c)
                {
                    count++;
                }
            }
        }
    }
    
    return count;
}
}