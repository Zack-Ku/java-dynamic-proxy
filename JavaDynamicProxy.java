import java.lang.reflect.Proxy;

/**
 * javaDynamicProxy
 */
public class JavaDynamicProxy {
    public static void main(String[] args) {
        Zack zack = new Zack();

        Developer zackProxy = (Developer) Proxy.newProxyInstance(zack.getClass().getClassLoader(),
                zack.getClass().getInterfaces(), (proxy, method, agrs) -> {
                    if (method.getName().equals("code")) {
                        System.out.println("Proxy Zack coding！");
                    }
                    return method.invoke(zack, agrs);
        });
        
        zackProxy.code();
        zackProxy.debug();
    }
}