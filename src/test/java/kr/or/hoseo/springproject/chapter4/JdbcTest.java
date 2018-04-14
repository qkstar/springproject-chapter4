package kr.or.hoseo.springproject.chapter4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.hoseo.springproject.chapter4.config.AppConfig;
import kr.or.hoseo.springproject.chapter4.vo.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class JdbcTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		Member usr = jdbcTemplate.queryForObject("select * from member", 
				new BeanPropertyRowMapper<>(Member.class));
	}

}
