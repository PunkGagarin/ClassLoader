
public class Main {
    public static void main(String[] args) throws Exception {
        ClassLoader pcl = new PathClassLoader();
        Class clazz = ((PathClassLoader) pcl).findClass("TestModule");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}
