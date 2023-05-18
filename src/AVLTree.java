public class AVLTree {
    class Node {
        int key;
        Node left;
        Node right;
        int height;

        public Node(int key) {
            this.key = key;
            height = 1;
        }
    }

    Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    int max(int a, int b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.height = max(height(node.left), height(node.right)) + 1;

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (key < node.left.key) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (key > node.right.key) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node leftRotate(Node node) {
        Node y = node.right;
        Node T2 = y.left;

        y.left = node;
        node.right = T2;

        node.height = max(height(node.left), height(node.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node rightRotate(Node node) {
        Node y = node.left;
        Node T3 = y.right;

        y.right = node;
        node.left = T3;

        node.height = max(height(node.left), height(node.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public void height(){
        System.out.println(height(root)); 

    }

    public void preorder() {
        preorder(root);
        System.out.println("");
    }

    public void inorder() {
        inorder(root);
        System.out.println("");
    }

    public void postorder() {
        postorder(root);
        System.out.println("");
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);                  // Left
            System.out.print(node.key + " ");  // Root
            inorder(node.right);                 // Right
        } 
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);               // Left
            postorder(node.right);              // Right
            System.out.print(node.key + " "); // Root
        }
    }
}