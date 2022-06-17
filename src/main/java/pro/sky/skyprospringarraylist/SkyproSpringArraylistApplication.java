package pro.sky.skyprospringarraylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.skyprospringarraylist.services.Sort;

@SpringBootApplication
public class SkyproSpringArraylistApplication {

	public static void main(String[] args) {

		SpringApplication.run(SkyproSpringArraylistApplication.class, args);

		//замер скорости сортировок, сменить private на public
		//Sort sortService = new Sort();
		//sortService.testSpeed();
	}

}
