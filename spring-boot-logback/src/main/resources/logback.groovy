import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.TRACE

scan("60 seconds")
def LOG_PATH = "/usr/local/log/"
def APP_NAME = "springboot-logback"
context.name = "${APP_NAME}"
jmxConfigurator()
appender("CONSOLE", ConsoleAppender) {
  filter(ThresholdFilter) {
	level = DEBUG
  }
  encoder(PatternLayoutEncoder) {
	pattern = "%d [%t] %5p %c:%L - %m%n"
	charset = Charset.forName("UTF-8")
  }
}
appender("INFO_FILE", RollingFileAppender) {
  file = "${LOG_PATH}${APP_NAME}-info.log"
  encoder(PatternLayoutEncoder) {
	pattern = "%d [%t] %5p %c:%L - %m%n"
	charset = Charset.forName("UTF-8")
  }
  rollingPolicy(TimeBasedRollingPolicy) {
	timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
	  maxFileSize = "100MB"
	}
	fileNamePattern = "${LOG_PATH}${APP_NAME}/info/%d{yyyy-MM-dd}-%i.log.gz"
	maxHistory = 30
  }
}
appender("ERROR_FILE", RollingFileAppender) {
  file = "${LOG_PATH}${APP_NAME}-error.log"
  filter(ThresholdFilter) {
	level = ERROR
  }
  encoder(PatternLayoutEncoder) {
	pattern = "%d [%t] %5p %c:%L - %m%n"
	charset = Charset.forName("UTF-8")
  }
  rollingPolicy(TimeBasedRollingPolicy) {
	timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
	  maxFileSize = "256MB"
	}
	fileNamePattern = "${LOG_PATH}${APP_NAME}/error/%d{yyyy-MM-dd}-%i.log.gz"
	maxHistory = 30
  }
}
logger("org.springframework.web", INFO)
logger("cn.zwqh.springboot.controller", TRACE)
logger("cn.zwqh.springboot.dao", DEBUG)
root(INFO, ["CONSOLE", "INFO_FILE", "ERROR_FILE"])