package cn.example.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class MyFormatterRegister implements FormatterRegistrar{

	private String datePattern;
	
	public MyFormatterRegister(String datePattern){
		this.datePattern=datePattern;
	}
	
	public void registerFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter(datePattern));
		
		//registry more Formatter here
		
	}

}
