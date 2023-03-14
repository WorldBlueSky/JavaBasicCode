import java.util.PriorityQueue;

public class SingleClass {

    // 单例类中的实例，private修饰代表只能在本类中进行访问
    private volatile static SingleClass instance;

    public SingleClass getInstance(){
        if (instance==null) {
            synchronized (this) {
                if(instance==null){
                    return new SingleClass();
                }
            }
        }
        return instance;
    }


}
