@rem ===== 1. 빌드된 jar파일을 서버에 전송 
scp -i "c:partner.pem" -r ./minam/build/libs/*.jar ubuntu@ec2-3-36-125-183.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/partner
@rem ===== 2. 기존 프로세스 종료
scp -i "c:partner.pem" ubuntu@15.164.54.22 "pkill -9 -f java"

@rem ===== 3. dev프로필로 jar 파일 실행
ssh -i "c:partner.pem" ubuntu@15.164.54.22 "cd /home/ubuntu/partner; nohup java -Dspring.profiles.active=dev -jar partner*.jar 1>partner.log 2>&1 &"


