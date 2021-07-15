class Solution {
    public boolean isBipartite(int[][] graph) {
      
        int[] color = new int[graph.length];  
        for(int i = 0; i < graph.length; i++)
        {            
            Queue<Integer> q = new LinkedList<>();
            if(color[i] == 0)
            {
                q.add(i);
                color[i] = 1;
                
                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    
                    for(int t: graph[curr])
                    {
                        if(color[t] == color[curr]) return false;
                        
                        if(color[t] == 0)
                        {
                           color[t] = - color[curr];
                           q.add(t);
                        }
                    }
                }
            }
        }return true;
    }
}