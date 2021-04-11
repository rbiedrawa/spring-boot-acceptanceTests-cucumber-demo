package com.rbiedrawa.app.steps.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Adds possibility to rollback a transaction after scenario ends.
 * <remarks>not thread safe, but cucumber-jvm will instantiate an instance of any applicable hookdef class per scenario run.</remarks>
 */
@RequiredArgsConstructor
public class TransactionHooks {
	private final PlatformTransactionManager transactionManager;
	private TransactionStatus transactionStatus;

	@Before(value = "@Transactional", order = 100)
	public void startTransaction() {
		transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
	}

	@After(value = "@Transactional", order = 100)
	public void rollBackTransaction() {
		transactionManager.rollback(transactionStatus);
	}
}
