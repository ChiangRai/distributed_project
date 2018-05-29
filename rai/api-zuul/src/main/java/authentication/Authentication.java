package authentication;

/**
 * Created by Administrator on 2018/5/27 0027.
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/***
 * 鉴权
 */
public class Authentication extends ZuulFilter{

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
