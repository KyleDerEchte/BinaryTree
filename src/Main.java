public class Main {
    public static void main(String[] args) {
        Node node = new Node(0);
        node.add(2);
        node.add(3);
        node.add(7);
        node.add(6);
        node.add(-1);

        System.out.println(node.getMin());
        System.out.println(node.getMax());
    }
}
