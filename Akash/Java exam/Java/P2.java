public class P2 {
    public void show(Object ob) {
        if (ob==123) {
            System.out.println("Correct A AND D");
        } else {
            System.out.println("Error B AND C");
        }
    }
    public static void main(String[] args) {
        Integer s=123;
        P2 obj=new P2();
        obj.show(s);
    }
}