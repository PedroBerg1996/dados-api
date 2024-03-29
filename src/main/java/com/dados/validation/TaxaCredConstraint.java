package com.dados.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { TaxaCredValidator.class, TaxaCredValidatorE.class })
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TaxaCredConstraint {

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String message() default "{ }";
}
