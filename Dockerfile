FROM registry.cn-hangzhou.aliyuncs.com/launcher/jre-1.8:acme
ENV APP_FILE report-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 8080
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -jar $APP_FILE"]
