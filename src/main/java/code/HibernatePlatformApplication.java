package code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"code","types"})
public class HibernatePlatformApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(HibernatePlatformApplication.class,args);
	}
}
