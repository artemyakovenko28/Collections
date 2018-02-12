package labs.List_ArrayList_LinkedList;

public class Tester {
    public static void main(String[] args) {
        SimpleList<Integer> list = new SimpleArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        System.out.println(list.toString());

        SimpleList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(null);
        linkedList.add(7);
//        System.out.println(linkedList.remove(new Integer(10)));
//        System.out.println(linkedList.remove(null));
//        System.out.println(linkedList.remove(new Integer(3)));
//        System.out.println(linkedList.remove(new Integer(3)));
//        System.out.println(linkedList);
        System.out.println(linkedList);
    }
}
