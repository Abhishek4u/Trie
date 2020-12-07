class Node {

    char ch;
    Node children[];
    int wordEnd = 0;

    Node(char ch) {

        this.ch = ch;
        this.children = new Node[26];
    }
}

public class Main {
    
    static Node root = new Node('-');
    public static void main(String[] args) {

        insert("abcd");
        insert("abad");
        insert("bcad");
        insert("bbad");
        insert("bb");
        insert("comm");
        insert("selected");

        search("abab");
        search("bbad");
        search("b");
        search("bb");
        search("comm");
        search("selected");
c        System.out.println("Congrats, You are selected!");
    }

    public static void insert(String str) {

        Node temp = root;

        int n = str.length();
        for(int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int idx = ch - 'a';

            if(temp.children[idx] == null) {
                
                temp.children[idx] = new Node(ch);
            }
            temp = temp.children[idx];

            if(i == n - 1) {
                temp.wordEnd++;
            }
        }
    }

    public static void search(String str) {

        int count = 0;
        Node temp = root;

        int n = str.length();
        for(int i = 0; i < n; i++) {

            int idx = str.charAt(i) - 'a';

            if(temp.children[idx] == null) break;
            
            temp = temp.children[idx];

            if(i == n-1 && temp.wordEnd != 0) {
                count = temp.wordEnd;
            }
        }

        if(count == 0) System.out.println(str + " Not found");
        else System.out.println("We found " + str + " " + count + " no. of times");
    }

}