class Solution {
    public String reorganizeString(String str) {
        int [] freq = new int[26];
        int maxCount = 0;
        int maxCountIndex = 0;
	    int n = str.length();
	    for (int i = 0 ; i < n ; i++) {
	        char curr = str.charAt(i);
	        freq[curr-'a']++;
	    }
        
        for (int i = 0 ; i < 26 ; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxCountIndex = i;
            }
        }
         
       // System.out.println(ans[index]);
        if (maxCount > (n+1)/2)
            return "";
	    
	    char [] ans = new char[n];
        int index = 0;
        
        while (maxCount > 0) {
            ans[index] = (char) (maxCountIndex + 'a');
            index = index + 2;
            maxCount--;
        }
        freq[maxCountIndex] = maxCount;
        
        
	    for (int i = 0 ; i < 26 ; i++) {
            int count = freq[i];
            while (count > 0) {
                index = (index >= n) ? 1 : index;
                ans[index] = (char) (i + 'a');
                count--;
                if (index > 0 && ans[index] == ans[index-1])
                    return "";
                
                if (index < n-1 && ans[index] == ans[index+1])
                    return "";
                index = index+2;
            }
        }
	    
	    return String.valueOf(ans);
    }
}