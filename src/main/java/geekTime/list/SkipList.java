package geekTime.list;

public class SkipList {

    private static final int MAX_LEVEL = 16;
    private static final float SKIPLIST_P = 0.5f;

    private int levelCount = 1;

    private Node head = new Node(MAX_LEVEL);

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        return null;
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node(level);
        newNode.data = value;
        newNode.maxLevel = level;

        // record all the changes
        Node update[] = new Node[level];

        // record every level largest value which smaller than insert value in update array.
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }


    }

    // theory, for the first level there's 50% probability to hit, and the second round, for the
    // next 25% probability
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }
}