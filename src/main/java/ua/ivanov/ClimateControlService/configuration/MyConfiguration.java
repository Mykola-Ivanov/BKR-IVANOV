package ua.ivanov.ClimateControlService.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import ua.ivanov.ClimateControlService.utilities.NetworkScan;

@Configuration
@ComponentScan(basePackages = "ua.ivanov")
@PropertySource("classpath:application.properties")
class MyConfiguration{
    @Autowired
    Environment env;
    @Value("${scan.send.picow.address}")
    String picowIP;
    @Bean(name = "ipbean")
    public String picowbean(){
        String ip = "255.255.255.255";
        try {
            System.out.println(picowIP);
            String broadcastaddress=env.getProperty("scan.send.broadcast.address");
            int buffersize = Integer.parseInt(env.getProperty("scan.recieve.buffersize"));
            String message=env.getProperty("scan.send.broadcast.message");
			NetworkScan scan = new NetworkScan(broadcastaddress, buffersize, message);
		
			ip = scan.message();
			System.out.println(ip);
			
            picowIP = ip;
		} catch (IOException e) {
			e.printStackTrace();
		}
        return ip;
    }
}