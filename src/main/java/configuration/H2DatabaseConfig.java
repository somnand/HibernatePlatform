package configuration;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2DatabaseConfig 
{
	@Bean//(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException
	{
		Server h2Server = Server.createTcpServer("-tcp","-tcpAllowOthers", "-tcpPort", "9092", "-ifNotExists");		
		h2Server.start();
		System.err.println("H2 DB Server started !");
		return h2Server;
	}
	
	//@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server(String... params) throws SQLException
	{
		return Server.createTcpServer(params[0],params[1], params[2], params[3],params[4]);
	}
}
