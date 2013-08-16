package es.luceit.mylifeinshort.transaction;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

@Transaction
@Interceptor
public class RequiredTransactionInterceptor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserTransaction utx;

	@AroundInvoke
	public Object openIfNoTransaction(final InvocationContext ic)
			throws Throwable {
		boolean startedTransaction = false;
		if (utx.getStatus() != Status.STATUS_ACTIVE) {
			utx.begin();
			startedTransaction = true;
		}

		Object ret = null;
		try {
			ret = ic.proceed();

			if (startedTransaction) {
				utx.commit();
			}
		} catch (Throwable t) {
			if (startedTransaction) {
				utx.rollback();
			}

			throw t;
		}

		return ret;
	}
}