package ua.ivanov.ClimateControlService.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ua.ivanov.ClimateControlService.utilities.NetworkScan;

@Configuration
@ComponentScan(basePackages = "ua.ivanov")
@PropertySource("classpath:application.properties")
class MyConfiguration{
    @Autowired
    Environment env;
    
    @Bean
    public String picowip(){
        String ip = "255.255.255.255";
        try {
            String broadcastaddress=env.getProperty("scan.send.broadcast.address");
            int buffersize = Integer.parseInt(env.getProperty("scan.recieve.buffersize"));
            String message=env.getProperty("scan.send.broadcast.message");
			NetworkScan scan = new NetworkScan(broadcastaddress, buffersize, message);
		
			ip = scan.message();
			System.out.println(ip);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        return ip;
    }
}