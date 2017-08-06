package test.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import test.model.Movie;

@Component
public class HelloService {

	@Autowired
	@Qualifier("txManager")
	private PlatformTransactionManager transactionManager;

	private static final Logger logger = Logger.getLogger(HelloService.class);

	public Movie getMovie(String movieName) {
		throw new UnsupportedOperationException();
	}

	// @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void insertMovie(String movieName) {
		logger.error("toto");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(Propagation.REQUIRED.ordinal());

		TransactionStatus status = transactionManager.getTransaction(def);
		transactionManager.commit(status);
	}

}
