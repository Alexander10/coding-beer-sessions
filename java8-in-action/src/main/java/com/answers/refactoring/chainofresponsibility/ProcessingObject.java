package com.answers.refactoring.chainofresponsibility;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:12 PM
 */

public abstract class ProcessingObject<T> {
	protected ProcessingObject<T> successor;

	public void setSuccessor(ProcessingObject<T> successor) {
		this.successor = successor;
	}

	public T handle(T input) {
		T r = handleWork(input);
		if (successor != null) {
			return successor.handle(r);
		}
		return r;
	}

	abstract protected T handleWork(T input);
}
