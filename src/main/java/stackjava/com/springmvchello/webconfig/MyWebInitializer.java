package stackjava.com.springmvchello.webconfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { SpringWebConfig.class };
  }
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }
}