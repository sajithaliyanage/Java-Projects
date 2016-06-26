

public class Dictionary {
       public static BinaryTree t1;
       
    public static void main(String[] args) {    
        
        FileReadInputs file1 = new FileReadInputs();            
        t1 = file1.readInputs();
        Interface inter = new Interface(t1);
 
    }
}
