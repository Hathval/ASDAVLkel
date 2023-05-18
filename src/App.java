import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String input;
        String splitted[]=new String[2];
        AVLTree avl = new AVLTree();

        while(s.hasNextLine()) {
            input = s.nextLine();
            splitted = input.split(" ");

            if(splitted[0].equals("insert")) {
                try {
                    avl.insert(Integer.parseInt(splitted[1]));
                } catch (NumberFormatException e) {
                    System.out.println("Input ulang");
                }
            }else if(splitted[0].equals("print")) {
                if(splitted[1].equals("preorder")) {
                    avl.preorder();
                    System.out.println("");
                }else if(splitted[1].equals("inorder")) {
                    avl.inorder();
                }else if(splitted[1].equals("postorder")) {
                    avl.postorder();
                }else if(splitted[1].equals("levels")) {
                    avl.height();
                }
            }else if(input.equals("exit")) {
                break;
            }else {
                System.out.println("Input ulang");
                continue;
            }
        }

    }
}
