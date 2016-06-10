class Naive{
	public static void main(String args[]){
		String text[]= {"s","a","s","w","e","r","s","a","s","a","e","r"};
		String pattern[]= {"e","r"};
		int n = text.length;
		int m = pattern.length;
		boolean k = false;
		for(int x=0;x<n;x++){
			int j=0;
			while(j<m && text[x+j].equals(pattern[j])){
				j++;
				if(j==m){
					System.out.println("there is a pattern Shift "+x);
					k=true;
				}
			}
		}
		
		if(k==false){
			System.out.println("there is No pattern");
		}
		
	}
}