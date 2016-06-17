class Greedy{
	public static void main(String args[]){
        int amount = 289;
		int coin[] = {100,50,25,10,2};
		int num;
		
		for(int i=0;i<coin.length;i++){
			if(coin[i]<=amount){
				num = amount/coin[i];
				System.out.println(num+" "+coin[i]);
				amount -=coin[i]*num;
			}
		}
	}
}
