class Solution {
    public boolean canArrange(int[] arr, int k) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>=0)
            arr[i]=arr[i]%k;
            else
                arr[i] = (((arr[i] % k) + k) % k);
        }
        int [] count=new int[k];
        for(int i=0;i<arr.length;i++) count[arr[i]]++;
        if(count[0]%2!=0) return false;
        for(int i=1;i<k;i++){
            if(count[i]!=count[k-i]) return false;
        }
        return true;
    }
}