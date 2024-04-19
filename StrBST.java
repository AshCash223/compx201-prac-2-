public class StrBST {

    Node root;

    public static void main(String[] args) {

        StrBST bst = new StrBST();
        bst.insert("A");
        bst.insert("B");
        bst.insert("C");

        // Print the BST before removal
    System.out.println("BST before removal:");
    bst.printR(bst.root);

    // Remove a node from the BST
    bst.remove("C");

    // Print the BST after removal
    System.out.println("BST after removal:");
    bst.printR(bst.root);
    }

    public void insert(String s) {
        root = insertNode(root, s);
    }

    private Node insertNode(Node currRoot, String s) {
        if (currRoot == null) {
            return new Node(s); // Create a new node if current node is null
        }

        int compare = s.compareTo(currRoot.value);

        if (compare < 0) {
            currRoot.left = insertNode(currRoot.left, s); // Insert into the left subtree
        } else if (compare > 0) {
            currRoot.right = insertNode(currRoot.right, s); // Insert into the right subtree
        }
        
        return currRoot; // Return the updated root of the subtree
    }

    public boolean search(String s){

		boolean found = searchNode(root, s);
		return found;
	}

	private boolean searchNode(Node currRoot, String s){
			boolean found = false;
			int compare = s.compareTo(currRoot.value);
			// No tree so add here
			if (currRoot == null){
				return false;
			} else if (s == currRoot.value){
				return true;
			}
			// Value is smaller
			else if (compare < 0){
			found = searchNode(currRoot.left, s);
			}
			// Value is larger
			else if (compare > 0){
			found = searchNode(currRoot.right, s);
			}
			return found;
		}

		public void printR(Node currRoot){

				if (currRoot == null){
					return;
				}

				// Print parent node
				System.out.print("Node: " + currRoot.value);
				// Print left child
				if(currRoot.left != null){
					System.out.print(" | Left: " + currRoot.left.value);
				} else {
				System.out.print(" | Left: null");
				}
				// Print right child
				if(currRoot.right != null){
					System.out.print(" | Right: " + currRoot.right.value);
				} else {
					System.out.print(" | Right: null");
				}

				System.out.println();
				printR(currRoot.left);
				printR(currRoot.right);
			}

			public void remove(String s) {
    root = removeNode(root, s);
}

private Node removeNode(Node currRoot, String s) {
    if (currRoot == null) {
        return null; // Value not found, nothing to remove
    }

    int compare = s.compareTo(currRoot.value);

    if (compare < 0) {
        currRoot.left = removeNode(currRoot.left, s); // Recursively remove from the left subtree
    } else if (compare > 0) {
        currRoot.right = removeNode(currRoot.right, s); // Recursively remove from the right subtree
    } else {
        // Found the node to be removed

        // Case 1: Node has no children or one child
        if (currRoot.left == null) {
            return currRoot.right; // Replace with right child (or null if no child)
        } else if (currRoot.right == null) {
            return currRoot.left; // Replace with left child
        }

        // Case 2: Node has two children
        // Find successor node (smallest node in the right subtree)
        Node successor = findSuccessor(currRoot.right);
        // Replace current node's value with successor's value
        currRoot.value = successor.value;
        // Recursively remove the successor node
        currRoot.right = removeNode(currRoot.right, successor.value);
    }

    return currRoot; // Return the updated root of the subtree
}

private Node findSuccessor(Node currRoot) {
    // Find the leftmost node in the subtree (smallest node)
    while (currRoot.left != null) {
        currRoot = currRoot.left;
    }
    return currRoot;
}
}