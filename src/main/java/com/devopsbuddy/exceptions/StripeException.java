package com.devopsbuddy.exceptions;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.model.Customer;
import com.stripe.model.Token;

public class StripeException extends RuntimeException{

	public StripeException(Throwable e) {
		super(e);
	}
	
	
}
