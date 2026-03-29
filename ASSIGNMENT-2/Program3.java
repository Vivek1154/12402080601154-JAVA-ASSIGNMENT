import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}

public class Program3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> list = new ArrayList<>();
        HashMap<Integer, String> hmap = new HashMap<>();
        TreeMap<Integer, String> tmap = new TreeMap<>();

        int choice;

        do {
            System.out.println("\n1.Add 2.View 3.Update 4.Delete 5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    list.add(new Student(id, name));
                    hmap.put(id, name);
                    tmap.put(id, name);

                    System.out.println("Record Added");
                    break;

                case 2:
                    System.out.println("\nArrayList:");
                    for (Student s : list) {
                        System.out.println(s);
                    }

                    System.out.println("\nHashMap:");
                    for (Map.Entry<Integer, String> e : hmap.entrySet()) {
                        System.out.println(e.getKey() + " - " + e.getValue());
                    }

                    System.out.println("\nTreeMap:");
                    for (Map.Entry<Integer, String> e : tmap.entrySet()) {
                        System.out.println(e.getKey() + " - " + e.getValue());
                    }
                    break;

                case 3:
                    System.out.print("Enter id to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    for (Student s : list) {
                        if (s.id == uid) {
                            s.name = newName;
                        }
                    }

                    if (hmap.containsKey(uid)) {
                        hmap.put(uid, newName);
                    }

                    if (tmap.containsKey(uid)) {
                        tmap.put(uid, newName);
                    }

                    System.out.println("Record Updated");
                    break;

                case 4:
                    System.out.print("Enter id to delete: ");
                    int did = sc.nextInt();

                    list.removeIf(s -> s.id == did);
                    hmap.remove(did);
                    tmap.remove(did);

                    System.out.println("Record Deleted");
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }
}
