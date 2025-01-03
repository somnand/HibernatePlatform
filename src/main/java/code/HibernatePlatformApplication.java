package code;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"code"})//TODO test this later,"types"})
public class HibernatePlatformApplication 
{
	public static void main(String[] args)throws SQLException
	{
		//Server h2Server = Server.createTcpServer("-tcp","-tcpAllowOthers", "-tcpPort", "9092", "-ifNotExists");
		//h2Server.start();
		
		SpringApplication.run(HibernatePlatformApplication.class,args);
	}
}
