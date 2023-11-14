package pl.strefakursow.spring_zaawansowany.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class HeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse newResponse = (HttpServletResponse) response;
        newResponse.addHeader("strefakursow", "jest super");

        chain.doFilter(request, newResponse);
    }
}
