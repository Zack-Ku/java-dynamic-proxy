import java.lang.reflect.Proxy;

/**
 * javaDynamicProxy
 */
public class JavaDynamicProxy {
    public static void main(String[] args) {
        Zack zack = new Zack();

        Developer zackProxy = (Developer) Proxy.newProxyInstance(zack.getClass().getClassLoader(),
                zack.getClass().getInterfaces(), (p, method, par) -> {
                    if (method.getName().equals("code")) {
                        System.out.println("Proxy Zack coding！");
                    }
                    return method.invoke(zack, par);
        });
        
        zackProxy.code();
        zackProxy.debug();
    }
}