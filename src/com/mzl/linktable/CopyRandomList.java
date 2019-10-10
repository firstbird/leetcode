package com.mzl.linktable;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodes = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            nodes.put(cur, new Node(cur.val, null, null));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            nodes.get(cur).next = nodes.get(cur.next);
            nodes.get(cur).random = nodes.get(cur.random);
            cur = cur.next;
        }
        return nodes.get(head);
    }



}
