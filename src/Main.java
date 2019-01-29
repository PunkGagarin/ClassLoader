
public class Main {
    public static void main(String[] args) throws Exception {
        //создаём экземпляр нашего ClassLoader
        ClassLoader pcl = new PathClassLoader();

        //Ищем класс
        Class clazz = ((PathClassLoader) pcl).findClass("TestModule");

        //создаём экземпляр класса и вызываем его метод toString
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}
