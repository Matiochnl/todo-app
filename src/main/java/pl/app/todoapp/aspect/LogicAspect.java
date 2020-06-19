package pl.app.todoapp.aspect;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogicAspect {
    private final Timer projectCreateGroupTimer;

     LogicAspect(final MeterRegistry registry) {
        projectCreateGroupTimer = registry.timer("Logic.project.create.group");
    }

    @Around("execution(* pl.app.todoapp.logic.ProjectService.createGroup(..))")
    void aroundProjectCreateGroup(ProceedingJoinPoint jp) {
        projectCreateGroupTimer.record(() -> {
            try {
                return jp.proceed();
            } catch (Throwable e) {
                if (e instanceof RuntimeException) {
                    throw (RuntimeException) e;
                }
                throw new RuntimeException(e);
            }

        });
    }
}
