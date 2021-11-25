package fileservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	// CORS(cross origin resource sharing) ��å�� ����
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				// ������å�� ������ ���ҽ�
				.addMapping("/**") // ��ü���ҽ��� ���(/todos, /contacts....)
				// ������å�� ����� ������(origin) ���
				// origin(��õ): html������ ������ ������ �ּ�
				// html�������� ��� ������ �޾ƿԴ����� ����ϰ� ����
				// ���� ����� ������ -> ����
				.allowedOrigins("http://localhost:3000", "http://127.0.0.1:5500/",
//						"http://3.35.51.8:3000", "http://3.35.51.8",
//						"http://ec2-3-35-51-8.ap-northeast-2.compute.amazonaws.com:3000", 
//						"http://ec2-3-35-51-8.ap-northeast-2.compute.amazonaws.com",
//						"http://15.164.211.184:3000", "http://15.164.211.184",
//						"http://ec2-15-164-211-184.ap-northeast-2.compute.amazonaws.com:3000", 
//						"http://ec2-15-164-211-184.ap-northeast-2.compute.amazonaws.com",
//						"http://3.36.125.183:3000", "http://3.36.125.183",
//						"http://ec2-3-36-125-183.ap-northeast-2.compute.amazonaws.com:3000", 
						"http://ec2-3-36-125-183.ap-northeast-2.compute.amazonaws.com")
				// ������å���� ����� HTTP�޼���
				.allowedMethods("*"); // ��ü�޼��带 ���(GET, POST, PUT....)
	}
}