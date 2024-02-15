class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];
        
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftSmall[i] = 0;
            }
            else{
                leftSmall[i] = st.peek()+1;
            }
            st.push(i);
        }
        st.clear(); 
        
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightSmall[i] = heights.length-1;
            }   
            else{
                rightSmall[i] = st.peek()-1;
            }
            st.push(i);
        }   
        int max = 0;

        for(int i=0;i<heights.length;i++){
            max = Math.max(max,heights[i] * (rightSmall[i] - leftSmall[i]+1));
        }
        return max;
    }
    
}