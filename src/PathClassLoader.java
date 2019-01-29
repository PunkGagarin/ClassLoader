import java.io.*;

public class PathClassLoader extends ClassLoader {
    //Сменить имя в зависимости от функционала!


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes;
        String fileName = null;
        Class<?> cl = null;

        System.out.println("Введите путь к файлу:");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //считываем массив байт из файла и передаем методу defineClass
        try(FileInputStream fis = new FileInputStream(fileName)){
            bytes = new byte[fis.available()];
            fis.read(bytes,0,bytes.length);
            cl = defineClass(name, bytes, 0, bytes.length);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return cl;
    }
}
