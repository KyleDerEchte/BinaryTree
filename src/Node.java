public class Node {
    private Node left;
    private Node right;
    private Integer value;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void add(int value) {
        if (this.value == null) {
            this.value = value;
            return;
        }
        if (this.value == value) {
            return;
        }
        if (value < this.value) {
            if (this.left != null) {
                this.left.add(value);
                return;
            }
            this.left = new Node(value);
            return;
        }
        if (this.right != null) {
            this.right.add(value);
            return;
        }
        this.right = new Node(value);
    }

    public int getMin() {
        Node current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current.getValue();
    }

    public int getMax() {
        Node current = this;
        while (current.right != null) {
            current = current.right;
        }
        return current.getValue();
    }

    public Node delete(int value) {
        if (value < this.value) {
            if (this.left != null) {
                this.left = this.left.delete(value);
            }
            return this;
        }
        if (value > this.value) {
            if (this.right != null) {
                this.right = this.right.delete(value);
            }
            return this;
        }
        if (this.right == null) {
            return this.left;
        }
        if (this.left == null) {
            return this.right;
        }
        Node minLagerNode = this.right;
        while (minLagerNode.getLeft() != null) {
            minLagerNode = minLagerNode.getLeft();
        }
        this.value = minLagerNode.getValue();
        this.right = this.right.delete(minLagerNode.getValue());
        return this;
    }

    public boolean exists(int value) {
        if (value == this.value) {
            return true;
        }
        if (value < this.value) {
            if (this.left == null) {
                return false;
            }
            return this.left.exists(value);
        }
        if (this.right == null) {
            return false;
        }
        return this.right.exists(value);
    }

    private Node getLeft() {
        return left;
    }

    private Node getRight() {
        return right;
    }

    private int getValue() {
        return value;
    }
}

