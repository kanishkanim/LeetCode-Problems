class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int n=heights.length;
        Stack<Integer> s=new Stack<>();
        int[] l=new int[heights.length];
        int[] r=new int[heights.length];
        r[heights.length-1]=heights.length;
        s.push(heights.length-1);
        for(int i=n-2;i>=0;i--)
        {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                r[i]=n;
            }else
            {
                r[i]=s.peek();
            }
            s.push(i);
        }
        s=new Stack<>();
        l[0]=-1;
        s.push(0);
        for(int i=1;i<n;i++)
        {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                l[i]=-1;
            }else
            {
                l[i]=s.peek();
            }
            s.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            int width=r[i]-l[i]-1;
            int area=width*heights[i];
            max=Math.max(area,max);
        }
        return max;
        
    }
}