package StringMatching;

/**
 *
 * @author Sajitha
 */
public class RabinKarp {
    private final int prime =13;
    
    public long patternHash(String data){
        String pattern[] = data.split(""); 
        long hashValue=0;
        
        for(int i=0;i<pattern.length;i++){        
            long temp = (hashValue*26 + (String.valueOf(pattern[i]).codePointAt(0)-96))% prime;
            //System.out.println(temp);
            hashValue = temp;
        }
        return hashValue;
    }
    
    public void rabinKarp(String text, String pattern){
        long hashValue = patternHash(pattern);
        
        int n = text.length();
        int m = pattern.length();
        boolean b = false;
        for(int x=0; x<=n-m;x++){
            if(patternHash(text.substring(x,x+m))==hashValue){
                if(text.substring(x,x+m).equals(pattern)){
                    b = true;
                    System.out.println("There is a pattern in shift "+x);
                }
            }
        }
        
        if(b==false){
            System.out.println("There is no pattern");
        }
    }
    
    public static void main(String args[]){
        
        RabinKarp rk = new RabinKarp();
        rk.rabinKarp("adosajithauba patta bn sajitha","sajitha");

    }
}
