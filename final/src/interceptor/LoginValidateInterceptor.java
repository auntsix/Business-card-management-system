package interceptor;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

public class LoginValidateInterceptor implements Interceptor {
    private static final long serialVersionUID=1L;

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext=actionInvocation.getInvocationContext();
        //获取session对象
        Map<String,Object> session=actionContext.getSession();
        //从session中取名为user的session属性
        String user=(String)session.get("userName");
        if(user!=null){
            return actionInvocation.invoke();
        }else {
            //返回全局视图
            return "nologin";
        }

    }
}
