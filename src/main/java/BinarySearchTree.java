import java.util.Objects;

// Google. (2026). Gemini (Gemini 3.1 Pro) [Large language model]. https://gemini.google.com
// For the BST Data Structure
/**
 * A Binary Search Tree (BST) storing comparable keys.
 *
 * <p>Uses edge-count height: an empty tree has height -1, and a single-node
 * tree has height 0.</p>
 *
 * @param <T> the type of elements maintained by this tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private static final class Node<E> {
        private final E key;
        private Node<E> left;
        private Node<E> right;

        private Node(E key) {
            this.key = key;
        }
    }

    /**
     * Result of a search operation, including whether the key was found
     * and how many nodes were inspected along the search path.
     */
    public static final class SearchResult {
        private final boolean found;
        private final int nodesVisited;

        public SearchResult(boolean found, int nodesVisited) {
            this.found = found;
            this.nodesVisited = nodesVisited;
        }

        public boolean isFound() {
            return found;
        }

        public int getNodesVisited() {
            return nodesVisited;
        }
    }

    private Node<T> root;
    private int size;

    /**
     * Inserts a value into the BST if it is not already present.
     *
     * @param key non-null value to insert
     * @return {@code true} if inserted, {@code false} if duplicate
     */
    public boolean insert(T key) {
        Objects.requireNonNull(key, "Key must not be null");
        int previousSize = size;
        root = insertRecursive(root, key);
        return size > previousSize;
    }

    private Node<T> insertRecursive(Node<T> current, T key) {
        if (current == null) {
            size++;
            return new Node<>(key);
        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = insertRecursive(current.left, key);
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, key);
        }
        // Duplicate keys are ignored in a standard set-like BST.
        return current;
    }

    /**
     * Searches for a key in the BST and returns both presence and the number
     * of nodes visited during the traversal.
     *
     * @param key value to search for
     * @return a {@link SearchResult} containing match status and visit count
     */
    public SearchResult findWithCount(T key) {
        Objects.requireNonNull(key, "Key must not be null");
        int visited = 0;
        Node<T> current = root;

        while (current != null) {
            visited++;
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                return new SearchResult(true, visited);
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return new SearchResult(false, visited);
    }

    /**
     * Convenience method returning whether a key exists in the BST.
     *
     * @param key value to search for
     * @return {@code true} if present
     */
    public boolean contains(T key) {
        return findWithCount(key).isFound();
    }

    /**
     * Computes the height of the BST (number of edges on the longest
     * root-to-leaf path; -1 if empty).
     *
     * @return height of the tree
     */
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node<T> current) {
        if (current == null) {
            return -1;
        }
        return 1 + Math.max(heightRecursive(current.left), heightRecursive(current.right));
    }

    /**
     * Returns the number of unique keys currently stored in the BST.
     *
     * @return number of nodes in the tree
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}