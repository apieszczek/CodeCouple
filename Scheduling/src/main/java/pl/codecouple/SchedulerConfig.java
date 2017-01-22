package pl.codecouple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.LocalDateTime;


@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

    @Bean
    public ScheduledTask scheduledTask() {
        return new ScheduledTask();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        final LocalDateTime dateChange = LocalDateTime.now().plusSeconds(20);
            taskRegistrar.addFixedRateTask(new Runnable() {
                @Override
                public void run() {
                    if(LocalDateTime.now().isAfter(dateChange)) {
                        scheduledTask().executeTask();
                    }
                }
            }, 1000);
    }
}