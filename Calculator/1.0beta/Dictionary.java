package dictionary;

public class Dictionary {

    public static void main(String[] args) {    
        Interface inter=new Interface();
        FileReadInputs file1 = new FileReadInputs();      
        BinaryTree t1 = new BinaryTree();
        
        file1.readInputs();
        //file1.removeInputs();
        
        System.out.println(t1.searchData("SNAKE"));
        //System.out.println(t1.deleteData("snaKe"));
        //t1.addNewNode("cartw","xxxxxxxx");
        //file1.removeInputs();
        //file1.writeInputs();
        //file1.appendWords();
        //file1.writeInputs();
/*
        System.out.println(t1.searchData("snaKe"));
        System.out.println(t1.deleteData("snaKe"));
        System.out.println(t1.searchData("snaKe"));
        
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
        t1.findSimilarWord("puppy");*/

    }
}
