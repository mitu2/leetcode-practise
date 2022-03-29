package runstatic.leetcode.annotation;

import java.lang.annotation.*;

/**
 * @author chenmoand
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Wrong {
    String value() default "";
}
