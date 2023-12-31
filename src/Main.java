import lists.MyLinkedList;


public class Main {
    public static void main(String[] args) {

        MyLinkedList<String> lnkdList = new MyLinkedList<>();
        lnkdList.add("1");
        lnkdList.add("2");
        lnkdList.add("3");
        lnkdList.addFirst("4");
        lnkdList.delete(0);
        System.out.println("'3'" + lnkdList.get(3));
        for (String s : lnkdList){
            System.out.println(s);
        }
    }
}