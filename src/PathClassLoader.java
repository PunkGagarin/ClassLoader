import java.io.*;

public class PathClassLoader extends ClassLoader {
    //Сменить имя в зависимости от функционала!


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //допилить
        byte[] bytes;
        String fileName = null;
        Class<?> cl = null;

        System.out.println("Введите путь к файлу");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream(fileName)){
            bytes = new byte[fis.available()];
            int count = fis.read(bytes);
            cl = defineClass(name, bytes, 0, bytes.length);
            return cl;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return cl;
    }
}
