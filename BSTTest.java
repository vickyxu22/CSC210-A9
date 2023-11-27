public class BSTTest {
    public static void main(String[] args) {
        // Create a BST
        BST<Integer> bst = new BST<>(5);
        
        // Insert elements
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Display the tree using inorder traversal
        System.out.println("Inorder Traversal:");
        System.out.println(bst.inorderString(bst));

        // Look up an element
        int lookupValue = 9;
        BST<Integer> foundNode = bst.lookup(lookupValue);
        if (foundNode != null) {
            System.out.println("Element " + lookupValue + " found in the tree.");
        } else {
            System.out.println("Element " + lookupValue + " not found in the tree.");
        }

        // Delete an element
        int deleteValue = 3;
        bst.deleteWithCopyLeft(deleteValue);

        // Display the tree after deletion
        System.out.println("\nInorder Traversal after deletion of " + deleteValue + ":");
        System.out.println(bst.inorderString(bst));

        // Perform rotations
        // bst = bst.rotateLeft();
        bst = bst.rotateRight();

        // Display the tree after rotations
        System.out.println("\nInorder Traversal after rotations:");
        System.out.println(bst.inorderString(bst));
    }
}
