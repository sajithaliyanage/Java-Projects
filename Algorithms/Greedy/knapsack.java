class GreedyKnapsack  {

		double[] profit;
		double[] weight;
		double[] take;

		public GreedyKnapsack(int n) {

			profit = new double[n];
			weight = new double[n];
			take = new double[n];
			for (int i = 0; i < n; i++) {
				profit[i] = (int) Math.round(Math.random() * 96 + 44);
				weight[i] = (int) Math.round(Math.random() * 89 + 15);
			}
		}

		public void unitPriceOrder() {
			for (int i = 0; i < profit.length; i++) {
				for (int j = 1; j < (profit.length - i); j++) {
					double x=profit[j - 1] / weight[j - 1];
					double y=profit[j] / weight[j];
					if (x <=y) {
						double temp = profit[j - 1];
						profit[j - 1] = profit[j];
						profit[j] = temp;

						double temp1 = weight[j - 1];
						weight[j - 1] = weight[j];
						weight[j] = temp1;
					}
				}
			}
		}

		public void Knapsack(int m) {
			unitPriceOrder();
			int j;
			for (j = 0; j < profit.length; j++) {
				take[j] = 0;
			}
			double total = m;
			for (j = 0; j < profit.length; j++) {
				if (weight[j] <= total) {
					take[j] = 1.00;
					total = total - weight[j];
				} else {
					break;// to exit the for-loop
				}
			}
			if (j < profit.length) {
				take[j] = (double)(total / weight[j]);
			}       
		}

		public void print() {

			System.out.println("item" + " |  " + "profit" + "  |   " + "weight" +
					"   |     " + "Unit Price" + "      |" + "  Take weight");
			for (int n = 0; n < profit.length; n++) {
				System.out.println(n + "\t" + profit[n] + "\t" + weight[n] + "\t"
						+ (profit[n] / weight[n]) + "\t" + take[n]);
			}
		}

		public static void main(String args[]) {
			GreedyKnapsack G = new GreedyKnapsack(10);
			System.out.println("Optimal soluation to knapsack instance "
					+ "with values given as follows : m=35");
			G.Knapsack(35);
			G.print();
			System.out.println("=======+============+=======+============+="
					+ "===========");
			System.out.println("Optimal soluation to knapsack instance with "
					+ "values given as follows : m=120");
			G.Knapsack(120);
			G.print();
		}
	}

		
	/*	
		//sorting with O(nlogn)
		public static void sortItems(int [ ] array)
		{
			int[] tmp = new int[array.length];
			sortItems(array, tmp,  0,  array.length - 1);
		}
		
		private static void sortItems(int [ ] array, int [ ] tmp, int left, int right)
		{
			if( left < right )
			{
				int middle = (left + right) / 2;
				sortItems(array, tmp, left, middle);
				sortItems(array, tmp, middle + 1, right);
				mergeArray(array, tmp, left, middle + 1, right);
			}
		}
		
		private static void mergeArray(int[ ] array, int[ ] tmp, int left, int middle, int right )
		{
			int leftEnd = middle - 1;
			int k = left;
			int num = right - left + 1;

			while(left <= leftEnd && middle <= right)
				if(array[left]<=array[middle])
					tmp[k++] = array[left++];
				else
					tmp[k++] = array[middle++];

			while(left <= leftEnd)
				tmp[k++] = array[left++];

			while(middle <= right)
				tmp[k++] = array[middle++];

			for(int i = 0; i < num; i++, right--)
				array[right] = tmp[right];
		}
		*/
