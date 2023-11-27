/**
 * Implements binary search trees.
 *
 * @author
 * @version
 */
public class BST<E extends Comparable<E>> extends BinaryTree<E> implements BST_Ops<E> {

    public BST(E data) {
        super(data);
    }
    public BST(E data, BinaryTree<E> left, BinaryTree<E> right) {
        super(data, left, right);
    }

    public BST(BinaryTree<E> tree) {
        super(tree);
    }

    public BST<E> lookup(E data) {
        if (isEmpty(this)) {
            return null;
        } else {
            int compare = data.compareTo(getData());
            if (compare == 0) {
                return this;
            } else if (compare < 0) {
                return (getLeft() != null) ? ((BST<E>) getLeft()).lookup(data) : null;
            } else {
                return (getRight() != null) ? ((BST<E>) getRight()).lookup(data) : null;
            }
        }
    }

    public void insert(E data) {
        if (isEmpty(this)) {
            setData(data);
        } else {
            int compare = data.compareTo(getData());
            if (compare <= 0) {
                if (getLeft() == null) {
                    setLeft(new BST<>(data));
                } else {
                    ((BST<E>) getLeft()).insert(data);
                }
            } else {
                if (getRight() == null) {
                    setRight(new BST<>(data));
                } else {
                    ((BST<E>) getRight()).insert(data);
                }
            }
        }
    }

    public BST<E> deleteWithCopyLeft(E evictee) {
        return deleteNodeWithCopyLeft(this, evictee);
    }

    private BST<E> deleteNodeWithCopyLeft(BST<E> root, E evictee) {
        if (isEmpty(root)) {
            return null;
        } else {
            int compare = evictee.compareTo(root.getData());
            if (compare < 0) {
                root.setLeft(deleteNodeWithCopyLeft((BST<E>) root.getLeft(), evictee));
            } else if (compare > 0) {
                root.setRight(deleteNodeWithCopyLeft((BST<E>) root.getRight(), evictee));
            } else {
                if (root.getLeft() == null) {
                    return (BST<E>) root.getRight();
                } else if (root.getRight() == null) {
                    return (BST<E>) root.getLeft();
                }
                BST<E> temp = findMinimum((BST<E>) root.getRight());
                root.setData(temp.getData());
                root.setRight(deleteNodeWithCopyLeft((BST<E>) root.getRight(), temp.getData()));
            }
            return root;
        }
    }

    private BST<E> findMinimum(BST<E> node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return findMinimum((BST<E>) node.getLeft());
        }
    }

    public BST<E> rotateLeft() {
        BST<E> newRoot = (BST<E>) getRight();
        setRight(newRoot.getLeft());
        newRoot.setLeft(this);
        return newRoot;
    }

    public BST<E> rotateRight() {
        BST<E> newRoot = (BST<E>) getLeft();
        setLeft(newRoot.getRight());
        newRoot.setRight(this);
        return newRoot;
    }
}