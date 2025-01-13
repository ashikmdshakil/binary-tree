import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private int[] array;
    private int index;

    public BinaryTree(int[] numbers) {
        this.array = numbers;
        this.index = -1;
    }

    public TreeNode constructBinaryTree() {
        index++;
        if (index >= array.length) {
            return null;
        }
        if (array[index] == -1) {
            return null;
        }
        TreeNode node = new TreeNode(array[index]);
        node.leftNode = constructBinaryTree();
        node.rightNode = constructBinaryTree();
        return node;
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.leftNode);
        preOrderTraversal(root.rightNode);
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.leftNode);
        System.out.println(root.data);
        inOrderTraversal(root.rightNode);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.leftNode);
        postOrderTraversal(root.rightNode);
        System.out.println(root.data);
    }

    public int countTotalNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countTotalNodes(root.leftNode);
        int rightCount = countTotalNodes(root.rightNode);
        return leftCount + rightCount + 1;
    }

    public int summationOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSummation = summationOfNodes(root.leftNode);
        int rightSummation = summationOfNodes(root.rightNode);
        return leftSummation + rightSummation + root.data;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.leftNode);
        int rightHeight = height(root.rightNode);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                if (queue.isEmpty()) {
                    System.out.println();
                } else {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(node.data + " ");
                if (node.leftNode != null) {
                    queue.add(node.leftNode);
                }
                if (node.rightNode != null) {
                    queue.add(node.rightNode);
                }
            }
        }
    }

    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter(root.leftNode);
        int rightDiameter = diameter(root.rightNode);

        int leftHeight = height(root.leftNode);
        int rightHeight = height(root.rightNode);
        int diameterByHeight = leftHeight + rightHeight + 1;

        return Math.max(Math.max(leftDiameter, rightDiameter), diameterByHeight);
    }

    public NodeInfo smartDiameter(TreeNode root) {
        if (root == null) {
            return new NodeInfo(0, 0);
        }
        NodeInfo leftDiameter = smartDiameter(root.leftNode);
        NodeInfo rightDiameter = smartDiameter(root.rightNode);

        int currentHeight = Math.max(leftDiameter.height, rightDiameter.height) + 1;
        int diameterByHeight = leftDiameter.height + rightDiameter.height + 1;

        int diameter = Math.max(Math.max(leftDiameter.diameter, rightDiameter.diameter), diameterByHeight);
        return new NodeInfo(diameter, currentHeight);
    }
}
