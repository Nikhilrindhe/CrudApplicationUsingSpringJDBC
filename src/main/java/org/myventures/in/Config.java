package org.myventures.in;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"org.myventures.in"})
public class Config {

	@Bean(name="source")
public DriverManagerDataSource setDataSource()
{
		DriverManagerDataSource source=new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUsername("root");
		source.setPassword("root");
		source.setUrl("jdbc:mysql://localhost:3306/springjdbcBookproject");
		return source;
}
	@Bean(name="template")
public JdbcTemplate settemplate()
{
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(setDataSource());
		
		return template;
}
}
