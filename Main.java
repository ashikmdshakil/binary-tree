public class Main {
    public static void main(String[] args) {
        int[] numArray = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 7};
        BinaryTree binaryTree = new BinaryTree(numArray);

        TreeNode root = binaryTree.constructBinaryTree();
        System.out.println("total count is " + binaryTree.countTotalNodes(root));
        System.out.println("summation of nodes is " + binaryTree.summationOfNodes(root));
        System.out.println("height is " + binaryTree.height(root));
        binaryTree.levelOrderTraversal(root);
        System.out.println("diameter is " + binaryTree.diameter(root));
        System.out.println("smart diameter is " + binaryTree.smartDiameter(root).diameter);
        System.out.println();
    }
}
