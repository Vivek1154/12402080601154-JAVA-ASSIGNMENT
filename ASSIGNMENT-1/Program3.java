public class Program3 {
    public static void main(String[] args) {

        int a = 10;
        Integer obj = Integer.valueOf(a); 

        // Wrapper to Primitive (Unboxing)
        int b = obj.intValue();            

        Integer x = 20; 
        int y = x;        

        String str = "123";
        int num = Integer.parseInt(str);

        System.out.println("Wrapper Class Demo:");
        System.out.println("Primitive value: " + a);
        System.out.println("Boxed value: " + obj);
        System.out.println("Unboxed value: " + b);
        System.out.println("Auto-unboxed value: " + y);
        System.out.println("Parsed integer: " + num);

        String s1 = "Hello";
        String s2 = s1.concat(" World");  
        System.out.println("\nString after concat (immutable): " + s1);
        System.out.println("New string from concat: " + s2);

        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");  
        System.out.println("StringBuffer after append (mutable): " + sb);

        // Comparing behavior
        System.out.println("\nComparison:");
        System.out.println("String is immutable (cannot change original value)");
        System.out.println("StringBuffer is mutable (can change original value)");
    }
}