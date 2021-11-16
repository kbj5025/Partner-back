package fileservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class FileserviceConfiguration {

	@Bean
	public AmazonS3 getS3Client() {
		AWSCredentials credentials = new BasicAWSCredentials("AKIATBXQ7J6JCEJW4YU3", "2Gcg2gNDwDrRV3Qr8IvuDSmwKDUlgyeuFQPKz1H3");
		return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AP_NORTHEAST_2)
                .build();
	}
}
