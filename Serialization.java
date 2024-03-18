//Serialization
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class Customer implements java.io.Serializable {
    private int id;
    private String name;
    private String contactNo;
    private String address;

    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    
}

public class Main{
    public static void main(String[] args) {
        Customer customer = new Customer(101, "Alice", "1234567890", "New York");

        try {
            FileOutputStream fileOut = new FileOutputStream("JavaObject.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customer);
            out.close();
            fileOut.close();
            System.out.println("Customer object serialized to JavaObject.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
