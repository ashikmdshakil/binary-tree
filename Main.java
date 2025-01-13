import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*int[] numArray = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 7};
        BinaryTree binaryTree = new BinaryTree(numArray);

        TreeNode root = binaryTree.constructBinaryTree();
        System.out.println("total count is " + binaryTree.countTotalNodes(root));
        System.out.println("summation of nodes is " + binaryTree.summationOfNodes(root));
        System.out.println("height is " + binaryTree.height(root));
        binaryTree.levelOrderTraversal(root);
        System.out.println("diameter is " + binaryTree.diameter(root));
        System.out.println("smart diameter is " + binaryTree.smartDiameter(root).diameter);
        System.out.println();*/

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = null;
        int[] numbers = {50, 30, 70, 60, 80, 10};
        for (int number : numbers) {
            node = bst.placeData(node, number);
        }
        bst.inOrderTraversal(node);
        System.out.println();
        /*node = bst.deleteValue(node, 60);
        bst.inOrderTraversal(node);*/
        bst.printInRange(node, 10, 50);
        System.out.println("--------");
        bst.findPath(node, new ArrayList<>());
    }
}
