package entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("example")
@Scope("singleton")
public class ExampleBean {

	public ExampleBean() {
        System.out.println("瀹炰緥鍖朎xampleBean锛� "+ this);
    }
    
	@PostConstruct
    public void init() {
        System.out.println("鍒濆鍖朎xampleBean");
    }
	@PreDestroy
    public void destroy() {
        System.out.println("閿�瘉ExampleBean");
    }
    
    public void execute() {
        System.out.println("鎵цexecute鏂规硶");
    }
	
}
