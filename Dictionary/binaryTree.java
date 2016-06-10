import java.io.*;
class Node{
		String keyWord;
		String meaningValue;
		Node left;
		Node right;
		
		public Node(String data,String meaning){
			this.keyWord = data.toUpperCase();
			this.meaningValue = meaning;
			left =null;
			right =null;
		}
		
		public static String printKeyWord(Node data){
			//System.out.print(data.keyWord);
			return data.keyWord;
		}
		
		public static String printMeaningValue(Node data){
			//System.out.print(data.meaningValue);
			return data.meaningValue;
		}
}


class BinaryTree{
	//Declare a private attribute for ROOT
	static Node root;
	
	//BinarySearch Tree Constructor
	public BinaryTree(){
		this.root =null;
	}
	
	//Find if word is already exits in the binary search tree
	public boolean isExistsWord(String data){
		String upperCase_Data = data.toUpperCase(); //convert to UPPERCASE input word
		Node current =root;
		while(current!=null){
			if(current.keyWord.equals(upperCase_Data)){
				return true;
			}else if(Node.printKeyWord(current).compareTo(upperCase_Data)>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	//Add data to binary search tree
	public void addNode(String data,String meaning){
		
		if(isExistsWord(data)==false){
			Node dataNode = new Node(data,meaning);
		
			if(root==null){
				root=dataNode;
				System.out.println("New Entry is added to Root");
				return;
			}
			
			Node current = root;
			Node parent =null;
			
			while(true){
				parent = current;
				String upperCase_Data = data.toUpperCase(); //convert to UPPERCASE input word
				if(Node.printKeyWord(current).compareTo(upperCase_Data)>0){
					current = current.left;
					if(current==null){
						parent.left = dataNode;
						System.out.println("New Entry is added to left child of "+Node.printKeyWord(parent));
						return;
					}
				}else{
					current = current.right;
					if(current==null){
						parent.right = dataNode;
						System.out.println("New Entry is added to right child of "+Node.printKeyWord(parent));
						return;
					}
				}
				
			}
		}else{
			System.out.println("Aded New Word is Already exists");
		}
	}
	
	//Search given data and return the mening of it
	public String searchData(String data){
		String upperCase_Data = data.toUpperCase(); //convert to UPPERCASE input word
		Node current =root;
		
		while(current!=null){
			if(current.keyWord.equals(upperCase_Data)){
				return Node.printMeaningValue(current);
			}else if(Node.printKeyWord(current).compareTo(upperCase_Data)>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return "No Found";
	}
	
	//Delete the entered word
	public String deleteData(String data){
		String upperCase_Data = data.toUpperCase(); //convert to UPPERCASE input word
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false; //To find that node is left or right child
		
		while(!current.keyWord.equals(upperCase_Data)){
			parent = current;
			
			if(Node.printKeyWord(current).compareTo(upperCase_Data)>0){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			
			if(current==null){
				return "There is no word to Delete";			
			}
		}
		
		//If word to be deleted has no child (left and right both)
		if(current.left==null && current.right==null){
			if(current==root){
				root =null;
			}else if(isLeftChild==true){
				parent.left=null;
			}else{
				parent.right =null;
			}
		}
		
		//If word to be deleted has one left child
		if(current.right==null){
			if(current==root){
				root=current.left;
			}else if(isLeftChild==true){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		
		//If word to be deleted has one right child
		if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild==true){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}
		
		//If word to be deleted has both left and right child
		if(current.left!=null && current.right!=null){
			Node successor = getSuccessor(current);
			
			if(current==root){
				root = successor;
			}else if(isLeftChild==true){
				parent.left = successor;
			}else{
				parent.right = successor;
			}
			
			successor.left = current.left;
		}
		
		return "Word "+upperCase_Data+" Successfully DELETED";
	}
	
	//Get Successor(Lef most child in right sub tree) to replace with word to be deleted
	public Node getSuccessor(Node deleteNode){
		Node successor = null;
		Node successor_Parent = null;
		Node current = deleteNode.right;
		
		while(current!=null){
			successor_Parent = successor;
			successor = current;
			current = current.left;
		}
		
		/*After this loop we can get Leftmost child in right subTree
		  If successor have a right child add it to left child of successor_Parent
		  and make successor to parent of successor_Parent*/
		if(successor!=deleteNode.right){
			successor_Parent.left = successor.right;
			successor.right = deleteNode.right;
		}
		
		return successor;
	}
	
}


class Dictionery{	
	public static void main(String[] args) throws Exception {
		  BinaryTree t1 = new BinaryTree();
		  FileReader read = null;
		  String  thisLine = null;
		  String  thisLine2[] = new String[9999];
		  try{
			 // open input stream test.txt for reading purpose.
			 read = new FileReader("inputs.txt");
			 BufferedReader br = new BufferedReader(read);
			 int x=0;
			 while ((thisLine = br.readLine()) != null) {
				thisLine2[x] = thisLine;
				x++;
			 }       
			 try{
				 for(int y=0;y<thisLine2.length+1;y++){
					String lines[] = thisLine2[y].split("-");
					//System.out.println(lines[0]+" - "+lines[1]);
					t1.addNode(lines[0],lines[1]);
				}
			 }catch(Exception e){
				 System.out.println();
			 }
			 
			 
			 //System.out.println(lines[0]);
			 
		  }catch(Exception e){
			 e.printStackTrace();
		  }
		  
		System.out.println(t1.searchData("snaKe"));
		System.out.println(t1.deleteData("snaKe"));
		System.out.println(t1.searchData("snaKe"));
		System.out.println(t1.searchData("cat"));
		System.out.println(t1.searchData("Me"));
		t1.addNode("cab","xxxxxxxx");
		t1.addNode("car","wwwwwww s s s");
		System.out.println(t1.searchData("cab"));
		t1.addNode("car","wwwwwww s s s");
		System.out.println(t1.searchData("car"));
		t1.addNode("caC","xxssxxxxxx");
		System.out.println(t1.searchData("cac"));
		t1.addNode("caz","xxssxxxxxx");
		t1.addNode("cas","xxsssasaxxxxxx");
		System.out.println(t1.searchData("cAs"));
		System.out.println(t1.deleteData("cab"));
		System.out.println(t1.searchData("cac"));
		System.out.println(t1.searchData("cab"));
	 }
}

