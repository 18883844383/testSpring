package entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean {

	private String name;
    private int age;
    // bean瀵硅薄
    private Computer computer;
    //闆嗗悎
    private List<String> langs;
    private Set<String> cities;
    private Map<String, Object> score;
    private Properties props;
    
    public void execute() {
        System.out.println("鍩烘湰鍊硷細");
        System.out.println(name);
        System.out.println(age);
        
        System.out.println("bean瀵硅薄锛�");
        if(computer != null) {
            System.out.println(computer.getMainboard());
            System.out.println(computer.getHdd());
            System.out.println(computer.getRam());
        }
        
        
        System.out.println("缂栫▼璇█锛�");
        if(langs != null) {
            for(String lang : langs) {
                System.out.println(lang);
            }
        }
        
        System.out.println("鍩庡競锛�");
        if(cities != null) {
            for(String city : cities) {
                System.out.println(city);
            }
        }
        
        System.out.println("鍒嗘暟锛�");
        if(score != null) {
            Set<String> set = score.keySet();
            for(String key : set) {
                System.out.println(
                    key + " : " + score.get(key));
            }
        }
        
        System.out.println("鍙傛暟锛�");
        if(props != null) {
            Set<Object> propKeySet = props.keySet();
            for(Object key : propKeySet) {
                System.out.println(
                    key + " : " + props.getProperty(key.toString()));
            }
        }
    }
    
    
    
    
    
    
    
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public List<String> getLangs() {
		return langs;
	}
	public void setLangs(List<String> langs) {
		this.langs = langs;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public Map<String, Object> getScore() {
		return score;
	}
	public void setScore(Map<String, Object> score) {
		this.score = score;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
    
    
}
