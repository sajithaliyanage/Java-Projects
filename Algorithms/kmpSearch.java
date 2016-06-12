package StringMatching;

/**
 *
 * @author Sajitha
 */
public class kmpSearch {
    
    public int[] temArray(String pattern){
        String arrayPattern[] = pattern.split("");
        int length = arrayPattern.length;
        int temp[] = new int[length];
        int index =0;
        
        for(int i=1;i<length;){
            if(arrayPattern[i].equals(arrayPattern[index])){
                temp[i]= index+1;
                index++;
                i++;               
            }else{
                if(index!=0){
                    index = temp[index-1];
                }else{
                    temp[i]=index;
                    i++;
                }
            }
        }
        
        return temp;
    }
    
    public boolean kmp(String text,String pattern){
        int temp[] = temArray(pattern);
        String arraytext[] = text.split("");
        String arrayPattern[] = pattern.split("");
        int i=0;
        int j=0;
        
        while(i<arraytext.length && j<arrayPattern.length){
            if(arraytext[i].equals(arrayPattern[j])){
                i++;
                j++;
            }else{
                if(j!=0){
                    j=temp[j-1];
                }else{
                    i++;
                }
            }
        }
        
        if(j == arrayPattern.length){
            return true;
        }else{
            return false;
        }
        
    }
    
    public static void main(String args[]){
        kmpSearch kmp = new kmpSearch();
        int k[] = kmp.temArray("aabaabaaa");
        
        for(int i=0;i<k.length;i++){
            System.out.print(k[i]+" ");
        }
        System.out.println();
        System.out.println(kmp.kmp("sasaaabaabaaaww","aabaabaaa"));

    }
}
