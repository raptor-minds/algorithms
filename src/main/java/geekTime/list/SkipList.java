package geekTime.list;

public class SkipList {

    private static final int MAX_LEVEL = 16;
    private static final float SKIPLIST_P = 0.5f;

    private int levelCount = 1;

    private Node head = new Node();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount; i >= 0; i--) {
            while (p.forward[i] != null && p.forward[i].data < value) {
                p = p.forward[i];
            }
        }

        return null;
    }
}

    class Node<T> {
        static final int MAX_LEVEL = 16;
        int data;
        Node forward[] = new Node[MAX_LEVEL];
        int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
    }

    public static void main(String[] args) {
            String url = "https://dianrong.com/";
            System.out.println( url.replace("https://", "").replace("/", "").trim());
    }
}
