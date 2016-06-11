package dictionary;

import static dictionary.BinaryTree.root;
import java.io.*;
import java.util.*;

public class FileReadInputs {

    FileReader read;
    String thisLine;
    ArrayList<String> thisLine2;

    public FileReadInputs() {
        this.read = null;
        this.thisLine = null;
        this.thisLine2 = new ArrayList<String>();
    }

    public void readInputs() {
        try {
            BinaryTree t1 = new BinaryTree();
            // open input stream inputs.txt for reading purpose.
            read = new FileReader("C:\\Users\\Sajitha\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\inputs.txt");
            BufferedReader br = new BufferedReader(read);
            int x = 0;
            while ((thisLine = br.readLine()) != null) {
                thisLine2.add(thisLine);
                x++;
            }
            try {
                for (int y = 0; y < thisLine2.size(); y++) {
                    String lines[] = thisLine2.get(y).split("-");
                    //System.out.println(lines[0]+" - "+lines[1]);
                    t1.addNode(lines[0], lines[1]);
                }
            } catch (Exception e) {
                System.out.print("");
            }

            //System.out.println(lines[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeInputs() {
        try {
            FileWriter fwOb = new FileWriter("C:\\Users\\Sajitha\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\inputs.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
        } catch (Exception e) {
            System.err.print((e.getMessage()));
        }

    }

    public void writeInputs() {
        Writer writer = null;
        Stack<Node> nodeStack = new Stack<Node>();
        //BinaryTree temp = new BinaryTree();
        //String upperCase_Data = data.toUpperCase(); //convert to UPPERCASE input word
        //String meaningData = this.searchData(data);
        String inputWord = "";
        nodeStack.push(root);

        while (nodeStack.empty() == false) {
            Node topNode = nodeStack.pop();

            inputWord += Node.printKeyWord(topNode) + "-" + Node.printMeaningValue(topNode) + "\n";
            //System.out.println(Node.printMeaningValue(topNode));
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("C:\\Users\\Sajitha\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\inputs.txt"), "utf-8"));

                writer.write(inputWord.substring(0, inputWord.length() - 1));
            } catch (IOException ex) {

            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {
                }
            }

            if (topNode.right != null) {
                nodeStack.push(topNode.right);
            }

            if (topNode.left != null) {
                nodeStack.push(topNode.left);
            }
        }

    }

    public void appendWords(String data) {
        //data = "sasa-sasasasasa";
        try (FileWriter fw = new FileWriter("C:\\Users\\Sajitha\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\inputs.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                out.println();
                out.print(data);
            //more code
        } catch (IOException e) {
            System.out.print("");
        }
    }
    
}
