public class Exceptions extends java.lang.Exception {
    public Exceptions() {
        System.out.println("Не верно введено выражение");
    }

    public Exceptions(String message) {
        this();
        System.out.println(message);
    }
}
