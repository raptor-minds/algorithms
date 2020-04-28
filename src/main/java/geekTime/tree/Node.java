package geekTime.tree;

/**
 * The type Node.
 *
 * @param <T> the type parameter
 */
public class Node<T> {
    /**
     * The Data.
     */
    T data;
    /**
     * The Left.
     */
    Node<T> left;
    /**
     * The Right.
     */
    Node<T> right;

    /**
     * Gets data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets left.
     *
     * @return the left
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Gets right.
     *
     * @return the right
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }
}
