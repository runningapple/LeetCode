import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @date 2018/8/12 下午2:41
 * @description:
 */
public class LRUCache {

    private int size;

    private Node head;

    private Node rear;

    private Map<Integer, Node> cache;

    //146. LRU Cache
    public LRUCache(int capacity) {
        this.size = capacity;
        head = new Node(null, null);
        rear = new Node(null, null);
        head.next = rear;
        rear.pre = head;
        cache = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            appendRear(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            cache.put(key, node);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            appendRear(node);
            return;
        }
        if (size == cache.size()) {
            cache.remove(head.next.key);
            Node tmp = new Node(null, null);//用来释放被删除节点的内存
            tmp.next = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            tmp.next.next = null;
            tmp.next.pre = null;
            tmp.next = tmp.pre = null;
        }
        node = new Node(key, value);
        appendRear(node);
        cache.put(key, node);
    }

    private void appendRear(Node node) {
        node.next = rear;
        node.pre = rear.pre;
        rear.pre.next = node;
        rear.pre = node;
    }

    class Node {
        Node pre;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(Node pre, Node next) {
            this.pre = pre;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
    }
}
