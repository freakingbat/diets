package client;

import com.caucho.hessian.client.HessianProxyFactory;
import diets.api.DataService;
import diets.api.LoginService;
import java.net.MalformedURLException;

/** 
 * Этот класс, позволяющий получить доступ к API
 * @author Pro
 */
public class Service {
    private static LoginService loginService = null;
    private static DataService dataService = null;
    
    public static synchronized LoginService getLoginService() throws MalformedURLException {
        if(loginService == null){
            String url = "http://localhost:8084/Server/LoginService";
            HessianProxyFactory factory = new HessianProxyFactory();
            loginService = (LoginService) factory.create(LoginService.class, url);
        } 
        return loginService;
    }
    
    
    public static synchronized DataService getDataService() throws MalformedURLException {
        if(dataService == null){
            String url = "http://localhost:8084/Server/DataService";
            HessianProxyFactory factory = new HessianProxyFactory();
            dataService = (DataService) factory.create(DataService.class, url);
        } 
        return dataService;
    }
}