import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    Viết một chương trình cho phép người dùng thêm, hiển thị,
//    tìm kiếm thông tin sản phẩm vào file.
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("01", "GalaxyFold", "Samsung", 30000));
        productList.add(new Product("02", "Xiaomi Mi 11", "Xiaomi", 20000));
        productList.add(new Product("03", "Iphone 13", "Apple", 38000));

        writeToFile(productList);
        readOject();

    }

    public static void writeToFile(List<Product> productList){
        try{
            //tạo liên kết với file
            OutputStream os = new FileOutputStream("demo.txt");
            //tạo đối tượng con của ObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(os);
            //viết danh sách đó vào file
            oos.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readOject(){
        try {
            //tạo liên kết với file để đọc
            InputStream is = new FileInputStream("demo.txt");
            //tạo đối tượng con của ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(is);
            //tạo list để hứng phẩn tử sau khi đọc từ file
            List<Product> newProductList = (List<Product>)ois.readObject();
            for (Product p:newProductList) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
