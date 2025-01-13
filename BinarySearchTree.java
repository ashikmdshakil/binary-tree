import java.util.List;

public class BinarySearchTree {
    public TreeNode placeData(TreeNode root, int number) {
        if (root == null) {
            return new TreeNode(number);
        } else if (number < root.data) {
            root.leftNode = placeData(root.leftNode, number);
        } else if (number > root.data) {
            root.rightNode = placeData(root.rightNode, number);
        }
        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.leftNode);
        System.out.println(root.data);
        inOrderTraversal(root.rightNode);
    }

    public boolean findValue(TreeNode root, int number) {
        if (root == null) {
            return false;
        } else if (root.data < number) {
            return findValue(root.rightNode, number);
        } else if (root.data > number) {
            return findValue(root.leftNode, number);
        } else {
            return true;
        }
    }

    public TreeNode deleteValue(TreeNode root, int number) {
        if (root == null) {
            return null;
        } else if (root.data > number) {
            root.leftNode = deleteValue(root.leftNode, number);
        } else if (root.data < number) {
            root.rightNode = deleteValue(root.rightNode, number);
        } else {
            if (root.leftNode == null && root.rightNode == null) {
                return null;
            } else if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null) {
                return root.leftNode;
            } else {
                TreeNode successorNode = inOrderSuccessorNode(root.rightNode);
                root.data = successorNode.data;
                root.rightNode = deleteValue(root.rightNode, successorNode.data);
                return root;
            }
        }
        return root;
    }

    public TreeNode inOrderSuccessorNode(TreeNode root) {
        TreeNode node = root;
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }

    public void printInRange(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        if (x <= root.data && root.data <= y) {
            printInRange(root.leftNode, x, y);
            System.out.println(root.data);
            printInRange(root.rightNode, x, y);
        } else if (root.data < x) {
            printInRange(root.rightNode, x, y);
        } else {
            printInRange(root.leftNode, x, y);
        }
    }

    public void findPath(TreeNode root, List<Integer> paths) {
        if (root == null) {
            return;
        }
        paths.add(root.data);
        if (root.leftNode == null && root.rightNode == null) {
            printPath(paths);
        } else {
            findPath(root.leftNode, paths);
            findPath(root.rightNode, paths);
        }
        paths.remove(paths.size() - 1);
    }

    public void printPath(List<Integer> paths) {
        for (Integer path : paths) {
            System.out.print(path + " ");
        }
        System.out.println();
    }
}
