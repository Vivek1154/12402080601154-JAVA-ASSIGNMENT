class Outer {

    int x = 10;

    // 🔹 1. Member Inner Class
    class MemberInner {
        void display() {
            System.out.println("Member Inner Class: x = " + x);
        }
    }

    // Method to demonstrate Local Inner Class
    void showLocalInner() {
        int y = 20;

        // 🔹 2. Local Inner Class
        class LocalInner {
            void display() {
                System.out.println("Local Inner Class: x = " + x + ", y = " + y);
            }
        }

        LocalInner li = new LocalInner();
        li.display();
    }

    // Method to demonstrate Anonymous Inner Class
    void showAnonymousInner() {

        // 🔹 3. Anonymous Inner Class
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Anonymous Inner Class: Running...");
            }
        };

        r.run();
    }
}

// Main class
public class Program7 {
    public static void main(String[] args) {

        Outer obj = new Outer();

        // Member Inner Class
        Outer.MemberInner m = obj.new MemberInner();
        m.display();

        // Local Inner Class
        obj.showLocalInner();

        // Anonymous Inner Class
        obj.showAnonymousInner();
    }
}