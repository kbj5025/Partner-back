@rem ===== 1. 빌드된 jar파일을 서버에 전송 
scp -i "c:partner.pem" -r ./minam/build/libs/*.jar ubuntu@ec2-3-36-125-183.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/partner
@rem ===== 2. 기존 프로세스 종료
scp -i "c:partner.pem" ubuntu@15.164.54.22 "pkill -9 -f java"