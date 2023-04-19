public class Main {
    public static void main(String[] args) {
/*
        MyArrayList list = new MyArrayList();
        list.add(667);
        list.add(228);
        list.add(1488);
        System.out.println("size now - " + list.size());
        System.out.println(list.contains(228));
        System.out.println("removed - " + list.remove(1));
        System.out.println("size now - " + list.size());
        System.out.println(list.contains(228));
        System.out.println(list.get(0));
        list.add(0, 0);
        System.out.println(list.get(7));
        System.out.println(list.indexOf(667));
        list.add(667);
        System.out.println(list.lastIndexOf(667));
        list.add("aishelek");
        System.out.println("size now - " + list.size());
        list.remove("aishelek");
        System.out.println("size now - " + list.size());
*/

        MyLinkedList list = new MyLinkedList();
        list.add("apple");
        list.add("banana");
        list.add("grape");
        System.out.println("size now - " + list.size());
        System.out.println(list.contains("banana"));
        System.out.println("removed - " + list.remove(1));
        System.out.println("size now - " + list.size());
        System.out.println(list.contains("banana"));
        System.out.println(list.get(0));
        list.add(0, 0);
        System.out.println(list.get(0));
        System.out.println(list.indexOf("apple"));
        list.add("apple");
        System.out.println(list.lastIndexOf("apple"));
    }
}