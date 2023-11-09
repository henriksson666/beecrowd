import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    private static class BinarySearchTreeNode {

        int value;
        BinarySearchTreeNode leftChild = null;
        BinarySearchTreeNode rightChild = null;
    }

    private static BufferedWriter bufferedWriter;
    private static BinarySearchTreeNode root;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(bufferedReader.readLine());
        int caseNumber = 1;
        while (caseCount-- > 0) {
            int nodeCount = Integer.parseInt(bufferedReader.readLine());
            String[] inputData = bufferedReader.readLine().split(" ");
            // Insert data into BST
            root = null;
            int index = 0;
            while (nodeCount-- > 0) {
                BinarySearchTreeNode newNode = new BinarySearchTreeNode();
                int nodeValue = Integer.parseInt(inputData[index]);
                newNode.value = nodeValue;
                if (root == null) {
                    root = newNode;
                } else {
                    insertNode(root, newNode);
                }
                index++;
            }

            bufferedWriter.append("Case " + caseNumber + ":\n");
            bufferedWriter.append("Pre.: ");
            printPreOrderTraversal();
            bufferedWriter.append("In..: ");
            printInOrderTraversal();
            bufferedWriter.append("Post: ");
            printPostOrderTraversal();
            bufferedWriter.newLine();
            caseNumber++;
        }
        bufferedWriter.flush();
    }

    private static void insertNode(BinarySearchTreeNode current, BinarySearchTreeNode newNode) {
        int newData = newNode.value;
        while (true) {
            if (newData < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    private static void printPreOrderTraversal() throws IOException {
        Stack<BinarySearchTreeNode> stack = new Stack<>();
        stack.push(root);
        boolean isFirstValue = true;
        while (!stack.empty()) {
            BinarySearchTreeNode currentNode = stack.pop();
            if (!isFirstValue) {
                bufferedWriter.append(" ");
            } else {
                isFirstValue = false;
            }
            bufferedWriter.append(Integer.toString(currentNode.value));

            if (currentNode.rightChild != null) {
                stack.push(currentNode.rightChild);
            }
            if (currentNode.leftChild != null) {
                stack.push(currentNode.leftChild);
            }
        }
        bufferedWriter.newLine();
    }

    private static void printInOrderTraversal() throws IOException {
        Stack<BinarySearchTreeNode> stack = new Stack<>();
        BinarySearchTreeNode currentNode = root;
        boolean isFirstValue = true;
        while (!stack.empty() || currentNode != null) {

            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            } else {
                BinarySearchTreeNode node = stack.pop();
                if (!isFirstValue) {
                    bufferedWriter.append(" ");
                } else {
                    isFirstValue = false;
                }
                bufferedWriter.append(Integer.toString(node.value));
                currentNode = node.rightChild;
            }
        }
        bufferedWriter.newLine();
    }

    private static void printPostOrderTraversal() throws IOException {
        Stack<BinarySearchTreeNode> stack = new Stack<>();
        BinarySearchTreeNode currentNode = root;
        boolean isFirstValue = true;
        while (true) {

            if (currentNode != null) {
                if (currentNode.rightChild != null) {
                    stack.push(currentNode.rightChild);
                }
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
                continue;
            }

            if (stack.isEmpty()) {
                break;
            }
            currentNode = stack.pop();

            if (currentNode.rightChild != null && !stack.isEmpty() && currentNode.rightChild == stack.peek()) {
                stack.pop();
                stack.push(currentNode);
                currentNode = currentNode.rightChild;
            } else {
                if (!isFirstValue) {
                    bufferedWriter.append(" ");
                } else {
                    isFirstValue = false;
                }
                bufferedWriter.append(Integer.toString(currentNode.value));
                currentNode = null;
            }
        }
        bufferedWriter.newLine();
    }
}