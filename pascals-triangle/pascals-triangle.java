class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();
       
        int i =0;
        while(i<numRows)
        {
            int j=0;
            List<Integer> temp = new ArrayList<Integer>();
            while(j<i+1)
            {
                if(i==0 || i==1)
                    temp.add(1);
                else
                {
                    if(j==0 || j==i)
                        temp.add(1);
                    else
                    {
                        int a = list.get(i-1).get(j-1);
                        int b = list.get(i-1).get(j);
                        temp.add(a+b);
                    }
                }
            j++;
            }
            list.add(temp);
            i++;
            
        }

        return list;
    }
}