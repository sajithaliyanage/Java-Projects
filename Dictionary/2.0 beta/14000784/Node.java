class Node {

    String keyWord;
    String meaningValue;
    Node left;
    Node right;

    public Node(String data, String meaning) {
        this.keyWord = data.toUpperCase();
        this.meaningValue = meaning;
        left = null;
        right = null;
    }

    public static String printKeyWord(Node data) {
        //System.out.print(data.keyWord);
        return data.keyWord;
    }

    public static String printMeaningValue(Node data) {
        //System.out.print(data.meaningValue);
        return data.meaningValue;
    }
}